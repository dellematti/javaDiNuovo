import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Objects;
import java.util.Collections;
import java.util.Iterator;


/**
 * classe concreta immutabile che raprpesenta una Pavimentazione, composta da un elenco di possibili Rivestimenti
 */
public class Pavimentazione implements Rivestimento {

    /* i rivestimenti che formano la Pavimentazione, e la quantità di ognuno di essi */
    private final Map <Rivestimento, Integer> rivestimentiQuantità;

    /* superficie della Pavimentazione in cm quadri */
    private final int superficie;

    /*costo della pavimentazione */
    private final int costo;


    // AF:
    // RI: rivestimentiQuantità != null e non vuoto 
    //     ogni elemento di rivestimentiQuantità != null
    //     il valore associato ad ogni chiave di rivestimentiQuantità deve essere > 0 
    //     superficie > 0 e uguale alla somma delle superfici degli elementi di rivestimenti
    //     costo > 0 e uguale alla somma dei costi degli elementi di rivestimenti


    /**
     * costruisce una pavimentazione data una lista di rivestimenti
     * 
     * @param rivestimenti tutti i rivestimenti che compongono la pavimentazione
     * @throws NullPointerException se la lista di rivestimenti è null
     * @throws NullPointerException se un elemento di rivestimenti è null
     */
    public Pavimentazione (final List <Rivestimento> rivestimenti ) {
        Objects.requireNonNull(rivestimenti, "rivestimenti non può essere null.");
        int superficieTMP = 0;
        int costoTMP = 0;
        this.rivestimentiQuantità = new HashMap<Rivestimento, Integer>();
        for (Rivestimento rivestimento: rivestimenti ) {
            Objects.requireNonNull(rivestimento, "un elemento di rivestimenti non può essere null.");
            // ora per ogni elemento, se non cè nella mappa lo inserisco, altrimenti aumento il cnt associato
            superficieTMP += rivestimento.superficie();
            costoTMP += rivestimento.costo();
        }
        // this.rivestimenti = List.copyOf(rivestimenti);  // se modifico la lista originale non avrà effetto sulla copia!
        this.superficie = superficieTMP;
        this.costo = costoTMP;
    }


    /**
     * restituisce un iteratore sui Rivestimenti presenti nella Pavimentazione.
     * 
     * @return un iteratore sui Rivestimenti presenti nella Pavimentazione.
     */
    // public Iterator<Rivestimento> proiezioni() {
    //     return Collections.unmodifiableList(this.rivestimenti).iterator();
    // }
    // se uso la mappa l iteratore lo devo fare io custom



    @Override
    public int superficie() {
        return this.superficie;
    }


    @Override
    public int costo() {
        return this.costo;
    }


    @Override
    public String toString() {  // stampare anche i vari elementi di rivestimenti
        return "Superficie: " + this.superficie() + " costo:  " + this.costo();
    }



}