import java.util.*;
// import java.lang.Object;
import java.nio.charset.*;
import java.util.zip.*;

public class Parametri {

    // OVERVIEW: le istanze di questa classe cocnreta servono a rappresentare alcuni specifici parametri di
    //           trasmissione dei messaggi,
    //           gli oggetti di questo tipo sono immutabili


    // AF: i parametri sono rappresentati da dimensione, ovvero il numero di byte che costituiscono il contenuto del
    //     pacchetto, charset ovvero il charset usato per codificare la stringa in byte, e algoritmo cioè 
    //     l algoritmo di cheksum usato per calcolare il numero di controllo
       
    // RI: dim >= 0
    //      charset != null
    //      checksum != null


    // Campi

    private final int dimensione;
    private final Charset charset;                  
    private final Checksum algoritmo;



    // Costruttori

    // EFFECTS: Inizializza un instanza di parametri, dati la dimensione, il charset e l algoritmo di checksum
    //           viene lanciata un eccezione di tipo IllegalArgumentException se dimensione è minore di zero 
    //           viene lanciata un eccezione di tipo NullPointerException se charset è null
    //           viene lanciata un eccezione di tipo NullPointerException se checksum è null
    public Parametri(final int dimensione, Charset charset, Checksum algoritmo){
        if (dimensione < 0) throw new IllegalArgumentException ("dimensione non può avere valori negativi");
        this.charset = Objects.requireNonNull(charset, "charset non può essere null");
        this.algoritmo = Objects.requireNonNull(algoritmo, "algoritmo non può essere null");
        this.dimensione = dimensione;
    }


    // Metodi

    // EFFECTS: restituisce la dimensione
    public int getDimensione( ){
        return this.dimensione;
    }


    // EFFECTS: restituisce il charset
    public Charset getCharset( ){
        return this.charset;
    }


    // EFFECTS: restituisce l algoritmo di checksum
    public Checksum getAlgoritmo( ){
        return this.algoritmo;
    }



}