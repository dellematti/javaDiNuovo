import java.util.Objects;
import java.util.*;
import java.util.regex.Pattern;
import java.util.function.Predicate;
/**
* Overview: le istanze di questa classe rappresentano la parte di indirizzo email corrispondente alla parte 
*           che segue "@", e deve essere nel formato corretto ad esempio "unimi.it"
*           gli oggetti di questo tipo sono immutabili 
*/

public class Dominio{

    /**
    * AF : Dominio è rappresentato unicamente da dominio, che è banalmente la parte del dominio dell indirizzo email
    * RI : dominio deve soddisfare i vincoli dell espressione regolare
    *      dominio != null
    */


    // CAMPI

    private final String dominio;
    // final static Predicate<String> VALIDO = Pattern.compile("`^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$`").asPredicate();
    // meglio metterla come campo statico della classe

    // COSTRUTTORI

    /**
    * costruttore che inizializza un Dominio
    *
    * @param dominio la parte dominio dell indirizzo 
    * @throws IllegalArgumentException se dominio non è nel formato corretto
    * @throws NullPointerException se dominio è null
    */
    public Dominio(final String dominio) {
        String er = "^[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Predicate<String> VALIDO = Pattern.compile(er).asPredicate();
        if ( ! VALIDO.test(dominio)) throw new IllegalArgumentException(dominio + " non soddisfa i vincoli di dominio");
        this.dominio = Objects.requireNonNull( dominio, "dominio non può essere null");
    }


    // METODI
  
    @Override 
    public boolean equals(Object o) {
        if (o == this) return true;       
        if (!(o instanceof Dominio)) return false;
        Dominio d = (Dominio) o;
        return d.dominio.equals(this.dominio);
    }


    @Override                             
    public int hashCode() {
        return Objects.hash(dominio);
    }


    @Override
    public String toString(){
        return dominio;
    }



}