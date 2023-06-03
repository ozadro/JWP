package hr.algebra.jwpproject.controller;

import hr.algebra.jwpproject.dateformat.DateFormatCurrent;
import hr.algebra.jwpproject.model.LoginHistory;
import hr.algebra.jwpproject.service.LoginHistoryService;
import hr.algebra.jwpproject.service.UserService;
import hr.algebra.jwpproject.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.net.InetAddress;
import java.util.List;

@Controller
@SessionAttributes("username")
public class LoginController {
    private final UserService userService;
    private final LoginHistoryService loginHistoryService;

    public LoginController(UserService userService, LoginHistoryService loginHistoryService) {
        this.userService = userService;
        this.loginHistoryService = loginHistoryService;
    }

    @GetMapping("login")
    public String loginIndex() {
        return "login";
    }

    @SneakyThrows
    @PostMapping("/login")
    public String authUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model, ModelMap modelMap) {
        List<User> usersList = userService.getAllUsers();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (usersList.isEmpty()) {
            model.addAttribute("ErrorMessage", "Login unsuccessful, wrong username and password!");
        } else {
            for (User user : usersList) {
                if (user.getUsername().trim().equals(username.trim()) && passwordEncoder.matches(password.trim(), user.getPassword().trim())) {
                    modelMap.put("username",user.getUsername());
                    if (user.getRole().equals("ROLE_ADMIN")){
                        return "redirect:/admin";
                    }else{
                        saveLogingHistory(user);
                        return "redirect:/index";
                    }
                } else {
                    model.addAttribute("ErrorMessage", "Login unsuccessful, wrong username and password!");
                }
            }
        }
        return "login";
    }

    @SneakyThrows
    public void saveLogingHistory(User user){
        InetAddress localhost = InetAddress.getLocalHost();
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setUser(user);
        loginHistory.setDate(DateFormatCurrent.getCurrentTime());
        loginHistory.setAddress(localhost.toString());
        loginHistoryService.save(loginHistory);
    }


    @GetMapping("/cleanSession")
    public String cleanSession(SessionStatus sessionStatus, HttpSession session) {
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/login";
    }
}


