import {test} from "@playwright/test";

// test('pressing the delete button deletes the garden and returns you to the garden list page', async ({page}) => {
//     await page.goto('http://localhost:5173/gardens/0ce7f21c-eade-4ee0-ab0e-0b9cb5b5c053')
//     await page.getByRole('button', {name: 'Delete'}).click();
//     await page.waitForURL('http://localhost:5173/gardens');
//     // write a line that shows garden 0ce7f21c-eade-4ee0-ab0e-0b9cb5b5c053 is no longer listed.
// })