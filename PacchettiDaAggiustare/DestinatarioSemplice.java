import java.util.*;


public class DestinatarioSemplice implements Destinatario {

    // OVERVIEW: destinatario è la classe concreta che rapprenta il ricevente del messaggio, la classe
    //           riceve i pacchetti uno alla volta e in ordine 
    //           Gli oggetti di questo tipo sono mutabili



    // AF: un destinatario è un oggetto rappresentato da parametri e pacchetti, ossia i parametri che lo caratterisano e il
    //     pacchetti che ha ricevuto fino ad un determinato momemnto
    // RI: 
    //     pacchetti non deve essere null, e ogni suo elemento non deve eswere null
    //     parametri non null
    //     in pachetti ogni pacchetto in posizione i deve avere sequenza = i


    // Campi

    // private final List<Pacchetto> pacchetti;
    private List<Pacchetto> pacchetti;
    private final Parametri parametri;


    // Costruttori


    // EFFECTS : inizializza un destinatario dati i parametri che lo caratterizzano
    //           viene lanciata un eccezione di tipo NullPointerException se parametri è null
    public DestinatarioSemplice ( final Parametri parametri){
        this.parametri = Objects.requireNonNull(parametri, "no");
        this.pacchetti = new ArrayList<Pacchetto>();
    }

    // Metodi


    @Override
    public Parametri parametri(){
        return parametri;
    }


    @Override
    public boolean ricevi(Pacchetto pacchetto){
        if (pacchetto != null){                    
            this.pacchetti.add(pacchetto);
        }else {                              //se è null finisce la sequenza di pacchetti che riceve e stampo il messaggio
            List <Byte> tmpByte = new ArrayList<Byte>();
            for ( Pacchetto p : pacchetti)
                for (Byte b :  p.getContenuto())
                    tmpByte.add(b);
            System.out.Println(Decoder.decode ( tmpByte.toArray(), parametri.getCharset()));
            pacchetti = new ArrayList<Pacchetto>();           //se stampo il messaaggio cancello i pacchetti che avevo e mi preparo al prossimo
        }
        return true;             //restituisco sempre true nell implementazione semplice (?)
    }
    //per ora destinatario può ricevere pacchetti da chiunque (?)





}