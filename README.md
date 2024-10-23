# ☕ Coffee Shop Loyalty Program

## 📝 Overview

This project simulates a Coffee Shop Loyalty Program. It is designed as an internal system to manage customer loyalty rewards, where:

Clients collect points through purchases of coffee and food.
Employees manage client accounts and product orders.
The system manages loyalty points, product customization, and employee roles. Built to handle client rewards efficiently, it streamlines the ordering process for employees.

## ✨ Main Features

Client Management: Add and manage coffee shop clients with personalized loyalty cards.

Loyalty Cards: Clients receive separate Coffee Cards and Food Cards to accumulate and redeem points for respective purchases.

Product Orders: Employees process orders, automatically tracking points earned for coffee and food.

Points System: Separate points are tracked for coffee and food products. Clients redeem points for free items once specific thresholds are met.

Employee Management: Manage employees and their roles in handling clients and orders.

## 🔧 Functional Details

Client Loyalty Cards:
Each client has two distinct loyalty cards:
CoffeeCard: Maximum of 200 points.
FoodCard: Maximum of 500 points.

Points accumulate based on purchases and can be redeemed for free items when the card reaches its max points.

Product Management:
The system manages different types of products, such as:

Coffee: Attributes like caffeine content, milk type, and extra options.

Food: Attributes like type, allergens, and whether the item is organic.

Orders:
Employees create and manage client orders, which track points earned for both coffee and food products. The system allows employees to add or remove products from the order seamlessly.
Points Accumulation and Redemption:
Clients earn points with every purchase. Once a card (CoffeeCard or FoodCard) reaches the maximum points, clients can redeem those points for free items. The system tracks and updates the balance automatically.

Employee Roles:
Employees can:
Add new clients.
Process client orders.
Manage client loyalty cards.
This system helps employees manage client interactions and loyalty points.
