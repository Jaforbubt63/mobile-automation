

Automated scripts to test ecommerce mobile app
App file is located
at Download APK File From Here
https://brainstationo365-my.sharepoint.com/:u:/g/personal/faizul_islam_brainstation-23_com/ETCx8lSzo4hPn6GP0tDhcuUBchPw4Jb3D47wBCY9T82nKg
Automation script to automate the below scenarios
Scenario: 01 Customer add products in his shopping cart

Given: Mike on home page after opening nopCart mobile app
When: Mike click "electronics" from "OUR CATEGORIES" list from home page
And: Mike click to "Mattress Bedroom" product details page
And: Mike click plus button to increase Qty by "2"
Then: Mike click add to cart button to add the product in his cart

Scenario: 02 Customer successfully place order as a guest user

Given: Mike go to shopping cart by clicking top cart icon
When: Mike click checkout button from shopping cart page
And: Mike select checkout as guest from shopping cart page
Then: Mike input all the details in checkout billing details page and click continue
And: Mike select "Next Day Air" as shipping method and click continue
And: Mike select "Check/Money Order" as payment method and click continue
And: Mike click next button on payment information page
Then: Mike click confirm button to place the order
And: Verify order place successfully with popup message "Your order has been successfully processed!"


