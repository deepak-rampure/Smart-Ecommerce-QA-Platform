function addToCart(productName, price) {

    let cart = JSON.parse(localStorage.getItem("cart")) || [];

    cart.push({
        name: productName,
        price: price
    });

    localStorage.setItem("cart", JSON.stringify(cart));

    alert(productName + " added to cart!");
}


function filterProducts(category) {

    const products = document.querySelectorAll(".product-card");

    products.forEach(function(product) {

        if (
            category === "all" ||
            product.dataset.category === category
        ) {
            product.style.display = "block";
        } else {
            product.style.display = "none";
        }

    });

}


const searchInput = document.getElementById("searchInput");

if (searchInput) {

    searchInput.addEventListener("input", function() {

        const searchText =
            searchInput.value.toLowerCase();

        const products =
            document.querySelectorAll(".product-card");

        products.forEach(function(product) {

            const productName =
                product.querySelector("h3")
                .textContent
                .toLowerCase();

            if (productName.includes(searchText)) {

                product.style.display = "block";

            } else {

                product.style.display = "none";

            }

        });

    });

}

/* Cart Page */

function displayCart() {

    const cartItemsContainer =
        document.getElementById("cartItems");

    if (!cartItemsContainer) {
        return;
    }

    let cart =
        JSON.parse(localStorage.getItem("cart")) || [];

    cartItemsContainer.innerHTML = "";

    let totalItems = 0;
    let totalPrice = 0;


    if (cart.length === 0) {

        cartItemsContainer.innerHTML =
            "<p>Your cart is empty.</p>";

        document.getElementById("totalItems").textContent = 0;
        document.getElementById("totalPrice").textContent = 0;

        return;
    }


    cart.forEach(function(item, index) {

        totalItems++;

        totalPrice += item.price;

        const cartItem =
            document.createElement("div");

        cartItem.className = "cart-item";

        cartItem.innerHTML = `

            <div>
                <h3>${item.name}</h3>
                <p>₹${item.price}</p>
            </div>

            <button onclick="removeFromCart(${index})">
                Remove
            </button>

        `;

        cartItemsContainer.appendChild(cartItem);

    });


    document.getElementById("totalItems").textContent =
        totalItems;

    document.getElementById("totalPrice").textContent =
        totalPrice;

}


/* Remove Product */

function removeFromCart(index) {

    let cart =
        JSON.parse(localStorage.getItem("cart")) || [];

    cart.splice(index, 1);

    localStorage.setItem(
        "cart",
        JSON.stringify(cart)
    );

    displayCart();

}


/* Checkout */

function goToCheckout() {

    let cart =
        JSON.parse(localStorage.getItem("cart")) || [];

    if (cart.length === 0) {

        alert("Your cart is empty.");

        return;
    }

    window.location.href = "checkout.html";
}


/* Load Cart */

displayCart();

/* Login */

const loginForm =
    document.getElementById("loginForm");

if (loginForm) {

    loginForm.addEventListener(
        "submit",
        function(event) {

            event.preventDefault();

            const email =
                document.getElementById("email").value;

            const password =
                document.getElementById("password").value;

            const loginMessage =
                document.getElementById("loginMessage");


            if (
                email === "test@example.com" &&
                password === "Test@123"
            ) {

                loginMessage.textContent =
                    "Login successful!";

                loginMessage.style.marginTop = "15px";

                localStorage.setItem(
                    "loggedIn",
                    "true"
                );

            } else {

                loginMessage.textContent =
                    "Invalid email or password.";

                loginMessage.style.marginTop = "15px";

            }

        }
    );

}

/* Checkout Page */

function displayCheckout() {

    const checkoutItems =
        document.getElementById("checkoutItems");

    if (!checkoutItems) {
        return;
    }

    let cart =
        JSON.parse(localStorage.getItem("cart")) || [];

    checkoutItems.innerHTML = "";

    let totalItems = 0;
    let totalPrice = 0;


    if (cart.length === 0) {

        checkoutItems.innerHTML =
            "<p>No products in your cart.</p>";

        return;
    }


    cart.forEach(function(item) {

        totalItems++;

        totalPrice += item.price;

        const itemElement =
            document.createElement("div");

        itemElement.className =
            "checkout-item";

        itemElement.innerHTML = `
            <p>
                ${item.name}
                <strong>₹${item.price}</strong>
            </p>
        `;

        checkoutItems.appendChild(itemElement);

    });


    document.getElementById(
        "checkoutTotalItems"
    ).textContent = totalItems;


    document.getElementById(
        "checkoutTotalPrice"
    ).textContent = totalPrice;

}


/* Place Order */

const checkoutForm =
    document.getElementById("checkoutForm");

if (checkoutForm) {

    checkoutForm.addEventListener(
        "submit",
        function(event) {

            event.preventDefault();

            const payment =
                document.querySelector(
                    'input[name="payment"]:checked'
                );

            const checkoutMessage =
                document.getElementById(
                    "checkoutMessage"
                );


            if (!payment) {

                checkoutMessage.textContent =
                    "Please select a payment method.";

                return;
            }


            checkoutMessage.textContent =
                "Order placed successfully!";

            checkoutMessage.style.marginTop =
                "20px";


            localStorage.removeItem("cart");

        }
    );

}


/* Load Checkout */

displayCheckout();