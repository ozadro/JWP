package hr.algebra.jwpproject.publisher;

import hr.algebra.jwpproject.event.LoginSpringEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoginSpringEventPublisher {
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishLoginEvent(final String message) {
        System.out.println("Publishing Login event. ");
        LoginSpringEvent loginSpringEvent = new LoginSpringEvent(this, message);
        applicationEventPublisher.publishEvent(loginSpringEvent);
    }
}
