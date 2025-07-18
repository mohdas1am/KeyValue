package com.example.ChandrettanteCanteen.Repository;

import com.example.ChandrettanteCanteen.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    //Optional<Student> findByCanteenCardId(String canteenCardId);
}
