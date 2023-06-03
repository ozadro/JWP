package hr.algebra.jwpproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hr.algebra.jwpproject.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Table(name="purchasehistory")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpurchasehistory")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "iduser", nullable = false)
    private User user;
    @Column(name="article")
    private String article;

    @Column(name="quantity")
    private String quantity;
    @Column(name="paymenttype")
    private String type;
    @Column(name="logindate")
    private String date;
}
