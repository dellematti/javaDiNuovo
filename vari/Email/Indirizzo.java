import java.util.Objects;
import java.util.*;


/**
* Overview: le istanze di questa classe rappresentano un indirizzo email, costituito da un parte locale e una parte dominio
*           gli oggetti di questo tipo sono immutabili
*           Un esempio di indirizzo è Mario.Rossi@unimi.it, dove "MarioRossi" è la parte locale e "unimi.it" è il dominio,
*           parte locale e dominio sono sempre divisi da "@"
*/

public class Indirizzo {
    
    // AF : un indirizzo è rappresentato dalla sua parte locale, seguita da "@", seguita dalla sua parte dominio
    // RI : locale != null
    //      dominio != null
    

    // CAMPI


    private final Locale locale;
    private final Dominio dominio;


    // COSTRUTTORI


    /**
    * costruttore che inizializza un Indirizzo, costituito da locale e dominio
    *
    * @param locale la parte locale dell indirizzo 
    * @param dominio la parte dominio dell indirizzo 
    * @throws NullPointerException se locale è null
    * @throws NullPointerException se dominio è null
    */
    public Indirizzo(final Locale locale, final Dominio dominio) {
        this.locale = Objects.requireNonNull(locale, "locale non può essere null" );
        this.dominio = Objects.requireNonNull(dominio, "dominio non può essere null" );
    }


    // METODI

    /**
    * restituisce locale
    *
    * @return la parte locale dell indirizzo email
    */
    public Locale getLocale(){
        return this.locale;
    }


    /**
    * restituisce dominio
    *
    * @return la parte dominio dell indirizzo email
    */
    public Dominio getDominio(){
        return this.dominio;
    }


    @Override
    public String toString(){
        return locale + "@" + dominio;
    }




}
