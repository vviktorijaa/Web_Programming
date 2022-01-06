package mk.finki.ukim.mk.lab.model.AttributeConverters;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserFullName implements Serializable {

    private String name;
    private String surname;

    public UserFullName() {}
}
