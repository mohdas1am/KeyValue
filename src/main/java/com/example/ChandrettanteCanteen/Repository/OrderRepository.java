package com.example.ChandrettanteCanteen.Repository;

import com.example.ChandrettanteCanteen.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Order> findByStudent_Sid(String studentId);

}