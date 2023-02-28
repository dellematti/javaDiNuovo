import java.util.*;

public class SorgenteSemplice implements Sorgente{


    // OVERVIEW :  è una classe concreta che rappresenta un sorgente che invia pacchetti in ordine di sequenza e uno
    //             soltanto alla volta, attraverso un canale che viene associato in costruzione
    //             le istanze sono di tipo immutabile


    // AF : un sorgenteSemplice è rappresentata da canale ossia il canale associato alla sorgente

    //  RI: Canale != null


    // Campi

    private final Canale canale;


    // Costruttori

    public SorgenteSemplice ( final Canale canale){
        this.canale = Objects.requireNonNull(canale, "canale non può essere null");
    }


    // Metodi

    // EFFECTS: restituisce canale
    public Canale getCanale(){
        return this.canale;
    }

    // EFFECTS : converte il messaaggio in pacchetti e li invia uno alla volta, attraverso il canale
    //           viene lanciata un eccezione di tipo IllegalArgumentException se il messaggio non viene inoltrato correttamente 
    public void trasmetti(String messaggio){
        Parametri parametri = this.canale.parametri();
        Byte[] arrayByte = Encoder.codifica(messaggio, parametri.getCharset() );  //decodifica è una classe statica di utilita

        for ( int i = 0; i < arrayByte.length; i += parametri.getDimensione()  ){
                Byte[] tmpByte  = new Byte[parametri.getDimensione()];
            for ( int j = 0 ; j < parametri.getDimensione(); j++ )
                tmpByte[j] = arrayByte[i+j]; 
            Pacchetto pacchetto = new Pacchetto (i,tmpByte, parametri.getAlgoritmo().getValue() );
            if (!this.canale.inoltra(pacchetto)) throw new IllegalArgumentException ("il messaggio non è stato inoltrato correttamente");
        }





    }






}