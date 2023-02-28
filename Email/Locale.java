import java.util.Objects;
import java.util.*;
import java.util.regex.Pattern;
import java.util.function.Predicate;

/**
* Overview: le istanze di questa classe rappresentano la parte di indirizzo email corrispondente alla parte 
*           che precede "@", e deve essere nel formato corretto nome.cognome, un esempio è "mario.rossi"
*           gli oggetti di questo tipo sono immutabili 
*/

public class Locale{

    /**
    * AF : Locale è rappresentato unicamente da locale, che è banalmente la parte locale dell indirizzo email
    * RI : locale deve soddisfare i vincoli dell espressione regolare
    *       locale != null
    */


    // CAMPI

    private final String locale;
    // String er = "`^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$`";
    // final static Predicate<String> VALIDO = Pattern.compile(er).asPredicate();


    // COSTRUTTORI

    /**
    * costruttore che inizializza un Locale
    *
    * @param locale la parte locale dell indirizzo 
    * @throws IllegalArgumentException se locale non è nel formato corretto
    * @throws NullPointerException se locale è null
    */
    public Locale(final String locale) {
        String er = "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*$";
        // final static Predicate<String> VALIDO = Pattern.compile(er).asPredicate();
        Predicate<String> VALIDO = Pattern.compile(er).asPredicate();
        if ( ! VALIDO.test(locale)) throw new IllegalArgumentException(locale + "non soddisfa i vincoli di locale");
        this.locale = Objects.requireNonNull( locale, "locale non può essere null");
    }


    // METODI
    
    @Override 
    public boolean equals(Object o) {
        if (o == this) return true;       
        if (!(o instanceof Locale)) return false;
        Locale l = (Locale) o;
        return l.locale.equals(this.locale);
    }


    @Override                             
    public int hashCode() {
        return Objects.hash(locale);
    }


    @Override
    public String toString(){
        return locale;
    }



}