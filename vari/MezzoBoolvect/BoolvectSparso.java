import java.util.Objects;
import java.util.*;

public class BoolvectSparso implements Boolvect{


    /**
    * OVERVIEW: classe concreta che rappresenta un BoolvectSparso, ossia un vettore di valori di verità, in cui
    *           il numero di valori di verità True è molto inferiore alla taglia, la taglia è il numero di
    *           elementi nel vettore
    *           le istanze di questa classe sono immutabili    
    */

    /**
    * AF: essendoci pochi valori true rispetto al totale dei valori, un Boolvect è rappresentato
    *     dai soli indici di posizione dei valori positivi (che sono gli indici contenuti in posizioni), 
    *     dalla taglia che specifica il numero totale di elementi nel vettore
    *     dalla dimensione che equivale a 1 + la posizione dove si trova l ultimo elemento con valore True.
    * RI: posizioni non deve essere null e ogni valore al suo interno non deve essere null e deve essere contenuto una sola volta
    *     taglia deve essere maggiore di zero
    *     dimensione deve essere maggiore di zero e minore uguale alla taglia
    */

    // CAMPI

    private final Set <Integer> posizioni;      //CON UN SET USARE INTEGER, NON USARE INT
    private final int taglia;
    private final int dimensione;

    // COSTRUTTORI

    public BoolvectSparso(){}
    = new HashSet<Integer>(); 




}