// import java.util.Iterable;
import java.util.*;

/**
 * interfaccia che stabilisce il contratto di un multiset di Stringhe
 */
public interface StringMultiSet extends Iterable<String> {

    /**
     * aggiunge un elemento al multiset, e restituisce la sua molteplicità dopo l inserimento
     * 
     * @param s l elemento da inserire nel multiset
     * @return la molteplicità dell elemento inserito
     * @throws NullPointerException se s è null
     * @throws IllegalArgumentException se s è vuoto
     */
    int add(String s);

    /**
     * rimuove un elemento dal multiset, e restituisce la sua molteplicità prima della rimozione
     * 
     * @param s l elemento da rimuovere dal multiset
     * @return la molteplicità dell elemento rimosso
     * @throws NullPointerException se s è null
     * @throws IllegalArgumentException se s è vuoto
     */
    int remove(String s);


    /**
     * restituisce true se un elemento è presente all interno del multiset, false altrimenti
     * 
     * @param s l elemento di cui controllare l esistenza nel multiset
     * @return true se l elemento è presente, false altrimenti
     * @throws NullPointerException se s è null
     * @throws IllegalArgumentException se s è vuoto
     */
    boolean contains(String s);


    /**
     * restituisce la molteplicità di un elemento
     * 
     * @param s l elemento di cui controllare la molteplicità
     * @return la molteplicità dell elemento
     * @throws NullPointerException se s è null
     * @throws IllegalArgumentException se s è vuoto
     */
    int multiplicity(String s);


    /**
     * restituisce la cardinalità del multiset
     * 
     * @return la la cardinalità del multiset
     */
    int size();


    /**
     * restituisce il nuovo multiset ottenuto tramite l operazione di unione tra questo multiset e quello indicato come argomento
     * 
     * @param o l altro multiset su cui effettuare l operazione di unione
     * @return il nuovo multiset ottenuto tramite l operazione
     * @throws NullPointerException se o è null
     */
    StringMultiSet union(StringMultiSet o);


    /**
     * restituisce il nuovo multiset ottenuto tramite l operazione di intersezione tra questo multiset e quello indicato come argomento
     * 
     * @param o l altro multiset su cui effettuare l operazione di intersezione
     * @return il nuovo multiset ottenuto tramite l operazione
     * @throws NullPointerException se o è null
     */
    StringMultiSet intersection(StringMultiSet o);
  }