package epicode.pizzeria.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private String nomeMenu;

    //a differenza della versione precedente, siccome che tutte le varie informazioni si ricongiungono in
    //una unica classe, mi basta chiamarla per fare una nuova lista senza importare le classi.

    List<ElementoMenu> elemntiMenu = new ArrayList<>();

}
