import {expect, test} from "@playwright/test";

test('has title', async({ page}) => {
    await page.goto('http://localhost:5173/gardens')

    await expect(page).toHaveTitle(/Gardens/)
})

test('can navigate to individual garden link', async ({ page}) => {
    await page.goto('http://localhost:5173/gardens');

    await page.getByRole('link', {name: 'Garden with good soil'}).click();

    await expect(page.getByRole('heading', {name: 'Garden with good soil'})).toBeVisible();
})

test('can navigate to a form page for adding a garden', async ({page}) => {
    await page.goto('http://localhost:5173/gardens');
    await page.getByRole('link', {name: 'Add a garden'}).click();
    await expect(page.getByRole('heading', {name: 'Add a Garden'})).toBeVisible()
})