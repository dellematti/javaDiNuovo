import java.util.*;

public class Pacchetto {

    //OVERVIEW: Pacchetto è una classe concreta che rappresenta un pacchetto contente parte di un messaggio
    //          le istanze di questa classe sono immutabili 


    // AF: un pacchetto è rappresentato da sequenza, ossia la posizione nell elenco di pacchetti, nel caso il messaggio sia
    //     diviso in diversi pacchetti, contenuto è banalmente la parte di messaggio contenuta nel pacchetto mentre checksum
    //      è il numero ottenuto dall algoritmo di checksum

    // RI: sequenza >= 0
    //     contenuto != null e ogni elemento in contenuto != null


    // Campi 

    private final int sequenza; 
    private final Byte[] contenuto;
    private final long checksum;



    // Costruttori

    // EFFECTS : inizializza un pacchetto dati sequenza, contenuto e checksum
    //           viene lanciata un eccezione di tipo  IllegalArgumentException se sequenza è minore di zero 
    //           viene lanciata un eccezione di tipo  NullPointerException se contenuto è null
    //           viene lanciata un eccezione di tipo  NullPointerException se un elemnto di contenuto è null
    public Pacchetto (final int sequenza, final Byte[] contenuto, final long checksum ){
        if (sequenza < 0) throw new IllegalArgumentException ("sequenza non può avere valori negativi");
        Objects.requireNonNull(contenuto, "contenuto non può essere null");
        int i = 0;
        this.contenuto = new Byte[contenuto.length];
        for ( Byte b: contenuto){
            this.contenuto[i++] = Objects.requireNonNull(contenuto[i], "l elemento di contenuto non può essere null");
            // i++;
        }
        this.sequenza = sequenza;
        this.checksum = checksum;
    }



    // Metodi

    // EFFECTS: restituisce sequenza
    public int getSequenza(){
        return this.sequenza;
    }

    // EFFECTS: restituisce contenuto
    public Byte[] getContenuto(){
        return this.contenuto;
    }

    // EFFECTS: restituisce checksum
    public long getChecksum(){
        return this.checksum;
    }




}