package hr.algebra.jwpproject.controller.admin;

import hr.algebra.jwpproject.service.LoginHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginHistoryController {

    private final LoginHistoryService loginHistoryService;

    public AdminLoginHistoryController(LoginHistoryService loginHistoryService) {
        this.loginHistoryService = loginHistoryService;
    }

    @GetMapping("adminLogHistory")
    public String adminLogHistoryIndex(Model model){

        model.addAttribute("loginHistory", loginHistoryService.getAll());

        return "adminLogHistory";
    }
}
