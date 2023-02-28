import java.util.*;

public interface Sorgente{
    // OVERVIEW:  è un interfaccia che modella una sorgente che può inviare pacchetti attraverso uno specifico canale,
    //            che viene associato a sorgente in costruzione

    // EFFECTS: invia un pacchetto attraverso il canale associato a sorgente
    //           viene lanciata un eccezione di tipo  IllegalArgumentException se messaggio è vuoto
    //           viene lanciata un eccezione di tipo  NullPointerException se messaggio è null
    void trasmetti(String messaggio);
}

