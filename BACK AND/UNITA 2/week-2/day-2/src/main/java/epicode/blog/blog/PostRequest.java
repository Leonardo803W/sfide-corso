package epicode.blog.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    private String categoria;
    private String titolo;
    private String contenuto;
    private int TempoDiLetturaMinuti;
}
