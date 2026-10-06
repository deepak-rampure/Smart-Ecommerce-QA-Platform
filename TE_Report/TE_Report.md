# Test Execution Report

## Project Information

| Field | Details |
|---|---|
| Project Name | Smart-Ecommerce-QA-Platform |
| Application | ShopEase E-Commerce Application |
| Testing Type | Functional, UI, Automation |
| Automation Tool | Selenium WebDriver |
| Test Framework | TestNG |
| Build Tool | Maven |
| Programming Language | Java |
| Browser | Google Chrome |
| Test Cases Executed | 18 |
| Test Cases Passed | 18 |
| Test Cases Failed | 0 |
| Test Cases Skipped | 0 |
| Overall Result | PASS |

---

## Test Environment

| Component | Details |
|---|---|
| Operating System | Windows 11 |
| Browser | Google Chrome |
| Automation | Selenium WebDriver 4.35.0 |
| Test Framework | TestNG 7.11.0 |
| Build Tool | Maven 3.9.9 |
| Java | Java 26.0.1 |
| Application | ShopEase |
| Frontend | HTML, CSS, JavaScript |
| Backend | Node.js, Express.js |
| Database | MySQL 8.0 |

---

## Test Execution Summary

| Metric | Count |
|---|---:|
| Total Test Cases | 18 |
| Passed | 18 |
| Failed | 0 |
| Skipped | 0 |
| Pass Percentage | 100% |
| Fail Percentage | 0% |

---

# Test Case Execution Details



## TC-001 — Verify Products Displayed

**Automation Class:** `FirstSeleniumTest.java`

**Test Scenario:** Verify that products are displayed correctly on the application.

**Expected Result:** Products should be displayed successfully.

**Actual Result:** Products were displayed successfully.

**Status:** PASS

---

## TC-002 — Search Existing Product

**Automation Class:** `SecondSeleniumTest.java`

**Test Scenario:** Search for an existing product such as Laptop.

**Expected Result:** Matching product should be displayed and unrelated products should be hidden.

**Actual Result:** Laptop was displayed successfully.

**Status:** PASS

---

## TC-003 — Search Non-Existing Product

**Automation Class:** `ThirdSeleniumTest.java`

**Test Scenario:** Search for a product that does not exist.

**Expected Result:** No matching product should be displayed.

**Actual Result:** No matching product was displayed.

**Status:** PASS

---

## TC-004 — Electronics Category Filter

**Automation Class:** `FourthSeleniumTest.java`

**Test Scenario:** Filter products using the Electronics category.

**Expected Result:** Smartphone and Laptop should be displayed.

**Actual Result:** Electronics products were displayed successfully.

**Status:** PASS

---

## TC-005 — Fashion Category Filter

**Automation Class:** `FifthSeleniumTest.java`

**Test Scenario:** Filter products using the Fashion category.

**Expected Result:** Casual T-Shirt and Running Shoes should be displayed.

**Actual Result:** Fashion products were displayed successfully.

**Status:** PASS

---

## TC-006 — Add Single Product to Cart

**Automation Class:** `SixthSeleniumTest.java`

**Test Scenario:** Add Laptop to the shopping cart.

**Expected Result:** Laptop should be added and the correct amount should be displayed.

**Actual Result:** Laptop was added successfully.

**Status:** PASS

---

## TC-007 — Add Multiple Products to Cart

**Automation Class:** `SeventhSeleniumTest.java`

**Test Scenario:** Add Laptop and Smartphone to the cart.

**Expected Result:** Both products should be added and the total amount should be ₹84,998.

**Actual Result:** Both products were added and the total amount was verified.

**Status:** PASS

---

## TC-008 — Remove Product from Cart

**Automation Class:** `EighthSeleniumTest.java`

**Test Scenario:** Remove Laptop from the cart.

**Expected Result:** Laptop should be removed while the remaining product should stay in the cart.

**Actual Result:** Product removal was verified successfully.

**Status:** PASS

---

## TC-009 — Verify Total Item Count

**Automation Class:** `NinthSeleniumTest.java`

**Test Scenario:** Add multiple products and verify the total item count.

**Expected Result:** Cart should display the correct number of items.

**Actual Result:** Total item count was verified successfully.

**Status:** PASS

---

## TC-010 — Verify Total Amount

**Automation Class:** `TenthSeleniumTest.java`

**Test Scenario:** Add multiple products and verify the calculated total amount.

**Expected Result:** The total amount should be calculated correctly based on selected products.

**Actual Result:** Total amount of ₹28,297 was calculated and verified successfully.

**Status:** PASS

---

## TC-011 — Login with Valid Credentials

**Automation Class:** `EleventhSeleniumTest.java`

**Test Scenario:** Login using valid email and password.

**Expected Result:** Login should be successful.

**Actual Result:** Successful login was verified.

**Status:** PASS

---

## TC-012 — Login with Invalid Credentials

**Automation Class:** `TwelfthSeleniumTest.java`

**Test Scenario:** Login using invalid email and password.

**Expected Result:** Invalid credentials message should be displayed.

**Actual Result:** Invalid credentials validation was verified.

**Status:** PASS

---

## TC-013 — Login with Empty Fields

**Automation Class:** `ThirteenthSeleniumTest.java`

**Test Scenario:** Attempt login without entering required fields.

**Expected Result:** Required field validation should be triggered.

**Actual Result:** Required field validation was verified.

**Status:** PASS

---

## TC-014 — Open Checkout with Products

**Automation Class:** `FourteenthSeleniumTest.java`

**Test Scenario:** Add a product and proceed to checkout.

**Expected Result:** Checkout page should be displayed.

**Actual Result:** Checkout page was opened successfully.

**Status:** PASS

---

## TC-015 — Checkout with Empty Required Fields

**Automation Class:** `FifteenthSeleniumTest.java`

**Test Scenario:** Attempt to place an order without entering required customer information.

**Expected Result:** Required field validation should prevent order submission.

**Actual Result:** Required field validation was triggered successfully.

**Status:** PASS

---

## TC-016 — Checkout Without Payment Method

**Automation Class:** `SixteenthSeleniumTest.java`

**Test Scenario:** Attempt to place an order without selecting a payment method.

**Expected Result:** Order should not be submitted until a payment method is selected.

**Actual Result:** Order submission was prevented successfully.

**Status:** PASS

---

## TC-017 — Successful Checkout

**Automation Class:** `SeventeenthSeleniumTest.java`

**Test Scenario:** Enter valid customer details, select a payment method, and place the order.

**Expected Result:** Order should be placed successfully.

**Actual Result:** Order was placed successfully.

**Status:** PASS

---

## TC-018 — Verify Cart Cleared After Successful Order

**Automation Class:** `EighteenthSeleniumTest.java`

**Test Scenario:** Verify that the cart is cleared after successfully placing an order.

**Expected Result:** Cart should be empty/reset after successful order placement.

**Actual Result:** Cart was verified as cleared after successful order placement.

**Status:** PASS

---

# Automation Execution Summary

All 18 automated test cases were executed using Selenium WebDriver with TestNG and Maven.

```text
Total Tests     : 18
Passed          : 18
Failed          : 0
Skipped         : 0
Pass Percentage : 100%
Fail Percentage : 0%