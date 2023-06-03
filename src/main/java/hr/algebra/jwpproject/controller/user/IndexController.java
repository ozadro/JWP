package hr.algebra.jwpproject.controller.user;

import hr.algebra.jwpproject.publisher.LoginSpringEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private LoginSpringEventPublisher loginSpringEventPublisher;

    public IndexController(LoginSpringEventPublisher loginSpringEventPublisher) {
        this.loginSpringEventPublisher = loginSpringEventPublisher;
    }

    @GetMapping("/index")

    public String index(){
        loginSpringEventPublisher.publishLoginEvent("User page Opened");
        return "index";
    }
}
