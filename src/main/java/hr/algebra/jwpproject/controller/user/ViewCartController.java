package hr.algebra.jwpproject.controller.user;

import hr.algebra.jwpproject.dateformat.DateFormatCurrent;
import hr.algebra.jwpproject.model.Cart;
import hr.algebra.jwpproject.model.PurchaseHistory;
import hr.algebra.jwpproject.service.CartService;
import hr.algebra.jwpproject.service.PurchaseHistoryService;
import hr.algebra.jwpproject.service.UserService;
import hr.algebra.jwpproject.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("username")
public class ViewCartController {

    private final CartService cartService;
    private final UserService userService;
    private final PurchaseHistoryService purchaseHistoryService;


    public ViewCartController(CartService cartService, UserService userService, PurchaseHistoryService purchaseHistoryService) {
        this.cartService = cartService;
        this.userService = userService;
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @GetMapping("/viewCart")
    public String viewCartIndex(Model model, ModelMap modelMap) {
        if (modelMap.get("username") != null){
        User user = userService.findByUsername(modelMap.get("username").toString());
        List<Cart> carts = cartService.getAllByUserId(user.getId());
        model.addAttribute("carts", carts);
        model.addAttribute("cart", new Cart());

       Double totalPrice = getTotalPrice(carts);
       model.addAttribute("totalPrice",totalPrice);
        return "viewCart";
        } else{
            return "redirect:/login";
        }
    }

    private Double getTotalPrice(List<Cart> carts) {
        Double totalPrice = 0.0;
        Double price;
        for (Cart cart:
             carts) {
            price = cart.getArticle().getPrice() * cart.getQuantity();
            totalPrice += price;
        }

        return totalPrice;
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id){
        Cart cart = cartService.findById(id);
        cartService.delete(cart);
        return "redirect:/viewCart";
    }
    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") Long id,@ModelAttribute("quantity")Integer quantity){
        Cart cart = cartService.findById(id);
        cart.setQuantity(quantity);
        cartService.save(cart);
        return "redirect:/viewCart";
    }

    @GetMapping("/deleteAllProduct")
    public String deleteAllProduct(ModelMap modelMap){
        User user = userService.findByUsername(modelMap.get("username").toString());
        List<Cart> carts = cartService.getAllByUserId(user.getId());
        for (Cart cart:
             carts) {
            cartService.delete(cart);
        }
        return "redirect:/viewCart";
    }

    @PostMapping("/success")
    public String success(ModelMap modelMap, @ModelAttribute("type")String type){
        if (modelMap.get("username").toString() != null) {
            System.out.println(modelMap.get("username").toString());
            User user = userService.findByUsername(modelMap.get("username").toString());
            List<Cart> carts = cartService.getAllByUserId(user.getId());
            System.out.println(carts);
            for (int i = 0; i < carts.size(); i++){
                PurchaseHistory purchaseHistory = new PurchaseHistory();
                purchaseHistory.setQuantity(String.valueOf(carts.get(i).getQuantity()));
                purchaseHistory.setArticle(String.valueOf(carts.get(i).getArticle().getName()));
                purchaseHistory.setUser(user);
                purchaseHistory.setDate(DateFormatCurrent.getCurrentTime());
                if (type.equals("1")){
                    purchaseHistory.setType("Cash");
                } else {
                    purchaseHistory.setType("Paypal");
                }

                purchaseHistoryService.save(purchaseHistory);

            }

            for(Cart cart: carts){
                cartService.delete(cart);
            }
            return "redirect:/index";
        }
        return "redirect:/login";
    }

}
