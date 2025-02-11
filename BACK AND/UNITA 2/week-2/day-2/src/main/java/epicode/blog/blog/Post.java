package epicode.blog.blog;

import epicode.blog.autori.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String categoria;
    private String titolo;
    private String contenuto;
    @Column(name = "tempo_di_lettura")
    private int TempoDiLetturaMinuti;

    @ManyToOne
    Autore autore;
}
