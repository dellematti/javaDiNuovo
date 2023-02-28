import java.util.*;

public interface Canale {
    // OVERVIEW: è un interfaccia che modella il comportamento di un canale attraverso cui inoltrare mesaggi,
    //           il canale si riferisce ad uno specifico destinatario
    
    // EFFECTS: restituisce parametri
    Parametri parametri();

    // EFFECTS: invia pacchetto al destinatario associato al canale restituisce true se invia coorettamente il pacchetto, false
    //          altrimenti (se il contenuto di pacchetto è null stampa il contenuto dei pacchetti inviati fino ad adesso)
    boolean inoltra(Pacchetto pacchetto);
}
