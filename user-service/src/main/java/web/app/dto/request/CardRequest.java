package web.app.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {

    @Size(min = 16, max = 16)
    private String cardNumber;

    private LocalDate expirationDate;

    private int cvv;

    private double balance;

//    @JsonIgnore
    private Long userId;

}
