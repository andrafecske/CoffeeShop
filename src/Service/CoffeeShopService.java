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

    //admin service

    public CoffeeShopService(IRepository<Admin> adminRepo, IRepository<Client> clientRepo, IRepository<Coffee> coffeeRepo, IRepository<Food> foodRepo, IRepository<Order> orderRepo) {
        this.adminRepo = adminRepo;
        this.clientRepo = clientRepo;
        this.coffeeRepo = coffeeRepo;
        this.foodRepo = foodRepo;
        this.orderRepo = orderRepo;
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

    private int generateOrderID() {
        return (int) (Math.random() * 10000);  // Simplified for example purposes
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




}





