package bd.edu.seu.quiz.services;

import bd.edu.seu.quiz.model.Order;
import bd.edu.seu.quiz.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(String id){
        orderRepository.deleteById(id);
    }

    public int getTotalOrders(){
        return orderRepository.findAll().size();
    }

    public double getTotalRevenue(){
        return orderRepository.findAll().stream().mapToDouble(Order::getTotal).sum();
    }
}
