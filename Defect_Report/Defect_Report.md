# Defect Report

## Project Information

| Field | Details |
|---|---|
| Project Name | Smart-Ecommerce-QA-Platform |
| Application | ShopEase E-Commerce Application |
| Testing Type | Manual Testing |
| Defect Status | Open |
| Total Defects Identified | 1 |

---

# DEF-001 — PIN Code Field Accepts Alphabetic Characters

## Defect Summary

| Field | Details |
|---|---|
| Defect ID | DEF-001 |
| Module | Checkout |
| Feature | PIN Code Validation |
| Severity | Medium |
| Priority | High |
| Status | Open |
| Found During | Manual Testing |
| Test Case | TC-018 |
| Defect Type | Validation / Functional |

---

## Description

The PIN Code field on the Checkout page accepts alphabetic characters.

A PIN Code should contain numeric characters only. However, the application allows letters to be entered into the field and still allows the order process to continue.

---

## Preconditions

1. ShopEase application is available.
2. A product has been added to the cart.
3. User has navigated to the Checkout page.

---

## Steps to Reproduce

1. Open the ShopEase application.
2. Navigate to the Products page.
3. Add any product to the cart.
4. Open the Cart.
5. Proceed to Checkout.
6. Enter valid customer information.
7. Enter alphabetic characters such as `ABCDE` in the PIN Code field.
8. Select a valid payment method.
9. Click **Place Order**.

---

## Expected Result

The PIN Code field should accept only numeric characters.

If alphabetic characters are entered, the application should display a validation message and prevent order submission.

Example:

```text
Please enter a valid PIN Code.