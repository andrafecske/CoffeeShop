# ☕ Coffee Shop Loyalty Program

## 📝 Overview

This project simulates a Coffee Shop Loyalty Program. It is designed as an internal system to manage customer loyalty rewards, where:

Clients collect points through purchases of coffee and food.
Employees manage clients, orders and products.
The system manages loyalty points, product customization, and employee roles.

## ✨ Main Features

Client Management: Add and manage coffee shop clients with personalized loyalty cards.

Loyalty Cards: Clients receive separate Coffee Cards and Food Cards to accumulate and redeem points for respective purchases.

Orders: Employees process orders, automatically tracking points earned for coffee and food.

Points System: Separate points are tracked for coffee and food products. Clients have the option to redeem points when making an order, when the specific criteria is met.

## 🔧 Functional Details

Client Loyalty Cards:
Each client has two distinct loyalty cards:
CoffeeCard: Maximum of 200 points.
FoodCard: Maximum of 500 points.

Points accumulate based on purchases and can be redeemed for free items when the card reaches its max points.

Product Management:
The system manages different types of products, such as:

Coffee: Attributes like caffeine content, milk type, and extra options(in case the client adds extra stuff, the price increases).

Food: Attributes like type, allergens, and whether the item is organic.

Orders:
Employees create and manage client orders, which track points earned for both coffee and food products. The system allows employees to add, update or remove products from the order and from the menu.
Points Accumulation and Redemption:
Clients earn points with every purchase. Once a card (CoffeeCard or FoodCard) reaches the maximum points, clients can redeem those points for free items. If they don't redeem the points, any purchase made after the card is maxed out, does not add to the previous points. The system tracks and updates the balance automatically.

Employees can:
Add new clients.
Manage the products (menu).
Manage client orders.
Manage client loyalty cards.
This system helps employees manage client interactions and loyalty points.

![image](https://github.com/user-attachments/assets/d0f1c06b-9a69-4319-a7af-11ffbf1be216)


