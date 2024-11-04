package Controller;

import Models.Order;
import Models.Product;
import Service.ClientService;
import Service.OrderService;

import java.util.List;

public class OrderController {

    private final OrderService orderService;
    private final ClientController clientController ;


    public OrderController(OrderService orderService, ClientController clientController) {
        this.orderService = orderService;
        this.clientController = clientController;
    }


    public Order addOrder(Integer clientId, List<Integer> foodIds, List<Integer> coffeeIds) {
        Order order = orderService.addOrder(clientId, foodIds, coffeeIds);
        int currPoints = clientController.changePoints(clientId,order.getPoints());
        System.out.println("Your current points: " + currPoints);
        return order;
    }


}
