import java.util.*;

public class Inventario{


    //  Overview : la classe Inventario è una classe concreta che modella un inventario in cui segno il nome dei giocattoli 
    //             disponibili e la quantità di ogni giocattolo
    //             le istanze di questa classe sono mutabili

    // AF : un inventario viene rappresentato dal nome dei giocattoli presenti, e per ogni giocattolo segno anche la sua quantità
    // RI : giocattolo non deve essere null, e la quantità di giocattoli non deve essere minore di zero




    // campi

    private final Map<Giocattolo, Integer> giocattoli;



    // costruttori

    public Inventario ( ){
        giocattoli = new HashMap<>();
    }




    // metodi



    // REQUIRES : ---
    // MODIFIES : this.giocattoli
    // EFFECTS : incrementa di numero la quantità di g presente in giocattoli, se g è null viene lanciata un 
    //           eccezione di tipo  NullPointerException
    // se numero è minore di 1 viene lanciata un eccezione di tipo IllegalArgumentException
    public void aggiungi(final int numero, final Giocattolo g){
        Objects.requireNonNull(g, "g non può essere null");
        if ( numero < 1) throw new IllegalArgumentException ("quantità giocattoli minore di 1");
        if ( giocattoli.containsKey(g) ) giocattoli.put(g, giocattoli.get(g) + numero); // giocattoli.replace(g, giocattoli.get(g), giocattoli.get(g) + 1);
        else giocattoli.put(g, numero);
    }


    // REQUIRES : ---
    // MODIFIES : this.giocattoli
    // EFFECTS : diminuisce di uno la quantità di g presente in giocattoli, 
    //           se g è null viene lanciata un eccezione di tipo NullPointerException
    //           se g non è presente in giocattoli viene lanciata un eccezione di tipo IllegalArgumentException
    public void rimuoviGiocattolo(Giocattolo g){
        Objects.requireNonNull(g, "g non può essere null");
        if ( giocattoli.containsKey(g) ){
            giocattoli.put(g, giocattoli.get(g) - 1);
            if (giocattoli.get(g) == 0) giocattoli.remove(g);
        }
        else throw new IllegalArgumentException ("questo giocattolo non è presente nella bancarella");
    }



    // REQUIRES : ---
    // MODIFIES : ---
    // EFFECTS : restituisce la quantità presente in giocattoli, di uno specifico giocattolo 
    //           se giocattolo è null viene lanciata un eccezione di tipo NullPointerException
    public Integer getGiocattoli_value(Giocattolo giocattolo){
        Objects.requireNonNull(giocattolo, "giocattolo non può essere null");
        if ( giocattoli.containsKey(giocattolo))  return giocattoli.get(giocattolo);
        else return 0;
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Giocattolo, Integer> mappa : giocattoli.entrySet()) {
            str.append(mappa.getKey());
            str.append(" ");
            str.append(mappa.getValue());
            str.append("\n");
        }
        return str.toString();
    }





}