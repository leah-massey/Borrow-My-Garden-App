import {expect, test} from "@playwright/test";

test('has title', async({ page}) => {
    await page.goto('http://localhost:5173/gardens')

    await expect(page).toHaveTitle(/Gardens/)
})

test('can navigate to individual garden link', async ({ page}) => {
    await page.goto('http://localhost:5173/gardens');

    await page.getByRole('link', {name: 'Rose Garden'}).click();

    await expect(page.getByRole('heading', {name: 'Rose Garden'})).toBeVisible();
})

test('can navigate to a form page for adding a garden', async ({page}) => {
    await page.goto('http://localhost:5173/gardens');
    await page.getByRole('link', {name: 'Add a garden'}).click();
    await expect(page.getByRole('heading', {name: 'Add a Garden'})).toBeVisible()
})

test('a new user can create a profile', async ({page}) => {
    await page.goto('http://localhost:5173/gardens');
    await page.getByRole('link', {name: 'Log in'}).click();
    await page.waitForURL('http://localhost:5173/login');
    await expect(page.getByRole('heading', {name: 'Log in'})).toBeVisible();
    await page.getByRole('button', {name: 'Sign up'}).click();
    await page.waitForURL('http://localhost:5173/sign-up')
    await expect(page.getByRole('heading', {name: 'Sign up'}))

    await page.getByLabel('First name').fill('Maggie');
    await page.getByLabel('Last name').fill('Brown');
    await page.getByLabel('Email address').fill('maggie.brown@test.com');
    await page.getByLabel('Password').fill('test123');
    // profile image is optional
    await page.getByLabel('Bio').fill('Looking for a garden');
    await page.getByRole('button', {name: 'Submit'}).click();
    await page.waitForURL('http://localhost:5173/welcome');
    await expect(page.getByRole('heading', {name: 'Thanks for signing up, Maggie!'})).toBeVisible()
})