package com.example.ChandrettanteCanteen.Services;

import com.example.ChandrettanteCanteen.Models.MenuItem;
import com.example.ChandrettanteCanteen.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuRepo;

    public MenuItem addItem(MenuItem item) {
        return menuRepo.save(item);
    }

    public List<MenuItem> getAvailableItems() {
        return menuRepo.findAll()
                .stream()
                .filter(MenuItem::getAvailable)
                .toList();
    }

    public void updateAvailability(String id, Boolean available) {
        MenuItem item = menuRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        item.setAvailable(available);
        menuRepo.save(item);
    }
}
