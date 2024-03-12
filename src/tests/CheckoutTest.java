package tests;

import org.junit.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsListPage;

public class CheckoutTest extends BaseTest {
  String expectedPageTitle = "Checkout: Complete!";

  @Test
  public void checkoutProcess() {
    LoginPage loginPage = new LoginPage(driver);
    ProductsListPage productsListPage = new ProductsListPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    loginPage.goToLoginPage(); // RADI!
    loginPage.login(validUsername, validPassword);
    productsListPage.addToCartFunction();
    productsListPage.navigateToCartPage();
    cartPage.goToCheckoutPage();
    checkoutPage.inputCredentialsCheckout("Pera", "Peric", "11000");
    checkoutPage.navToCheckoutPage2();
    checkoutPage.finishOrder();
    checkoutPage.verifyCompletedOrder("Checkout: Complete!");
  }

  @Test
  public void verifyTotalProductPrice() {
    LoginPage loginPage = new LoginPage(driver);
    ProductsListPage productsListPage = new ProductsListPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    loginPage.goToLoginPage(); // RADI!
    loginPage.login(validUsername, validPassword);
    productsListPage.addToCartFunction();
    productsListPage.navigateToCartPage();
    cartPage.goToCheckoutPage();
    checkoutPage.inputCredentialsCheckout("Pera", "Peric", "11000");
    checkoutPage.navToCheckoutPage2();
    checkoutPage.verifyItemPrice();

  }

}
