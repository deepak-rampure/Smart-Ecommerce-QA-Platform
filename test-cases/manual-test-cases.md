# ShopEase - Manual Test Cases

## Project Information

**Project Name:** Smart E-Commerce QA Platform
**Application:** ShopEase
**Testing Type:** Manual Functional Testing
**Browser:** Google Chrome
**Environment:** Local
**Tester:** Deepak Rampure

---

## Test Case Execution

| Test Case ID | Module   | Test Scenario                                           | Test Data                                                | Expected Result                                   | Actual Result                                                                              | Status |
| ------------ | -------- | ------------------------------------------------------- | -------------------------------------------------------- | ------------------------------------------------- | -------------------------------------------------------------                              | ------ |
| TC-001       | Products | Verify that products are displayed on the Products page | —                                                        | Available products should be displayed correctly  | All 6 products were displayed correctly                                                    | PASS   |
| TC-002       | Search   | Search for an existing product                          | Laptop                                                   | The matching product should be displayed          | Laptop was displayed and other products were hidden                                        | PASS   |
| TC-003       | Search   | Search for a non-existing product                       | XYZ                                                      | No matching product should be displayed           | No matching product was displayed                                                          | PASS   |
| TC-004       | Filter   | Filter products by Electronics category                 | Electronics                                              | Only Electronics products should be displayed     | Only Smartphone and Laptop were displayed                                                  | PASS   |
| TC-005       | Filter   | Filter products by Fashion category                     | Fashion                                                  | Only Fashion products should be displayed         | Only Casual T-Shirt and Running Shoes were displayed                                       | PASS   |
| TC-006       | Cart     | Add a single product to the cart                        | Laptop                                                   | Selected product should be added to the cart      | Laptop was added successfully and the cart displayed the correct item count and amount     | PASS   |
| TC-007       | Cart     | Add multiple products to the cart                       | Laptop, Smartphone                                       | All selected products should be added to the cart | Laptop and Smartphone were added and the total amount was calculated correctly             | PASS   |
| TC-008       | Cart     | Remove a product from the cart                          | Laptop                                                   | Selected product should be removed from the cart  | Laptop was removed successfully and Smartphone remained in the cart                        | PASS   |
| TC-009       | Cart     | Verify total item count                                 | Multiple products                                        | Total item count should be displayed correctly    | Total item count was displayed correctly as 2                                              | PASS   |
| TC-010       | Cart     | Verify total amount                                     | Multiple products                                        | Total amount should be calculated correctly       | Total amount was calculated correctly as ₹28,498                                           | PASS   |
| TC-011       | Login    | Login using valid credentials                           | [test@example.com](mailto:test@example.com) / Test@123   | Successful login message should be displayed      | Login successful message was displaye                                                      | PASS   |
| TC-012       | Login    | Login using invalid credentials                         | [wrong@example.com](mailto:wrong@example.com) / wrong123 | Invalid credentials message should be displayed   | Invalid email or password message was displayed                                            | PASS   |
| TC-013       | Login    | Submit login form with empty fields                     | Empty fields                                             | Required field validation should be displayed     | Required field validation was displayed                                                    | PASS   |
| TC-014       | Checkout | Open checkout with products in cart                     | Product in cart                                          | Checkout page should be displayed                 | Checkout page opened successfully and displayed the selected product and order summary     | PASS   |
| TC-015       | Checkout | Submit checkout form with empty required fields         | Empty fields                                             | Required field validation should be displayed     | Required field validation was displayed and the form was not submitted                     | PASS   |
| TC-016       | Checkout | Submit checkout without selecting payment method        | Valid customer data                                      | Payment method should be required                 | Order submission was prevented until a payment method was selected                         | PASS   |
| TC-017       | Checkout | Place order using valid customer information            | Valid customer and payment data                          | Order should be placed successfully               | Order was placed successfully                                                              | PASS   |
| TC-018       | Checkout | Verify cart after successful order                      | Valid order                                              | Cart should be cleared after successful order     | Cart was cleared successfully and total items and amount were reset to 0                   | PASS   |

---

## Test Execution Status

**Total Test Cases:** 18
**Passed:** —
**Failed:** —
**Blocked:** —
**Not Executed:** 18

---

## Test Data

### Valid Login Credentials

**Email:** `test@example.com`
**Password:** `Test@123`

### Invalid Login Credentials

**Email:** `wrong@example.com`
**Password:** `wrong123`

### Sample Products

* Laptop
* Smartphone
* Casual T-Shirt
* Running Shoes
* Wireless Headphones
* Smart Watch

### Product Categories

* Electronics
* Fashion
* Accessories

---

## Testing Notes

1. Actual Result should be recorded only after executing the test case.
2. Status should be marked as `PASS` or `FAIL` based on comparison between Expected Result and Actual Result.
3. Any failed test case should be investigated and documented as a defect when applicable.
4. Failed test cases should be retested after the defect is fixed.
5. Test execution should be performed using Google Chrome.

---

## Status Definitions

| Status       | Meaning                                                    |
| ------------ | ---------------------------------------------------------- |
| PASS         | Actual result matches the expected result                  |
| FAIL         | Actual result does not match the expected result           |
| BLOCKED      | Test execution cannot continue because of a blocking issue |
| NOT EXECUTED | Test case has not been executed yet                        |
