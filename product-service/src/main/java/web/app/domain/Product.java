package web.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Product.TABLE_NAME)
public class Product implements Serializable {

    public static final String TABLE_NAME = "products";
    private static final long serialVersionUID = -3455812332155L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int stock;
    private double price;
}
