package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import mk.finki.ukim.mk.lab.model.AttributeConverters.UserFullName;
import mk.finki.ukim.mk.lab.model.AttributeConverters.UserFullnameConverter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "balloon_shop_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Convert(converter = UserFullnameConverter.class)
    private UserFullName userFullName;

    private String password;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> carts;

    public User(String username, UserFullName userFullName, String password, LocalDate dateOfBirth, List<ShoppingCart> carts) {
        this.username = username;
        this.userFullName = userFullName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.carts = carts;
    }

    public User() {}
}
