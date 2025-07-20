package in.cognizant.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/acc")
public class AccountController {

    @GetMapping
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("22100", "Priyanshu ", 250000));
        accounts.add(new Account("22101", "Rishabh", 760000));
        accounts.add(new Account("22102", "Abhinav", 480000));
        return accounts;
    }
}