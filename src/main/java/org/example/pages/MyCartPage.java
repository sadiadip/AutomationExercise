package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCartPage {
    public WebDriver driver;

    public MyCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProductsButton() {
        driver.findElement(By.xpath("//a[@href='/products']")).click();
    }

    public void clickFirstItemAddToCart() {
        driver.findElement(By.cssSelector("a[data-product-id='1']")).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
    }

    public void clickSecondItemAddToCart() {
        driver.findElement(By.cssSelector("a[data-product-id='2']")).click();
    }

    public void clickViewCart() {
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
    }

    public int getCartItemCount() {
        return driver.findElements(By.cssSelector("tbody h4 a")).size();
    }

    public void clickDeleteButtonForFirstItem() {
        driver.findElement(By.cssSelector("a.cart_quantity_delete[data-product-id='1']")).click();
    }

    public String getEmptyCartMessageText() {
        return driver.findElement(By.id("empty_cart")).getText().trim();
    }
}
