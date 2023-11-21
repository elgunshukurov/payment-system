package web.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {

    private String cardNumber; // 16-digit card number

    private LocalDate expirationDate;

    private int cvv;

    private double balance;

//    @JsonIgnore
    private Long userId;

}
