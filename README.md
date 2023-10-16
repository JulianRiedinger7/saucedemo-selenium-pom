## Practice

You are automating the  https://www.saucedemo.com/ web application.

Create a new Selenium - Java - TestNG project, and configure it to launch and test the required webpage on Chrome browser. Implement on your framework the following scenarios, each one as a different test:

- Purchase a product: Follow the complete buy flow of the page, selecting a random product, adding it to the cart, adding the personal data, and checking that you are successfully arriving at the “Thank you for your purchase” page.


- Removing elements of the shopping cart: Add 3 different elements to the shopping cart, enter the cart page, remove them, and check the shopping cart is empty.


- Logout: try to log out and check if you are correctly redirected to the login page.

For this implementation, follow the rules described next:

- Page Object Model should be correctly implemented, reusing certain elements and defining base pages as needed for common methods and elements.


- Page factory is required.


- Before annotations should be used to manage preconditions, any other required annotations can be implemented as needed.