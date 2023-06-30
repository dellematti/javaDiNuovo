/**
* OVERVIEW: Interfaccia che descrive i comportamenti di Boolvect, un vettore costituito da soli valori 
* di verità true o false
*/
public interface Boolvect{

    /**
    * restituisce il Boolvect ottenuto , inserendo un valore di verità in una specifica posizione
    *
    * @param  p  la posizione in cui inserire il valore di verità
    * @param  a  il valore di verità da inserire
    * @return il nuovo Boolvect ottenuto modificando il precedente 
    * @throws OutOfBoundException se la posizione p è minore di zero o maggiore della dimensione del Boolvect
    */
    public Boolvect set(int p , boolean a);


    /** 
    * restituisce il valore di verità presente in una specifica posizione
    *
    * @param  p  la posizione di cui si vuole sapere il valore di verità
    * @return  il valore di verità trovato in quella posizione
    * @throws OutOfBoundException se la posizione p è minore di zero o maggiore della taglia del Boolvect
    */
    public boolean get(int p);


    /**
    * Operazione di and tra due boolvect
    *
    * <p>operazione binaria tra Boolvect che restituisce il Boolvect ottenuto in cui: in ogni posizione 
    * il valore sarà true se e solo se per entrambi i Boolvect in ingresso il valore della medesima 
    * posizione è true, false altrimenti
    *
    * @param  b  secondo Boolvect con cui fare i confronti dei valori di verità
    * @return  il nuovo Boolvect ottenuto come risultato dell operazione
    * @throws NullPointerException se b è un riferimento null
    */
    public Boolvect and (Boolvect b);


    /**
    * Operazione di or tra due boolvect
    *
    * <p>operazione binaria tra Boolvect che restituisce il Boolvect ottenuto in cui: in ogni posizione 
    * il valore sarà true se e solo se in almeno uno dei due Boolvect in ingresso il valore della medesima 
    * posizione è true, false altrimenti
    *
    * @param  b  secondo Boolvect con cui fare i confronti dei valori di verità
    * @return  il nuovo Boolvect ottenuto come risultato dell operazione
    * @throws NullPointerException se b è un riferimento null
    */  
    public Boolvect or (Boolvect b);


    /**
    * Operazione di xor tra due boolvect
    *
    * <p>operazione binaria tra Boolvect che restituisce il Boolvect ottenuto in cui: in ogni posizione 
    * il valore sarà true se e solo se in esattamente uno dei due Boolvect in ingresso il valore della medesima 
    * posizione è true, false altrimenti
    *
    * @param  b  secondo Boolvect con cui fare i confronti dei valori di verità
    * @return  il nuovo Boolvect ottenuto come risultato dell operazione
    * @throws NullPointerException se b è un riferimento null
    */  
    public Boolvect xor (Boolvect b);


    /**
    * restituisce la taglia del Boolvect ossia la massima dimensione possibile del Boolvect
    *
    * @return  il valore della taglia
    */
    public int getTaglia();


    /**
    * restituisce la dimensione del Boolvect, ossia il massimo indice in cui il contenuto è un valore di verità true 
    *
    * @return  il valore della dimensione
    */
    public int getDimensione();


}