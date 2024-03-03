package test_cases;

import driver.BaseDrive;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;

public class TestOrderProduct extends BaseDrive {


    @Test
    public void test_add_to_cart() {
        HomePage homePage = new HomePage(driver);
        ElectronicsPage electronicsPage = new ElectronicsPage(driver);
        MattressBedroomPage mattressBedroomPage = new MattressBedroomPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        homePage.acceptCondition();
        homePage.waitForLoaderRemove();
        homePage.selectElectronicsCategory();

        electronicsPage.waitForElectronicsHeaderVisibility();
        electronicsPage.swipeDownToUp(2);
        electronicsPage.selectMattressBedroom();

        mattressBedroomPage.waitForAddToCartBtnVisibility();
        mattressBedroomPage.swipeDownToUp(2);
        mattressBedroomPage.increaseProductQuantity(1);
        mattressBedroomPage.addProductToCart();
        mattressBedroomPage.goToShoppingCart();

        Assert.assertTrue(shoppingCartPage.isMattressBedroomTitleVisible());
        Assert.assertEquals(shoppingCartPage.getItemQuantity(), "2");
    }


    @Test
    public void test_place_order() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        BillingAddressPage billingAddressPage = new BillingAddressPage(driver);
        ShippingPage shippingPage = new ShippingPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        PaymentInformationPage paymentInformationPage = new PaymentInformationPage(driver);
        ConfirmPage confirmPage = new ConfirmPage(driver);

        shoppingCartPage.checkoutAsGuest();
        String firstName = "Abu";
        String lastName = "Jafor";
        String email = "jafor@gmail.com";
        String companyName = "ABC Ltd.";
        String city = "XYZ";
        String streetAddress = "Road 211";
        String zipCode = "1230";
        billingAddressPage.fillBillingDetails(
                firstName, lastName, email, companyName, city, streetAddress, zipCode
        );
        shippingPage.selectNextDayAirThenContinue();
        paymentPage.selectCheckMoneyOrderThenContinue();
        paymentInformationPage.clickOnNextBtn();

        String billingAddress = "Email: " + email + "\n" + streetAddress + "\n" + city + "\n" + "United States of America";
        String shippingAddress = "Email: " + email + "\n" + streetAddress + "\n" + city + "\n" + "United States of America";
        String shippingMethod = "Next Day Air";
        String paymentMethod = "Check / Money Order";
        String subTotalPrice = "$2,600.00";
        String totalPrice = "$2,600.00";

        ArrayList<String> orderDetails = confirmPage.getOrderDetails();
        Assert.assertEquals(orderDetails.get(0), billingAddress);
        Assert.assertEquals(orderDetails.get(1), shippingAddress);
        Assert.assertEquals(orderDetails.get(2), shippingMethod);
        Assert.assertEquals(orderDetails.get(3), paymentMethod);

        confirmPage.swipeDownToUp(2);
        Assert.assertEquals(confirmPage.getSubTotalPrice(), subTotalPrice);
        Assert.assertEquals(confirmPage.getTotalPrice(), totalPrice);

        confirmPage.comfirmOrder();
        String orderSuccessfulMessage = "Your order has been successfully processed!";
        Assert.assertTrue(confirmPage.getOrderSuccessfulMessage().contains(orderSuccessfulMessage));
    }

}
