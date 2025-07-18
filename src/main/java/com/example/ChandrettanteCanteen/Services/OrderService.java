package com.example.ChandrettanteCanteen.Services;

import com.example.ChandrettanteCanteen.Dto.OrderRequest;
import com.example.ChandrettanteCanteen.Models.BuyOnAccountEntry;
import com.example.ChandrettanteCanteen.Models.MenuItem;
import com.example.ChandrettanteCanteen.Models.Order;
import com.example.ChandrettanteCanteen.Models.Student;
import com.example.ChandrettanteCanteen.Repository.BuyOnAccountRepository;
import com.example.ChandrettanteCanteen.Repository.MenuItemRepository;
import com.example.ChandrettanteCanteen.Repository.OrderRepository;
import com.example.ChandrettanteCanteen.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
//public class OrderService {
//    @Autowired
//    MenuItemRepository menuItemRepository;
//
//    public List<MenuItem> getTodayOrders() {
//        return menuItemRepository.findAll();
//    }
//
//    public ResponseEntity<String> placeOrder(OrderRequest orderRequest) {
//    }
//}

@Service
public class OrderService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BuyOnAccountRepository buyOnAccountRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public ResponseEntity<String> placeOrder(OrderRequest request) {
        Optional<Student> studentOpt = studentRepository.findById(request.getStudentId());
        if (studentOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid student ID.");
        }

        Student student = studentOpt.get();
        Optional<MenuItem> itemOpt = menuItemRepository.findById(request.getItemId());
        if (itemOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid menu item.");
        }

        MenuItem menuItem = itemOpt.get();
        Double itemPrice = menuItem.getPrice();

        if (request.getPaymentType().equalsIgnoreCase("pay_now")) {
            if (student.getCredit() >= itemPrice) {
                student.setCredit(student.getCredit() - itemPrice);
                studentRepository.save(student);
            } else {
                return ResponseEntity.badRequest().body("Insufficient credit. Choose payment on account.");
            }
        } else if (request.getPaymentType().equalsIgnoreCase("on_account")) {
            if (student.getCredit() + itemPrice <= student.getCreditThreshold()) {
                BuyOnAccountEntry entry = new BuyOnAccountEntry();
                entry.setStudent(student);
                entry.setAmount(itemPrice);
                entry.setDescription(menuItem.getItemName());
                buyOnAccountRepository.save(entry);

                student.setCredit(student.getCredit() + itemPrice);
                studentRepository.save(student);
            } else {
                return ResponseEntity.badRequest().body("Credit threshold exceeded.");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid payment type.");
        }

        Order order = new Order();
        order.setStudent(student);
        order.setItemName(menuItem.getItemName());
        order.setItemPrice(itemPrice);
        order.setPaymentType(request.getPaymentType());
        order.setPaid(request.getPaymentType().equalsIgnoreCase("pay_now"));
        orderRepository.save(order);

        return ResponseEntity.ok("Order placed successfully.");
    }

    public List<Order> getTodayOrders() {
        return orderRepository.findAll();
    }

    public List<Order> findByStudent_Sid(String studentId) {
        return orderRepository.findByStudent_Sid(studentId);
    }
}
