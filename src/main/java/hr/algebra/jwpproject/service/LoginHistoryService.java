package hr.algebra.jwpproject.service;

import hr.algebra.jwpproject.model.LoginHistory;
import hr.algebra.jwpproject.repository.LoginHistoryRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    public LoginHistoryService(LoginHistoryRepository loginHistoryRepository) {
        this.loginHistoryRepository = loginHistoryRepository;
    }

    public List<LoginHistory> getAll(){
      return loginHistoryRepository.findAll();
    }

    public LoginHistory save(LoginHistory loginHistory){return loginHistoryRepository.save(loginHistory);}
}
