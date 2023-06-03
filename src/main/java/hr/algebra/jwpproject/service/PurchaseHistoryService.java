package hr.algebra.jwpproject.service;

import hr.algebra.jwpproject.model.PurchaseHistory;
import hr.algebra.jwpproject.repository.PurchaseHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseHistoryService {
    private final PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    public List<PurchaseHistory> getAll(){return purchaseHistoryRepository.findAll();}
    public PurchaseHistory save(PurchaseHistory purchaseHistory){return purchaseHistoryRepository.save(purchaseHistory);}
    public List<PurchaseHistory> getAllByUserId(Long id){return purchaseHistoryRepository.findAllByUserId(id);}
}
