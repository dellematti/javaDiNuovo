import java.util.Objects;
import java.util.*;

/**
 * OVERVIEW : questa classe concreta modella un album musicale, un elenco di brani non vuoto e senza ripetizioni
 *            Le istanze di questa classe sono immutabili
 */


public class Album implements Iterable<Album.Brano> {

    /**
     * OVERVIEW : questa classe concreta modella un brano musicale
     *            Le istanze di questa classe sono immutabili
     */
    
    public class Brano {


        
        //   AF: titolo del brano rappresenta banalmente il titolo del brano, mentre durata raprpesenta la sua durata
        //   RI: titolo non può essere una stringa vuota
        //       titolo non può essere null                   
        //       durata non può essere di zero secondi
        //       durata non può essere null
         


        // Attributi
        
        private final String titolo;
        private final Durata durata;


        // Costruttori

        /**
        * costruttore che inizializza una Brano dato un titolo e una durata 
        *
        * @param titolo il titolo del brano 
        * @param durata la durata del brano 
        * @throws NullPointerException se titolo è null
        * @throws NullPointerException se durata è null
        * @throws IllegalArgumentException se titolo è vuoto
        * @throws IllegalArgumentException se durata è uguale a zero
        */
        public Brano (final String titolo, final Durata durata) {
            Objects.requireNonNull (titolo, "titolo non può essere null");
            if ( titolo.equals("")) throw new IllegalArgumentException ("titolo non può essere vuoto");
            Objects.requireNonNull (durata, "durata non può essere null");
            if ( durata.getSecondi() == 0) throw new IllegalArgumentException ("durata non può essere zero");

            this.titolo = titolo;
            this.durata = durata;
        }


        /**
        * costruttore che inizializza una Brano dato un titolo e una durata in secondi
        *
        * @param titolo il titolo del brano 
        * @param durata la durata del brano 
        * @throws NullPointerException se titolo è null
        * @throws NullPointerException se durata è null
        * @throws IllegalArgumentException se titolo è vuoto
        * @throws IllegalArgumentException se durata è uguale a zero
        */
        public Brano (final String titolo, final int durata) {
            Objects.requireNonNull (titolo, "titolo non può essere null");
            if ( titolo.equals("")) throw new IllegalArgumentException ("titolo non può essere vuoto");
            if ( durata <= 0) throw new IllegalArgumentException ("durata non può essere zero");

            this.titolo = titolo;
            this.durata = new Durata (durata);
        }


        /**
        * restituisce il titolo
        * @return il titolo del brano
        */
        public String getTitolo () {
            return this.titolo;
        }

        
        /**
        * restituisce la durata
        * @return la durata del brano
        */
        public Durata getDurata () {
            return this.durata;
        }


        @Override
        public String toString(){
            return titolo + " " + durata;  
        }

        // per fare l equals devo controllare anche l album di provenienza
        // per controllarlo posso fare in modo che il brano sappia in che album si trova ( lo aggiungo o come parametro oppure posso
        //                                                                                fare un metodo che restituisce album.this)



    }
    // da qua inizia l album


    
    //  AF: titolo rappresenta il titolo dell album e il valore di durata rappresenta la sua durata, l' i-esimo elementi di brani rappresenta il
    //      brano in posizione i all interno dell album
    //  RI:  titolo non può essere null
    //       titolo non può essere vuoto
    //       durata non può essere di zero secondi
    //       durata non può essere vuota
    //       brani non può essere null
    //       brani non può contenere elementi null
    //       durata deve essere la somma delle durate dei singoli brani
    //       (si potrebbe aggiungere che i brani non possono essere uguali)
    



    // Attributi
    
    private final String titolo;
    private final Durata durata;
    private final Brano [] brani;


    // Costruttori

    /**
    * costruttore che inizializza una Album dato un elenco di brani 
    *
    * @param titolo il titolo dell' album 
    * @param titoliBrani l elenco dei titoli dei brani
    * @param durataBrani l elenco delle durate dei brani
    * @throws NullPointerException se titolo è null
    * @throws IllegalArgumentException se titolo è vuoto
    * @throws IllegalArgumentException se titoliBrani e durataBrani hanno dimensione differente
    * @throws IllegalArgumentException se un elemento di durataBrani ha durata = 0
    * @throws IllegalArgumentException se un elemento di titoliBrani è vuoto
    * @throws NullPointerException se titoliBrani è null
    * @throws NullPointerException se un elemento di titoliBrani è null
    * @throws NullPointerException se durataBrani è null
    * @throws NullPointerException se un elemento di durataBrani è null
    */
    public Album (final String titolo, final String [] titoliBrani, final Durata [] durataBrani ) {
        Objects.requireNonNull (titolo, "titolo non può essere null");
        if ( titolo.equals("")) throw new IllegalArgumentException ("titolo non può essere vuoto");
        Objects.requireNonNull (titoliBrani, "titolibrani non può essere null");
        Objects.requireNonNull (durataBrani, "duratebrani non può essere null");
        if ( titoliBrani.length != durataBrani.length)  throw new IllegalArgumentException ("titoli e durate non hanno la stessa lunghezza");

        this.brani = new Brano[durataBrani.length];
        Durata tmp = new Durata(0);
        for ( int i = 0; i < titoliBrani.length; i++) {
            Objects.requireNonNull (titoliBrani[i], "titolibrani non può contenere elementi null");
            Objects.requireNonNull (durataBrani[i], "duratabrani non può contenere elementi null");
            if ( titoliBrani[i].equals("")) throw new IllegalArgumentException ("in titoliBrani non posso avere elementi vuoti");
            if (durataBrani[i].getSecondi() == 0 ) throw new IllegalArgumentException ("un brano non può avere durata 0");
            this.brani[i] = new Brano(titoliBrani[i], durataBrani[i]);
            tmp = tmp.somma(durataBrani[i]);
        }
        this.titolo = titolo;
        this.durata = tmp;
    }




    /**
    * restituisce il titolo
    * @return il titolo dell album
    */
    public String getTitolo () {
        return this.titolo;
    }

    
    /**
    * restituisce la durata
    * @return la durata dell album
    */
    public Durata getDurata () {
        return this.durata;
    }


    /**
    * restituisce un brano dato il suo titolo
    *
    * @return un brano dato il suo titolo
    * @param titolo il titolo dell' album 
    * @throws NullPointerException se titolo è null
    * @throws IllegalArgumentException se titolo è vuoto
    */
    public Brano getBrano (final String titolo) {
        Objects.requireNonNull (titolo, "titolo non può essere null");
        if ( titolo.equals("")) throw new IllegalArgumentException ("titolo non può essere vuoto");
        for ( Brano b : this.brani)
            if ( b.getTitolo().equals(titolo))
                return b;
        // se non trovo il brano lancio un eccezione o non restituisco nulla??
        throw new IllegalArgumentException ("brano non presente nell album");
    }


    /**
    * restituisce un brano data la sua posizione nell album
    *
    * @return un brano data la sua posizione
    * @param posizione la posizione del brano all interno dell album 
    * @throws IllegalArgumentException se posizione è minore di zero o maggiore uguale alla dimensione dell album
    */
    public Brano getBrano (final int posizione) {
        if ( posizione < 0 || posizione >= this.brani.length) 
            throw new IndexOutOfBoundsException ("la posizione non può essere < 0 o >= alla quantità di canzoni nell album");
        return this.brani[posizione] ;
    }


    /**
    * restituisce la posizione di un brano nell album dato il suo titolo
    *
    * @return la posizione di un brano dato il suo titolo
    * @param titolo il titolo dell' album 
    * @throws NullPointerException se titolo è null
    * @throws IllegalArgumentException se titolo è vuoto
    */
    public int getPosizione (final String titolo) {
        Objects.requireNonNull (titolo, "titolo non può essere null");
        if ( titolo.equals("")) throw new IllegalArgumentException ("titolo non può essere vuoto");

        for ( int i = 0; i < this.brani.length; i++)
            if ( this.brani[i].getTitolo().equals(titolo))
                return i;

        throw new IllegalArgumentException ("brano non presente nell album");
        // se non trovo il brano lancio un eccezione o non restituisco nulla??   così manca un return
    }



    @Override
    public Iterator<Album.Brano> iterator() {
        return Collections.unmodifiableCollection(Arrays.asList(this.brani)).iterator();
    }
    // trasformo l array in una lista e poi restituisco l iteratore della lista
    // avrei anche potuto fare io un iteratore custom, ma non avendo condizioni particolari non ha senso


 
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(titolo + "\n");
        for ( int i = 0; i < this.brani.length; i++) 
                str.append(this.brani[i].getTitolo() + "\n");
        str.append(durata);
        return str.toString();
    }





}
