package com.example.ChandrettanteCanteen.Controllers;

import com.example.ChandrettanteCanteen.Models.BuyOnAccountEntry;
import com.example.ChandrettanteCanteen.Repository.BuyOnAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BuyOnAccountController {

    @Autowired
    private BuyOnAccountRepository buyOnAccountRepository;

    @GetMapping("/pending")
    public List<BuyOnAccountEntry> getAllPendingAccounts() {
        return buyOnAccountRepository.findAll();
    }
}
