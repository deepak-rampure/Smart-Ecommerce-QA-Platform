const express = require("express");
const mysql = require("mysql2");

const app = express();

const PORT = 5000;

app.use(express.json());

/* MySQL Database Connection */
const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "ShopEase@123",
    database: "shopease"
});

db.connect(function(error) {
    if (error) {
        console.log("Database connection failed:", error.message);
        return;
    }

    console.log("MySQL database connected successfully!");
});

/* Home API */
app.get("/", function(req, res) {
    res.send("ShopEase Backend is running!");
});

/* Get All Products from MySQL */
app.get("/api/products", function(req, res) {
    db.query("SELECT * FROM products", function(error, results) {
        if (error) {
            return res.status(500).json({
                message: "Database error"
            });
        }

        res.json(results);
    });
});

/* Get Product by ID */
app.get("/api/products/:id", function(req, res) {
    const productId = parseInt(req.params.id);

    const query = "SELECT * FROM products WHERE id = ?";

    db.query(query, [productId], function(error, results) {
        if (error) {
            return res.status(500).json({
                message: "Database error"
            });
        }

        if (results.length === 0) {
            return res.status(404).json({
                message: "Product not found"
            });
        }

        res.json(results[0]);
    });
});

/* Login API */
app.post("/api/login", function(req, res) {
    const { email, password } = req.body;

    const query = "SELECT * FROM users WHERE email = ? AND password = ?";

    db.query(query, [email, password], function(error, results) {
        if (error) {
            return res.status(500).json({
                message: "Database error"
            });
        }

        if (results.length === 0) {
            return res.status(401).json({
                message: "Invalid email or password."
            });
        }

        res.status(200).json({
            message: "Login successful!",
            user: {
                id: results[0].id,
                name: results[0].name,
                email: results[0].email
            }
        });
    });
});
/* Create Order API */
app.post("/api/orders", function(req, res) {
    const { customer, items, totalAmount, paymentMethod } = req.body;

    if (
        !customer ||
        !items ||
        items.length === 0 ||
        !totalAmount ||
        !paymentMethod
    ) {
        return res.status(400).json({
            message: "Invalid order details"
        });
    }

    const userId = customer.userId || null;

    const orderQuery = `
        INSERT INTO orders
        (user_id, total_amount, payment_method, status)
        VALUES (?, ?, ?, ?)
    `;

    db.query(
        orderQuery,
        [userId, totalAmount, paymentMethod, "Order placed successfully"],
        function(error, result) {
            if (error) {
                return res.status(500).json({
                    message: "Failed to create order"
                });
            }

            const orderId = result.insertId;

            const itemValues = items.map(function(item) {
                return [
                    orderId,
                    item.id,
                    item.quantity || 1,
                    item.price
                ];
            });

            const itemQuery = `
                INSERT INTO order_items
                (order_id, product_id, quantity, price)
                VALUES ?
            `;

            db.query(itemQuery, [itemValues], function(error) {
                if (error) {
                    return res.status(500).json({
                        message: "Failed to save order items"
                    });
                }

                res.status(201).json({
                    message: "Order placed successfully",
                    orderId: orderId,
                    totalAmount: totalAmount,
                    paymentMethod: paymentMethod,
                    status: "Order placed successfully"
                });
            });
        }
    );
});

/* Start Server */
app.listen(PORT, function() {
    console.log(`Server running on http://localhost:${PORT}`);
});