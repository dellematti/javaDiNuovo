import java.util.*;

public interface Destinatario {

    // OVERVIEW: è un interfaccia che modella il comporttamento di destinatario

    // EFFECTS: restituisce i parametri
    Parametri parametri();

    // MODIFIES: this.pacchetti
    // EFFECTS: riceve un pacchetto, restituisce true se riceve correttamente il pacchetto, ovvero
    // se il pacchetto non è stato modificato, false altrimenti
    boolean ricevi(Pacchetto pacchetto);
}