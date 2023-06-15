import java.util.Objects;
import java.util.*;


/**
*  OVERVIEW: le istanze di questa classe rappresentano un alias, cioè un elenco di parti locali di indirizzo email a cui  
*            sono associati un nome, e un dominio di indirizzo email.
*            gli oggetti di questo tipo sono mutabili
*/

public class Alias implements Iterable<Indirizzo>  {


    // esempio di inner class per l iteratore, a differenza della classe anonima
    /**                 
    * OVERVIEW: classe (generatore) che implementa Iterator
    */
//     private class AliasIterator implements Iterator <Indirizzo> {
// 
//         // idx è l indice del prossimo elemento su cui iterare
//         private int idx;
//         private final Locale[] arrayPartiLocali;      //metto questo perchè senno dovrei iterare direttamente sul set
// 
//         public AliasIterator() {
//             arrayPartiLocali = partiLocali.toArray(new Locale[size]);
//         }
// 
// 
//         @Override
//         public boolean hasNext() {
//             return idx < partiLocali.size();
//         }
// 
// 
//         @Override
//         public Indirizzo next() {
//             if( ! hasNext())  throw new NoSuchElementException("non ci sono più partiLocali");
//             Indirizzo tmp = new Indirizzo(  arrayPartiLocali[idx],  dominio);
//             idx++;
//             return tmp;
//         }
//     }



    
    // AF : un alias è rappresentato da nome e dominio che sono banalmente il nome dell alias e il dominio degli indirizzi email
    //      ad esso associati, e dalle parti locali cioè l insieme delle parti locali che sono associate all alias 
    // RI : nome != null e non vuoto
    //      dominio != null
    //      partiLocali != null, ogni elemento != null    (non serve che specificare che gli elementi siano unici dato che è un set)
    

    // CAMPI

    private final String nome;
    private final Dominio dominio;
    private final Set<Locale> partiLocali;


    // COSTRUTTORI
   
    /**
    * costruttore che inizializza un Alias, costituito da nome e dominio e un insieme di parti locali di indirizzi email
    *
    * @param nome il nome dell alias 
    * @param dominio la parte dominio dell indirizzo 
    * @param partiLocali l insieme di parti locali dell indirizzo da associare all alias
    * @throws IllegalArgumentException se nome è vuoto
    * @throws NullPointerException se nome è null
    * @throws NullPointerException se dominio è null
    * @throws NullPointerException se un elemento di partiLocali è null
    * @throws IllegalArgumentException se un elemento di partiLocali è ripetuto
    */
    public Alias (final String nome, final Dominio dominio, final List<Locale> partiLocali ) {
        if ( nome.equals("")) throw new IllegalArgumentException("nome non può essere vuoto");
        Objects.requireNonNull(partiLocali, "partiLocali non può essere null");
        this.partiLocali = new HashSet<Locale> (); 
        for ( Locale l : partiLocali) {
            Objects.requireNonNull(l, "partiLocali non può contenere null");
            if (this.partiLocali.contains(l)) throw new IllegalArgumentException("parte locale " + l + "già presente nell alias");
            this.partiLocali.add(l);
        }
        this.nome = Objects.requireNonNull(nome, "nome non può essere null");
        this.dominio = Objects.requireNonNull(dominio, "dominio non può essere null");
    }


    // METODI

    /**
    * aggiunge un Locale all insieme di parti locali
    * <p>Potrebbe modificare partiLocali
    *
    * @param locale la parte locale da aggiungere all insieme 
    * @throws IllegalArgumentException se la parte locale è già presente
    * @throws NullPointerException se locale è null
    */
    public void add (Locale locale) {
        Objects.requireNonNull(locale, "locale non può essere null");
        if ( this.partiLocali.contains(locale)) throw new IllegalArgumentException("parte locale " + locale + "già presente nell alias");
        this.partiLocali.add(locale);
    }


    /**
    * metodo che rimuove un Locale dall insieme di parti locali
    * <p>Potrebbe modificare partiLocali
    *
    * @param locale la parte locale da rimuovere dall insieme 
    * @throws NullPointerException se locale è null
    */
    public void remove (Locale locale) {
        Objects.requireNonNull(locale, "locale non può essere null");
        this.partiLocali.remove(locale);
    }


    /**
    * restituisce il nome dell alias
    *
    * @return il nome dell alias 
    */
    public String getNome () {
        return nome;
    }


    /**
    * restituisce il dominio dell alias
    *
    * @return il dominio dell alias 
    */
    public Dominio getDominio () {
        return dominio;
    }


    /**
    * metodo che restituisce true se l alias contiene una precisa parte locale di indirizzo, false altrimenti 
    *
    * @param locale la parte locale di cui controllare l esistenza 
    * @throws NullPointerException se locale è null
    */
    public Boolean contieneLocale (Locale locale) {
        Objects.requireNonNull(locale, "locale non può essere null");
        return this.partiLocali.contains(locale);
    }


    /**
    * metodo che restituisce true se l alias contiene un preciso indirizzo, false altrimenti 
    *
    * @param indirizzo l indirizzo di cui controllare l esistenza all interno dell alias
    * @throws NullPointerException se indirizzo è null
    */
    public Boolean contieneIndirizzo (Indirizzo indirizzo) {
        Objects.requireNonNull(indirizzo, "indirizzo non può essere null");
        if ( ! indirizzo.getDominio().equals(this.dominio)) return false;
        return this.partiLocali.contains(indirizzo.getLocale());
    }


    @Override
    public Iterator<Indirizzo> iterator() {
        return new Iterator <Indirizzo> () {

            private int idx;   // idx è l indice del prossimo elemento su cui iterare

            // metto questo perchè senno dovrei iterare direttamente sul set (non so se ha senso (?))
            // forse in questo caso sarebbe da fare un iteratore filtro / wrap dell iteratore di set (?) (cioè 
            // dentro questa classe ho anche come campo l iteratore del set)
            private final Locale[] arrayPartiLocali = partiLocali.toArray(new Locale[partiLocali.size()]);      


            @Override
            public boolean hasNext() {
                return idx < partiLocali.size();
            }


            @Override
            public Indirizzo next() {
                if( ! hasNext())  throw new NoSuchElementException("non ci sono più partiLocali");
                Indirizzo tmp = new Indirizzo(  arrayPartiLocali[idx],  dominio);
                idx++;
                return tmp;
            }
        };
    }

    
    /**
    * restituisce un iteratore che scorre sull elenco delle parti locali dell Alias (in nessun ordine in particolare)
    *
    * @return un iteratore sulle parti locali di alias
    */      //serve la documentazione o è override?
    // public Iterator<Indirizzo> iterator() {  //se invece della classe anonima facessi la inner, il metodo sarebbe così
    //     return new AliasIterator();
    // }


    @Override 
    public boolean equals(Object o) {
        if (o == this) return true;       
        if (!(o instanceof Alias)) return false;
        Alias a = (Alias) o;
        return a.nome.equals(this.nome);
    }


    @Override                             
    public int hashCode() {
        return Objects.hash(nome);
    }


    @Override
    public String toString(){
        StringBuilder str =  new StringBuilder("");
        str.append(nome + "\n");
        for ( Locale l : this.partiLocali) str.append(l + "@" + this.dominio + "\n");
        return str.toString();
    }


    // ho già un iteratore ma se volessi fare un getter anche per il set, mi devo ricordare di non esporre la rappresentazione
    // dato che a differenza di nome e dominio, il set partiLocali è mutabile

}
