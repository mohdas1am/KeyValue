package com.example.ChandrettanteCanteen.Controllers;

import com.example.ChandrettanteCanteen.Models.MenuItem;
import com.example.ChandrettanteCanteen.Services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuItemService menuService;

    @PostMapping("/add")
    public MenuItem addMenuItem(@RequestBody MenuItem item) {
        return menuService.addItem(item);
    }

    @GetMapping("/available")
    public List<MenuItem> getAvailableItems() {
        return menuService.getAvailableItems();
    }

    @PutMapping("/update-availability/{id}")
    public void updateAvailability(@PathVariable String id, @RequestParam Boolean available) {
        menuService.updateAvailability(id, available);
    }
}
