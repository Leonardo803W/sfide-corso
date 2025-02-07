package epicode.pizzeria.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "elementi_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ElementoMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    public String name;
    public double price;
    public int calorie;
}
