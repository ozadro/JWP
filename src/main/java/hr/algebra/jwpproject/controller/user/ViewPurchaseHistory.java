package hr.algebra.jwpproject.controller.user;

import hr.algebra.jwpproject.service.PurchaseHistoryService;
import hr.algebra.jwpproject.service.UserService;
import hr.algebra.jwpproject.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class ViewPurchaseHistory {
    private final PurchaseHistoryService purchaseHistoryService;
    private final UserService userService;

    public ViewPurchaseHistory(PurchaseHistoryService purchaseHistoryService, UserService userService) {
        this.purchaseHistoryService = purchaseHistoryService;
        this.userService = userService;
    }

    @GetMapping("/viewPurchaseHistory")
    public String viewPurchaseHistoryIndex(Model model, ModelMap modelMap){
        if (modelMap.get("username") != null) {
            User user = userService.findByUsername(modelMap.get("username").toString());
            model.addAttribute("purchaseHistory", purchaseHistoryService.getAllByUserId(user.getId()));
            return "viewPurchaseHistory";
        } else {
            return "redirect:/login";
        }
    }
}
