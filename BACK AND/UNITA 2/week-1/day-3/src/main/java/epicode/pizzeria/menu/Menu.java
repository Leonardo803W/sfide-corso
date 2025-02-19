package epicode.pizzeria.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private String nameMenu;

    //a differenza della versione precedente, siccome che tutte le varie informazioni si ricongiungono in
    //una unica classe, mi basta chiamarla per fare una nuova lista senza importare le classi.

    List<ElementoMenu> elemntiMenu = new ArrayList<>();

}
