package web.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Card.TABLE_NAME)
public class Card {

    public static final String TABLE_NAME = "cards";
    private static final long serialVersionUID = -345588555544257803L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber; // 16-digit card number

    private LocalDate expirationDate;

    private String encryptedCVV;

    private double balance;

    private Long userId;

}
