package bd.edu.seu.quiz.controllers;

import bd.edu.seu.quiz.model.Order;
import bd.edu.seu.quiz.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private OrderService orderService;

    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalOrders", orderService.getTotalOrders());
        model.addAttribute("revenue", orderService.getTotalRevenue());
        model.addAttribute("orders", orderService.getAllOrders());
       return "dashboard";
    }

    @PostMapping("/orders/save")
    public String saveOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/dashboard";
    }

    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable  String id) {
        orderService.deleteOrder(id);
        return "redirect:/dashboard";
    }


}
