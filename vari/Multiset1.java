import java.util.Objects;
import java.util.*;


/**
 * classe concreta che implementa un multiset di stringhe,   //(multiset uno perchè è la prima implementazione, trovare nome sensato)
 */
public class Multiset1 implements StringMultiSet {

    private int cardinalità;
    private final Map<String, Integer> elementoMolteplicità;

    // AF: il valore di cardinalità è la cardinalità del multiset, ogni elemento di elementoMolteplicità è un elemento
    //     del multiset a cui associo la sua molteplicità
    // RI: cardinalità >= 0
    //     elementoMolteplicità != null
    //     elementoMolteplicità non contiene null
    //     elementoMolteplicità non ha elementi associati a numeri <= 0


    /**
     * costruttore che inizializza un Multiset1 dati i suoi elementi
     * 
     * @param elementi gli elementi che costituiranno il multiset
     * @throws NullPointerException se elementi è null
     * @throws NullPointerException se un elemento di elementi è null
     * @throws IllegalArgumentException se un elemento di elementi è vuoto
     */
    public Multiset1 (final List <String> elementi) {
        Objects.requireNonNull (elementi, "elementi non può essere null");
        elementoMolteplicità = new HashMap<String,Integer>();  
        for (String s : elementi) {
            Objects.requireNonNull (s, "gli elementi non possono essere null");
            if (s.isEmpty()) throw new IllegalArgumentException("Non posso avere elementi vuoti");
            if (! elementoMolteplicità.containsKey(s)) elementoMolteplicità.put(s, 1);
            else elementoMolteplicità.replace(s, elementoMolteplicità.get(s)+1 ); 
        }
        this.cardinalità = elementi.size();
    }


    @Override
    public int add(String s) {
        Objects.requireNonNull (s, "la stringa da aggiungere non può essere null");
        if (s.isEmpty()) throw new IllegalArgumentException("Non posso mettere elementi vuoti");

        int molteplicità = elementoMolteplicità.get(s);
        if (! elementoMolteplicità.containsKey(s)) elementoMolteplicità.put(s, 1);
            else elementoMolteplicità.replace(s, elementoMolteplicità.get(s) + 1 ); 
        this.cardinalità++;
        return molteplicità;
    }


    @Override
    public int remove(String s) {
        Objects.requireNonNull (s, "la stringa da aggiungere non può essere null");
        if (s.isEmpty()) throw new IllegalArgumentException("Non posso mettere elementi vuoti");
        int molteplicità = elementoMolteplicità.get(s);  //sarà null se non ho s nella mappa (va bene??  PROVARE)     
        
        if (elementoMolteplicità.containsKey(s)) this.cardinalità--;
        if ( ! elementoMolteplicità.remove(s,1) ) {  //se ho s associata a 1, lo posso rimuovere dalla mappa, non devo avere zeri
            elementoMolteplicità.replace(s, elementoMolteplicità.get(s) - 1 );
        }
        return molteplicità;
    }
    
    
    @Override
    public boolean contains(String s) {
        Objects.requireNonNull (s, "la stringa da aggiungere non può essere null");
        if (s.isEmpty()) throw new IllegalArgumentException("Non posso mettere elementi vuoti");
        return elementoMolteplicità.containsKey(s);
    }


    @Override
    public int multiplicity(String s) {
        Objects.requireNonNull (s, "la stringa da aggiungere non può essere null");
        if (s.isEmpty()) throw new IllegalArgumentException("Non posso mettere elementi vuoti");
        return elementoMolteplicità.get(s);
    }


    @Override
    public int size() {
        return this.cardinalità;
    }

    // mancano questi due metodi

    @Override
    public StringMultiSet union(StringMultiSet o) {
        return this;
    }


    @Override
    public StringMultiSet intersection(StringMultiSet o) {
        return this;
    }


    @Override
    public Iterator<String> iterator() {
        return Collections.unmodifiableSet (this.elementoMolteplicità.keySet().iterator() ) ;
    }








}