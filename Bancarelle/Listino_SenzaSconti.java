import java.util.*;


public class Listino_SenzaSconti implements Listino{



    //  Overview : la classe Listino_SenzaSconti è una classe concreta che modella un listino di prezzi in cui ogni giocattolo 
    //             ha uno specifico prezzo
    //             le istanze di questa classe sono immutabili

    // AF : un Listino_SenzaSconti viene rappresentato da tutti i giocattoli presenti nel listino, ogni giocattolo è
    //      seguito dal suo prezzo
    // RI : giocattolo2prezzo non deve essere null ( devo dire che le cose contenute nella mappa non devono essere null?)




    // Campi



    private final Map<Giocattolo, Integer> giocattolo2prezzo = new HashMap<>();  //questo è in comune a tutte le classi 
    //  di listino quindi potrei fare una classe astratta anche con solo questo parametro



    // Costruttori


    public Listino_SenzaSconti(final Map<Giocattolo, Integer> giocattolo2prezzo){
        Objects.requireNonNull(giocattolo2prezzo, "giocattolo2prezzo non può essere null");   //esiste una mappa null??
        for (Map.Entry<Giocattolo, Integer> mappa : giocattolo2prezzo.entrySet()) {
            if (mappa.getKey() == null) throw new IllegalArgumentException ("giocattolo non può essere null");
            if (mappa.getValue() < 1) throw new IllegalArgumentException ("prezzo non valido");
            this.giocattolo2prezzo.put(mappa.getKey(), mappa.getValue());
        }
    }



    // Metodi


    @Override
    public int prezzo(final int quantità, final Giocattolo giocattolo){
        Objects.requireNonNull(giocattolo, "giocattolo non può essere null");
        if ( !giocattolo2prezzo.containsKey(giocattolo)) throw new IllegalArgumentException ("questo giocattolo non è presente nel listino");
        if (quantità <= 0)  throw new IllegalArgumentException ("la quantità deve essere maggiore di zero");
        return giocattolo2prezzo.get(giocattolo) * quantità;
    }




    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Giocattolo, Integer> mappa : giocattolo2prezzo.entrySet()) {
            str.append(mappa.getKey());
            str.append(" ");
            str.append(mappa.getValue());
            str.append("\n");
        }
        return str.toString();
    }




}