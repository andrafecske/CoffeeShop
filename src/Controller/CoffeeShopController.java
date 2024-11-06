package Controller;

import Models.*;
import Service.CoffeeShopService;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShopController {
    private final CoffeeShopService coffeeShopService;

    public CoffeeShopController(CoffeeShopService coffeeShopService) {
        this.coffeeShopService = coffeeShopService;
    }

    //admin

    public void addAdmin(Admin admin) {
        coffeeShopService.addAdmin(admin);
        System.out.println("Admin added successfully");
    }

    public void listAllAdmins() {
        List<Admin> admins = coffeeShopService.getAllAdmins();

        if (admins.isEmpty()) {
            System.out.println("No admins found.");
        } else {
            System.out.println("Admins found:");
            for (Admin admin : admins) {
                System.out.println(admin);
            }
        }
    }

    public void updateAdmin(Admin admin) {
        coffeeShopService.updateAdmin(admin);
        System.out.println("Admin updated successfully");
    }

    public void deleteAdmin(Admin admin) {
        coffeeShopService.deleteAdmin(admin);
        System.out.println("Admin deleted successfully");
    }

    public Admin getAdminById(Integer id) {
        return coffeeShopService.getAdminById(id);
    }

    //Client

    public void addClient(Client client) {
        coffeeShopService.addClient(client);
        System.out.println("Client added");
    }

    public void listAllClients() {
        List<Client> clients = coffeeShopService.getAllClients();

        if(clients.isEmpty()){
            System.out.println("No clients found");
        }
        else{
            System.out.println("Clients found");
            for(Client client : clients){
                System.out.println(client);
            }
        }
    }

    public Client getClientById(int id) {
        return coffeeShopService.getClientById(id); // Assumes this method exists in ClientService
    }

    public int addPoints(int clientId,int points) {
        Client client = coffeeShopService.getClientById(clientId);
        Card card = client.getCard();
        card.setCurrentPoints(card.getCurrentPoints() + points);
        card.setTotalPoints(card.getTotalPoints() + points);
        return card.getCurrentPoints();

    }

    public void removePoints(int clientId,int points) {
        Client client = coffeeShopService.getClientById(clientId);
        Card card = client.getCard();
        card.setCurrentPoints(card.getCurrentPoints() - points);
        card.setTotalPoints(card.getTotalPoints() - points);
    }

    public void deleteClient(Client client) {
        coffeeShopService.deleteClient(client);
        //System.out.println("Client deleted successfully");
    }

    public void updateClient(Client client) {
        coffeeShopService.updateClient(client);
       // System.out.println("Client updated successfully");
    }

    //coffee


    public void addCoffee(Coffee coffee) {
        coffeeShopService.addCoffee(coffee);
        System.out.println("Coffee added");
    }

    public void listAllCoffees() {
        List<Coffee> coffeeList = coffeeShopService.getAllCoffee();
        if(coffeeList.isEmpty())
            System.out.println("There are no coffees");
        else{
            for (Coffee coffee : coffeeList) {
                System.out.println(coffee);
            }
        }

    }

    public void deleteCoffee(Coffee coffee) {
        coffeeShopService.deleteCoffee(coffee);
        System.out.println("Coffee deleted successfully");
    }

    public void updateCoffee(Coffee coffee) {
        coffeeShopService.updateCoffee(coffee);
        System.out.println("Coffee updated successfully");
    }

    public Coffee getCoffeeById(int id) {
        return coffeeShopService.getCoffeeById(id);
    }

    //food


    public void addFood(Food food) {
        coffeeShopService.addFood(food);
        System.out.println("Food added");
    }

    public void listAllFoods() {
        List<Food> foodList = coffeeShopService.getAllFoods();

        if(foodList.isEmpty()) {
            System.out.println("No food found");
        }
        else {
            System.out.println("Food list:");
            for(Food food : foodList) {
                System.out.println(food);
            }
        }
    }

    public Food getFoodById(int id) {
        return coffeeShopService.getFoodById(id);
    }

    public void deleteFood(Food food) {
        coffeeShopService.deleteFood(food);
    }

    public void updateFood(Food food) {
        coffeeShopService.updateFood(food);
    }

    //order


    public Order addOrder(Integer clientId, List<Integer> foodIds, List<Integer> coffeeIds) {
        Order order = coffeeShopService.addOrder(clientId, foodIds, coffeeIds);
        int currPoints = addPoints(clientId,order.getPoints());
        System.out.println("Your current points: " + currPoints);
        return order;
    }

    public void deleteOrder(Order order, Integer clientId) {
        int pointsToDelete = order.getPoints();
        coffeeShopService.deleteOrder(order);
        removePoints(clientId,pointsToDelete);
    }

    public void updateOrder(Order order, Integer clientId) {
        int prevPoints = order.getPoints();
        coffeeShopService.updateOrder(order);
        int currPoints = order.getPoints();
        removePoints(clientId,prevPoints);
        Client client = coffeeShopService.getClientById(clientId);
        Card card = client.getCard();
        card.setCurrentPoints(card.getCurrentPoints() + currPoints);
        card.setTotalPoints(card.getTotalPoints() + currPoints);

    }

    public Order getOrderById(int id) {
        return coffeeShopService.getOrderById(id);
    }

    public List<Food> getFoods(Order order) {
        List<Food> foods = new ArrayList<>();
        for (Product product : order.getProducts()) {
            if (product instanceof Food) {
                foods.add((Food) product); // Cast product to Food and add to the list
            }
        }
        return foods;
    }

    public List<Coffee> getCoffees(Order order) {
        List<Coffee> coffees = new ArrayList<>();
        for (Product product : order.getProducts()) {
            if (product instanceof Coffee) {
                coffees.add((Coffee) product);
            }
        }return  coffees;

    }

//    public void removeFoodById(int foodid, Order order) {
//        order.getProducts().removeIf(product -> product instanceof Food && product.getId() == foodid);
//    }
//    public void removeCoffeeById(int coffeeid, Order order){
//        order.getProducts().removeIf(product -> product instanceof Coffee && product.getId() == coffeeid);
//
//        }

    public boolean removeFoodById(int foodid, Order order) {
        return order.getProducts().removeIf(product -> product instanceof Food && product.getId() == foodid);
    }

    public boolean removeCoffeeById(int coffeeid, Order order) {
        return order.getProducts().removeIf(product -> product instanceof Coffee && product.getId() == coffeeid);
    }

    public void viewPoints(Integer clientId) {
        Client client = coffeeShopService.getClientById(clientId);
        System.out.println("Your current points: " + client.getCard().getCurrentPoints());
    }

    public void viewOrders(){
        List<Order> orders = coffeeShopService.getOrders();
        if(orders.isEmpty())
            System.out.println("There are no orders");
        else{
            for (Order order : orders) {
                System.out.println(order);
            }
        }

    }

    }








