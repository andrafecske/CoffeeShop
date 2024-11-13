package Controller;

import Models.*;
import Service.CoffeeShopService;
import Utils.Role;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Controller class for managing the operations of the Coffee Shop system.
 * <p>
 * This class serves as an interface between the user and the underlying service layer (CoffeeShopService).
 * It includes methods for managing admins, clients, coffee, food, orders, offers, and offer orders.
 * </p>
 */
public class CoffeeShopController {
    private final CoffeeShopService coffeeShopService;

    /**
     * Constructs a CoffeeShopController with the specified CoffeeShopService.
     *
     * @param coffeeShopService the service layer to handle business logic.
     */
    public CoffeeShopController(CoffeeShopService coffeeShopService) {
        this.coffeeShopService = coffeeShopService;
    }

    //admin
    /**
     * Adds a new admin to the system.
     *
     * @param admin the admin to be added.
     */
    public void addAdmin(Admin admin) {
        coffeeShopService.addAdmin(admin);
        System.out.println("Admin added successfully");
    }

    /**
     * Lists all the admins in the system.
     */
    public List<Admin> listAllAdmins() {
        List<Admin> admins = coffeeShopService.getAllAdmins();

        if (admins.isEmpty()) {
            System.out.println("No admins found.");
    }
        return admins;
    }

    public List<Admin> sortAdminsByName(){
        List<Admin> admins = new ArrayList<>(listAllAdmins());
        admins.sort(Comparator.comparing(Admin::getName));
        return admins;
    }

    public List<Admin> filterAdminsByRole(Role role) {
        List<Admin> admins = new ArrayList<>(listAllAdmins()); // Create a modifiable list copy

        // Use an iterator to safely remove elements
        Iterator<Admin> iterator = admins.iterator();
        while (iterator.hasNext()) {
            Admin admin = iterator.next();
            if (!admin.getRole().equals(role)) {
                iterator.remove(); // Safe removal while iterating
            }
        }

        if (admins.isEmpty()) {
            System.out.println("No admins found.");
        }
        return admins;
    }

    /**
     * Updates the details of an existing admin.
     *
     * @param admin the admin with updated details.
     */
    public void updateAdmin(Admin admin) {
        coffeeShopService.updateAdmin(admin);
        System.out.println("Admin updated successfully");
    }

    /**
     * Deletes an admin from the system.
     *
     * @param admin the admin to be deleted.
     */
    public void deleteAdmin(Admin admin) {
        coffeeShopService.deleteAdmin(admin);
        System.out.println("Admin deleted successfully");
    }

    /**
     * Retrieves an admin by their ID.
     *
     * @param id the ID of the admin to retrieve.
     * @return the admin with the specified ID.
     */
    public Admin getAdminById(Integer id) {
        return coffeeShopService.getAdminById(id);
    }

    //Client

    /**
     * Adds a new client to the system.
     *
     * @param client the client to be added.
     */
    public void addClient(Client client) {
        coffeeShopService.addClient(client);
        System.out.println("Client added");
    }

    /**
     * Lists all clients in the system.
     */
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

    /**
     * Retrieves a client by their ID.
     *
     * @param id the ID of the client to retrieve.
     * @return the client with the specified ID.
     */
    public Client getClientById(int id) {
        return coffeeShopService.getClientById(id); // Assumes this method exists in ClientService
    }

    /**
     * Adds points to a client's account.
     *
     * @param clientId the ID of the client to add points to.
     * @param points the number of points to be added.
     * @return the updated current points of the client.
     */
    public int addPoints(int clientId,int points) {
        Client client = coffeeShopService.getClientById(clientId);
        Card card = client.getCard();
        card.setCurrentPoints(card.getCurrentPoints() + points);
        coffeeShopService.updateClient(client);
        return card.getCurrentPoints();

    }

    /**
     * Removes points from a client's account.
     *
     * @param clientId the ID of the client to remove points from.
     * @param points the number of points to be removed.
     */
    public void removePoints(int clientId,int points) {
        Client client = coffeeShopService.getClientById(clientId);
        Card card = client.getCard();
        card.setCurrentPoints(card.getCurrentPoints() - points);
        coffeeShopService.updateClient(client);
    }

    /**
     * Deletes a client from the system.
     *
     * @param client the client to be deleted.
     */
    public void deleteClient(Client client) {
        coffeeShopService.deleteClient(client);
        //System.out.println("Client deleted successfully");
    }

    /**
     * Updates the details of an existing client.
     *
     * @param client the client with updated details.
     */
    public void updateClient(Client client) {
        coffeeShopService.updateClient(client);
       // System.out.println("Client updated successfully");
    }

    //coffee


    /**
     * Adds a new coffee to the system.
     *
     * @param coffee the coffee to be added.
     */
    public void addCoffee(Coffee coffee) {
        coffeeShopService.addCoffee(coffee);
        System.out.println("Coffee added");
    }

    /**
     * Lists all coffees in the system.
     */
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

    /**
     * Deletes a coffee from the system.
     *
     * @param coffee the coffee to be deleted.
     */
    public void deleteCoffee(Coffee coffee) {
        coffeeShopService.deleteCoffee(coffee);
        System.out.println("Coffee deleted successfully");
    }

    /**
     * Updates the details of an existing coffee.
     *
     * @param coffee the coffee with updated details.
     */
    public void updateCoffee(Coffee coffee) {
        coffeeShopService.updateCoffee(coffee);
        System.out.println("Coffee updated successfully");
    }

    /**
     * Retrieves a coffee by its ID.
     *
     * @param id the ID of the coffee to retrieve.
     * @return the coffee with the specified ID.
     */
    public Coffee getCoffeeById(int id) {
        return coffeeShopService.getCoffeeById(id);
    }

    //food

    /**
     * Adds a new food item to the system.
     *
     * @param food the food to be added.
     */
    public void addFood(Food food) {
        coffeeShopService.addFood(food);
        System.out.println("Food added");
    }

    /**
     * Lists all food items in the system.
     */
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

    /**
     * Retrieves a food item by its ID.
     *
     * @param id the ID of the food to retrieve.
     * @return the food with the specified ID.
     */
    public Food getFoodById(int id) {
        return coffeeShopService.getFoodById(id);
    }


    /**
     * Deletes a food item from the system.
     *
     * @param food the food to be deleted.
     */
    public void deleteFood(Food food) {
        coffeeShopService.deleteFood(food);
    }

    /**
     * Updates the details of an existing food item.
     *
     * @param food the food with updated details.
     */
    public void updateFood(Food food) {
        coffeeShopService.updateFood(food);
    }

    //order

    /**
     * Adds a new order for a client.
     *
     * @param clientId the ID of the client placing the order.
     * @param foodIds the list of food item IDs for the order.
     * @param coffeeIds the list of coffee item IDs for the order.
     * @return the created order.
     */
    public Order addOrder(Integer clientId, List<Integer> foodIds, List<Integer> coffeeIds) {
        Order order = coffeeShopService.addOrder(clientId, foodIds, coffeeIds);
        int currPoints = addPoints(clientId,order.getPoints());
        System.out.println("Your current points: " + currPoints);
        return order;
    }

    /**
     * Deletes an order for a client.
     *
     * @param order the order to be deleted.
     * @param clientId the ID of the client who placed the order.
     */
    public void deleteOrder(Order order, Integer clientId) {
        int pointsToDelete = order.getPoints();
        coffeeShopService.deleteOrder(order);
        removePoints(clientId,pointsToDelete);
    }

    /**
     * Updates an existing order for a client.
     *
     * @param order the order with updated details.
     * @param clientId the ID of the client who placed the order.
     */
    public void updateOrder(Order order, Integer clientId) {
        int prevPoints = order.getPoints();
        coffeeShopService.updateOrder(order);
        int currPoints = order.getPoints();
        removePoints(clientId,prevPoints);
        Client client = coffeeShopService.getClientById(clientId);
        Card card = client.getCard();
        card.setCurrentPoints(card.getCurrentPoints() + currPoints);

    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order to retrieve.
     * @return the order with the specified ID.
     */
    public Order getOrderById(int id) {
        return coffeeShopService.getOrderById(id);
    }

    /**
     * Retrieves a list of all food items in a given order.
     *
     * @param order the order containing the food items.
     * @return a list of food items in the order.
     */
    public List<Food> getFoods(Order order) {
        List<Food> foods = new ArrayList<>();
        for (Product product : order.getProducts()) {
            if (product instanceof Food) {
                foods.add((Food) product); // Cast product to Food and add to the list
            }
        }
        return foods;
    }

    /**
     * Retrieves a list of all coffee items in a given order.
     *
     * @param order the order containing the coffee items.
     * @return a list of coffee items in the order.
     */
    public List<Coffee> getCoffees(Order order) {
        List<Coffee> coffees = new ArrayList<>();
        for (Product product : order.getProducts()) {
            if (product instanceof Coffee) {
                coffees.add((Coffee) product);
            }
        }return  coffees;

    }



    /**
     * Removes a food item by its ID from the order.
     *
     * @param foodid the ID of the food item to be removed.
     * @param order the order from which the food item will be removed.
     * @return true if the food item was successfully removed, false otherwise.
     */
    public boolean removeFoodById(int foodid, Order order) {
        return order.getProducts().removeIf(product -> product instanceof Food && product.getId() == foodid);
    }

    /**
     * Removes a coffee item by its ID from the order.
     *
     * @param coffeeid the ID of the coffee item to be removed.
     * @param order the order from which the coffee item will be removed.
     * @return true if the coffee item was successfully removed, false otherwise.
     */
    public boolean removeCoffeeById(int coffeeid, Order order) {
        return order.getProducts().removeIf(product -> product instanceof Coffee && product.getId() == coffeeid);
    }

    /**
     * Displays the current points of a client.
     *
     * @param clientId the ID of the client whose points will be displayed.
     */
    public void viewPoints(Integer clientId) {
        Client client = coffeeShopService.getClientById(clientId);
        System.out.println("Your current points: " + client.getCard().getCurrentPoints());
    }

    /**
     * Displays all orders in the system.
     */
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

    /**
     * Retrieves all orders in the system.
     *
     * @return a list of all orders.
     */
    public List<Order> getAllOrders(){
        return coffeeShopService.getOrders();
    }

    public List<Order> sortClientOrdersByPrice(Integer clientId){
        List<Order> orders = new ArrayList<>(getAllOrders());

        List<Order> clientOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getClientID().equals(clientId)) {
                clientOrders.add(order);
            }
        }

        clientOrders.sort(Comparator.comparingDouble(Order::getTotalCost));

        return clientOrders;
    }

    /**
     * Adds a new offer to the system.
     *
     * @param foodIds the list of food IDs included in the offer.
     * @param coffeeIds the list of coffee IDs included in the offer.
     * @param pointCost the point cost for the offer.
     * @return the created offer.
     */
    public Offer addOffer(List<Integer> foodIds, List<Integer> coffeeIds, int pointCost, String name) {
        return coffeeShopService.addOffer(foodIds, coffeeIds, pointCost, name);

    }

    /**
     * Lists all offers available in the system.
     */
    public void listAllOffers() {
        List<Offer> offers = coffeeShopService.getAllOffers();
        if(offers.isEmpty()) {
            System.out.println("No offer found");
        }
        else {
            System.out.println("Offer list:");
            for(Offer offer : offers) {
                System.out.println(offer);
            }
        }
    }


    public void listAllOffersClients(Integer clientID) {
        List<Offer> offers = coffeeShopService.getAllOffers();
        Client client = coffeeShopService.getClientById(clientID);
        if(offers.isEmpty()) {
            System.out.println("No offer found");
        }
        else {
            System.out.println("Offer list:");
            for(Offer offer : offers) {
                if(offer.pointCost < client.getCard().getCurrentPoints())
                {System.out.println(offer.clientView());}
            }
        }
    }

    public List<Offer> getAllOffers(){
        return coffeeShopService.getAllOffers();
    }

    //OFFER ORDER OPERATIONS

    /**
     * Adds an offer order for a client.
     *
     * @param offerId  the ID of the offer being ordered.
     * @param clientId the ID of the client placing the order.
     */
    public void addOfferOrder(Integer offerId, Integer clientId){
        coffeeShopService.addOfferOrder(offerId, clientId);
        Offer offer = getOfferById(offerId);
        removePoints(clientId, offer.getPointCost());
    }


    //UTILS

    /**
     * Deletes an offer from the system.
     *
     * @param offer the offer to be deleted.
     */

    public void deleteOffer(Offer offer) {
        coffeeShopService.deleteOffer(offer);
    }


    /**
     * Retrieves an offer by its ID.
     *
     * @param id the ID of the offer to retrieve.
     * @return the offer with the specified ID.
     */
    public Offer getOfferById(int id) {
        return coffeeShopService.getOfferById(id);
    }
}








