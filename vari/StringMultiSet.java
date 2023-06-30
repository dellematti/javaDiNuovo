import java.util.Iterable;

/**
 * interfaccia che descrive il comportamento di un <code>StringMultiset</code>, ossia un multiset formato da stringhe, un multiset è
 * una struttura dati simile all insieme, ma ogni elemento potrà essere contenuto più volte.
 * Il numero di volte che è contenuto equivale alla <code>molteplicità</code> dell' elemento
 */
public interface StringMultiSet extends Iterable<String> {
  /**
   * aggiunge un elemento al multiset, e restituisce la sua molteplicità, dopo l inserimento
   * 
   * @param s l elemento da aggiungere al <code>Multiset</code>
   * @return la molteplicità del elemento dopo l inserimento
   * @throws NullPointerException se s è <code>null</code>
   * @throws IllegalArgumentException se s è vuoto
   */
  int add(String s);

  /**
   * rimuove un elemento dal multiset, e restituisce la sua molteplicità, dopo l inserimento
   * 
   * @param s l elemento da aggiungere al <code>Multiset</code>
   * @return la molteplicità del elemento dopo l inserimento
   * @throws NullPointerException se s è <code>null</code>
   * @throws IllegalArgumentException se s è vuoto
   */
  int remove(String s);
  
  
  boolean contains(String s);
  int multiplicity(String s);
  int size();
  StringMultiSet union(StringMultiSet o);
  StringMultiSet intersection(StringMultiSet o);
}