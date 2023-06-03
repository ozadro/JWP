package hr.algebra.jwpproject.event;

import org.springframework.context.ApplicationEvent;


public class LoginSpringEvent extends ApplicationEvent {
    private String message;

    public LoginSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
