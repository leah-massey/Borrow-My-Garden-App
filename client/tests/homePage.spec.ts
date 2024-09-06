import {expect, test} from "@playwright/test";

test('has title', async({ page}) => {
    await page.goto('http://localhost:5173/')

    await expect(page).toHaveTitle(/Gardens/)
})

test('individual garden link', async ({ page}) => {
    await page.goto('http://localhost:5173/');

    await page.getByRole('link', {name: 'Garden with good soil'}).click();

    await expect(page.getByRole('heading', {name: 'Garden with good soil'})).toBeVisible();
})