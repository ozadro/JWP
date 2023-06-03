package hr.algebra.jwpproject.controller.admin;

import hr.algebra.jwpproject.service.PurchaseHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminViewPurchaseHistory {

    private final PurchaseHistoryService purchaseHistoryService;

    public AdminViewPurchaseHistory(PurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @GetMapping("/adminViewPurchaseHistory")
    public String viewPurchaseHistoryIndex(Model model){
        model.addAttribute("purchaseHistory", purchaseHistoryService.getAll());
        return "adminViewPurchaseHistory";
    }
}
