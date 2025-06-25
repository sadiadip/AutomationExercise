package tests;

import org.example.pages.MyCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyCartTest extends BaseTest {

    @Test
    public void addProductsInCartShouldSucceed() throws InterruptedException {
        MyCartPage myCartPage = new MyCartPage(driver);

        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

        myCartPage.clickProductsButton();
        Thread.sleep(2000);
        myCartPage.clickFirstItemAddToCart();
        Thread.sleep(2000);
        myCartPage.clickContinueShoppingButton();
        Thread.sleep(2000);
        myCartPage.clickSecondItemAddToCart();
        Thread.sleep(2000);
        myCartPage.clickViewCart();
        Thread.sleep(2000);

        int itemCount = myCartPage.getCartItemCount();
        Thread.sleep(2000);

        Assert.assertEquals(itemCount, 2, "Expected 2 items in cart, but found: ");
    }

    @Test
    public void removeProductsFromCartShouldSucceed() throws InterruptedException {
        String expectedMessage = "Cart is empty!";
        MyCartPage myCartPage = new MyCartPage(driver);

        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

        myCartPage.clickProductsButton();
        Thread.sleep(2000);
        myCartPage.clickFirstItemAddToCart();
        Thread.sleep(2000);
        myCartPage.clickViewCart();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getTitle().contains("Automation Exercise - Checkout"));

        myCartPage.clickDeleteButtonForFirstItem();
        Thread.sleep(2000);

        String actualMessage = myCartPage.getEmptyCartMessageText();
        Thread.sleep(2000);

        Assert.assertTrue(actualMessage.contains(expectedMessage), "Expected empty cart message not found!");
    }
}
