import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * classe concreta mutabile rappresentante una cassa contenente importi di valute diverse
 * vengono offerti metodi per prelevare e depositare importi all interno della cassa
 */
public class Cassa {

    /**importi presenti nella cassa */
    private Map<Valuta, Integer> importi; 

    // AF: cassa dove per ogni valuta abbiamo una chiave di importi e la quantità
    //     di denaro in quella valuta = value associato alla key
    // RI: importi != null, ogni chiave e valore presente in importi != null
    //     ogni valore associato ad una valuta >= 0


    /**
     * costruisce una cassa, la cassa sarà inizialmente sempre vuota
     */
    public Cassa () {
        this.importi = new HashMap<Valuta, Integer>();
    }


    /**
     * aggiunge un importo alla cassa
     * 
     * @param importo l importo da versare in cassa
     * @throws NullPointerException se l' importo è {@code null}
     */
    public void versa (Importo importo) {
        Objects.requireNonNull(importo, "L importo da versare in cassa non può essere null");
        Valuta chiave = importo.getValuta();
        Integer valore = importo.getValore();
        if (! importi.containsKey(chiave)) importi.put(chiave, valore );
        else importi.put(chiave, importi.get(chiave) + valore);
    }


    /**
     * preleva dalla cassa un determinato importo, restituisce {@code false} se la cassa non contiene un importo sufficiente 
     * di quella valuta, {@code true} altrimenti
     * 
     * @param importo l importo da prelevare dalla cassa
     * @return {@code true} se l importo avviene con successo, {@code false} altrimenti
     * @throws NullPointerException se importo è {@code null}
     * @throws NullPointerException se la cassa non ha al suo interno un importo del tipo di valuta richiesto
     */
    public boolean preleva (Importo importo) {
        Objects.requireNonNull(importo, "L importo da versare in cassa non può essere null");
        Valuta chiave = importo.getValuta();
        Integer valore = importo.getValore();  
        Objects.requireNonNull(importi.get(chiave), "La cassa non ha disponibilità di quella valuta, impossibile prelevare");

        if (importi.get(chiave) < valore ) return false;
        importi.put(chiave, importi.get(chiave) - valore);
        return true;
    }


    /**
     * Ritorna un iteratore sugli importi presenti in cassa.
     * 
     * @return un iteratore sugli importi presenti in cassa.
     */
    public Iterator<Importo> importi() {
        return new Iterator<Importo>() {

            int i = 0;
            int len = Valuta.values().length;

            @Override
            public boolean hasNext() {
                return i < len;
            }

            @Override
            public Importo next() {
                if (!hasNext()) throw new NoSuchElementException();
                Valuta valuta = Valuta.values()[i]; // se non ho niente restituisco null e non l importo nuovo
                i++;
                if (importi.get(valuta) == null ) return null;
                return new Importo(importi.get(valuta), valuta);
            }
            
        };
    }





}
