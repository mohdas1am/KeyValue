package com.example.ChandrettanteCanteen.Repository;
import com.example.ChandrettanteCanteen.Models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, String > {
    Optional<MenuItem> findByItemName(String itemName);
}

