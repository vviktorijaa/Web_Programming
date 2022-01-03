package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="balloon_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String balloonColor;

    private String balloonSize;

    @ManyToOne
    private ShoppingCart shoppingCart;

    public Order(String balloonColor, String balloonSize) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
    }

    public Order() {}
}
