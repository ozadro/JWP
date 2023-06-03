package hr.algebra.jwpproject.controller.admin;

import hr.algebra.jwpproject.publisher.LoginSpringEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private LoginSpringEventPublisher loginSpringEventPublisher;

    public AdminController(LoginSpringEventPublisher loginSpringEventPublisher) {
        this.loginSpringEventPublisher = loginSpringEventPublisher;
    }

    @GetMapping("/admin")
    public String adminIndex(){
        loginSpringEventPublisher.publishLoginEvent("Admin page Opened");
        return "admin";
    }

    @GetMapping("/adminCRUD")
    public String adminCRUDIndex(){
        return "adminCRUD";
    }



}
