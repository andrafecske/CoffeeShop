package Service;

import Models.*;
import Repository.IRepository;
import Utils.FoodType;
import Utils.MilkType;
import Utils.Role;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShopService {
    private final IRepository<Admin> adminRepo;
    private final IRepository<Client> clientRepo;
    private final IRepository<Coffee> coffeeRepo;
    private final IRepository<Food> foodRepo;
    private IRepository<Order> orderRepo;
    private final IRepository<Offer> offerRepo;
    private final IRepository<OfferOrder> offerOrderRepo;

    //admin service

    public CoffeeShopService(IRepository<Admin> adminRepo, IRepository<Client> clientRepo, IRepository<Coffee> coffeeRepo, IRepository<Food> foodRepo, IRepository<Order> orderRepo, IRepository<Offer> offerRepo, IRepository<OfferOrder> offerOrderRepo) {
        this.adminRepo = adminRepo;
        this.clientRepo = clientRepo;
        this.coffeeRepo = coffeeRepo;
        this.foodRepo = foodRepo;
        this.orderRepo = orderRepo;
        this.offerRepo = offerRepo;
        this.offerOrderRepo = offerOrderRepo;
        initializeRepositories();
    }
    private void initializeRepositories() {
        Admin admin1 = new Admin(1, 21, "Sara", Role.Manager);
        Admin admin2 = new Admin(2, 30, "Sara", Role.Manager);
        adminRepo.create(admin1);
        adminRepo.create(admin2);

        Client client1 = new Client(1, 21,"Maria Nastase");
        Client client2 = new Client(2, 22,"Luana Eram");
        clientRepo.create(client1);
        clientRepo.create(client2);

        Coffee coffee1 = new Coffee(1, 23, 100, "Pumpkin Spice Latte", true, MilkType.WHOLE);
        Coffee coffe2 = new Coffee(2, 20, 89, "Caramel Large Latte", true, MilkType.WHOLE);
        coffeeRepo.create(coffee1);
        coffeeRepo.create(coffe2);

        Food food1 = new Food(1, 20, 50, "Chicken Sandwich", FoodType.SANDWICH);
        Food food2 = new Food(2, 26, 80, "Chickpea Salad", FoodType.MEAL);
        foodRepo.create(food1);
        foodRepo.create(food2);
    }

    public void addAdmin(Admin admin) {
        if(admin == null) {
            System.out.println("Admin is null");
            return;
        }

        adminRepo.create(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.getAll();
    }

    public void updateAdmin(Admin admin) {
        if(admin == null){
            System.out.println("Admin is null");
            return;}

        Admin exists = adminRepo.read(admin.getId());
        if (exists != null) {
            adminRepo.update(admin.getId(), admin);
        } else {
            System.out.println("Admin not found");
        }
    }

    public void deleteAdmin(Admin admin) {
        if(admin == null){
            System.out.println("Admin is null");
            return;}

        Admin exists = adminRepo.read(admin.getId());
        if (exists != null) {
            adminRepo.delete(admin.getId());
        }else{
            System.out.println("Admin not found");
        }
    }

    public Admin getAdminById(Integer adminId) {
        return adminRepo.read(adminId);
    }

    //Client service

    public void addClient(Client client){
        if(client == null){
            System.out.println("Client is null");
            return;
        }
        if(isAdminDuplicate(client)){
            System.out.println("Can't create client, there is already an admin with the same name and id");
        }
        clientRepo.create(client);
        System.out.println("Client added successfully");
    }

    public List<Client> getAllClients(){
        return clientRepo.getAll();
    }

    private boolean isAdminDuplicate(Client client){
        List<Admin> admins = adminRepo.getAll();
        for(Admin admin : admins){
            if(admin.getName().equals(client.getName()) && admin.getId().equals(client.getId())){
                return true;
            }
        }
        return false;
    }

    public Client getClientById(int id){
        return clientRepo.read(id);
    }

    public void deleteClient(Client client){
        if(client == null){
            System.out.println("Client is null");
            return;
        }
        clientRepo.delete(client.getId());
        System.out.println("Client deleted successfully");

    }

    public void updateClient(Client client){
        if(client == null){
            System.out.println("Client is null");
            return;
        }
        Client exists = clientRepo.read(client.getId());
        if (exists != null) {
            clientRepo.update(client.getId(), client);
        }else{
            System.out.println("Client not found");
        }
    }


    //coffeeService

    public void addCoffee(Coffee coffee){
        if(coffee == null){
            System.out.println("Coffee is null");
            return;
        }

        coffeeRepo.create(coffee);
    }

    public List<Coffee> getAllCoffee(){
        return coffeeRepo.getAll();
    }

    public Coffee getCoffeeById(int id){
        return coffeeRepo.read(id);
    }

    public void deleteCoffee(Coffee coffee){
        if(coffee == null){
            System.out.println("Coffee is null");
            return;
        }
        coffeeRepo.delete(coffee.getId());
    }

    public void updateCoffee(Coffee coffee){
        if(coffee == null){
            System.out.println("Coffee is null");
            return;
        }
        Coffee exists = coffeeRepo.read(coffee.getId());
        if (exists != null) {
            coffeeRepo.update(coffee.getId(), coffee);
            System.out.println("Coffee updated successfully");
        }else {
            System.out.println("Coffee not found");
        }

    }

    //foodService


    public void addFood(Food food){
        if(food == null){
            System.out.println("Food is null");
            return;
        }

        foodRepo.create(food);
    }

    public List<Food> getAllFoods(){
        return foodRepo.getAll();
    }

    public Food getFoodById(int id){
        return  foodRepo.read(id);
    }

    public void deleteFood(Food food){
        if(food == null){
            System.out.println("Food is null");
            return;
        }
        foodRepo.delete(food.getId());
    }

    public void updateFood(Food food){
        if(food == null){
            System.out.println("Food is null");
            return;
        }
        Food exists = foodRepo.read(food.getId());
        if (exists != null) {
            foodRepo.update(food.getId(), food);
            System.out.println("Food updated successfully");
        }else{
            System.out.println("Food not found");
        }
    }


    //orderService


    public Order addOrder(Integer clientID, List<Integer> foodIDs, List<Integer> coffeeIDs) {
        int orderId = generateOrderID();
        List<Product> products = new ArrayList<>();
        for (Integer foodID : foodIDs) {
            Food food = getFoodById(foodID);
            products.add(food);
        }
        for (Integer coffeeID : coffeeIDs) {
            Coffee coffee = getCoffeeById(coffeeID);
            products.add(coffee);
        }
        Order order = new Order(orderId,clientID, products);

        orderRepo.create(order);
        return order;
    }



    public List<Order> getOrders() {
        return orderRepo.getAll();
    }

    public Order getOrderById(Integer orderID) {
        return orderRepo.read(orderID);
    }

    public void finalizeOrder(Order order) {
        order.calculatePoints();
    }

    public void updateOrder(Order order) {
        if (order == null) {
            System.out.println("Order is null");
            return;}

            Order exists = orderRepo.read(order.getId());
            if (exists != null) {
                order.calculatePoints();
                order.calculateTotalCost();
                orderRepo.update(order.getId(), order);
                System.out.println("Order updated successfully");
            }else{
                System.out.println("Order not found");
        }
    }

    public void deleteOrder(Order order) {
        if (order == null) {
            System.out.println("Order is null");
            return;
        }
        orderRepo.delete(order.getId());
    }

    //OFFER OPERATIONS

   public Offer addOffer(List<Integer> foodIds, List<Integer> coffeeIds, int pointCost) {
        int offerId = generateOfferID();

       List<Product> products = new ArrayList<>();
       for (Integer foodID : foodIds) {
           Food food = getFoodById(foodID);
           products.add(food);
       }
       for (Integer coffeeID : coffeeIds) {
           Coffee coffee = getCoffeeById(coffeeID);
           products.add(coffee);
       }
       Offer offer = new Offer(offerId, products, pointCost);
        offerRepo.create(offer);
        return offer;
   }

   public Offer getOfferById(Integer id) {
        return offerRepo.read(id);
   }

   public List<Offer> getAllOffers() {
        return offerRepo.getAll();
   }

   public void deleteOffer(Offer offer) {
        if (offer == null) {
            System.out.println("Offer is null");
        }
        offerRepo.delete(offer.getId());
   }

   //OFFER ORDER OPERATIONS
    public OfferOrder addOfferOrder (Integer offerId, Integer clientId){
        Integer offerOrderId = generateOfferOrderID();
        Offer offer = getOfferById(offerId);
        Client client = getClientById(clientId);
        if(client.getCard().getCurrentPoints()>=offer.pointCost)
        {
            OfferOrder offerOrder = new OfferOrder(offerOrderId, client, offer);
            client.getCard().setCurrentPoints(client.getCard().getCurrentPoints()-offer.pointCost);
            offerOrderRepo.create(offerOrder);
            return offerOrder;
        }
        else {
            System.out.println("Not sufficient points");
            return null;
        }
    }


    //UTILS
    private int generateOrderID() {
        return (int) (Math.random() * 10000);  // Simplified for example purposes
    }

    private int generateOfferID() {
        return (int) (Math.random() * 10000);  // Simplified for example purposes
    }

    private int generateOfferOrderID(){
        return (int) (Math.random() * 10000);
    }

}












