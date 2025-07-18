package com.example.ChandrettanteCanteen.Repository;

import com.example.ChandrettanteCanteen.Models.BuyOnAccountEntry;
import com.example.ChandrettanteCanteen.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;
import java.util.List;

@Repository
public interface BuyOnAccountRepository extends JpaRepository<BuyOnAccountEntry, Long> {
    List<BuyOnAccountEntry> findByStudent(Student student);
    List<BuyOnAccountEntry> findAll();

}
