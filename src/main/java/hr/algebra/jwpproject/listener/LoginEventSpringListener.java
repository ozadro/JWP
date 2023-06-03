package hr.algebra.jwpproject.listener;

import hr.algebra.jwpproject.event.LoginSpringEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LoginEventSpringListener implements ApplicationListener<LoginSpringEvent> {
    @Override
    public void onApplicationEvent(LoginSpringEvent event) {
        System.out.println("Authorized user has accessed and opened - " + event.getMessage());
    }
}
