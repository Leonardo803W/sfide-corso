package epicode.blog.autori;

import epicode.blog.blog.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String cognome;
    private String email;
    @Column(name = "data_di_nascita")
    private LocalDate dataNascita;

    @OneToMany
    private List<Post> posts = new ArrayList<>();
}
