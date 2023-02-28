import java.util.*;

public class Test {

    public static void main(final String[] args) {

        Dominio dominio = new Dominio ("studenti.unimi.it");
        List <Locale> partiLocali = new ArrayList <>() ;

        partiLocali = Arrays.asList(new Locale("mario.rossi"), new Locale ("jason.bourne"));

        Alias alias = new Alias ( "studenti", dominio, partiLocali);

        System.out.println(alias);

        for (Indirizzo i : alias) System.out.println(i + " ciao");      //posso farlo perchè Alias è Iterable

        String nome = alias.getNome();
        nome = "ole";

        System.out.println(alias);


    }



}