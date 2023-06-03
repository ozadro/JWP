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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="loginhistory")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idloginhistory")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "iduser", nullable = false)
    private User user;

    @Column(name="logindate")
    private String date;

    @Column(name="address")
    private String address;
}
