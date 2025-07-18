package com.example.ChandrettanteCanteen.Controllers;

import com.example.ChandrettanteCanteen.Dto.OrderRequest;
import com.example.ChandrettanteCanteen.Models.MenuItem;
import com.example.ChandrettanteCanteen.Models.Order;
import com.example.ChandrettanteCanteen.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @GetMapping("/today")
    public List<Order> getTodayOrders() {
        return orderService.getTodayOrders();
    }

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    @GetMapping("/student/{studentId}")
    public List<Order> getOrdersByStudent(@PathVariable String studentId) {
        return orderService.findByStudent_Sid(studentId);
    }

}
