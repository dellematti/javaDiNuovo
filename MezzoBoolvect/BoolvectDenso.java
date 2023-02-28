import java.util.Objects;
import java.util.*;

public class BoolvectDenso implements Boolvect{


    /**
    * OVERVIEW: classe concreta che rappresenta un BoolvectDenso, ossia un vettore di valori di verità, in cui
    *           il numero di valori di verità True non è molto inferiore alla taglia, la taglia è il numero di
    *           elementi nel vettore
    *           le istanze di questa classe sono immutabili    
    */


    /**
    * AF: un Boolvect è rappresentato dal vettore di valori, dalla taglia e dalla dimensione, mentre la taglia
    *     specifica il numero totale di elementi nel vettore, la dimensione equivale a 1+ la posizione dove si trova
    *     l ultimo elemento con valore True.
    * RI: valori non può essere null,
    *     taglia deve essere uguale alla dimensione di valori
    *     dimensione deve essere maggiore uguale a uno e minore uguale alla taglia
    */


    //CAMPI


    private final boolean[] valori;
    private final int taglia;
    private final int dimensione;


    //COSTRUTTORI


    /**
    * costruttore che inizializza un BoolvectDenso da un vettore di booleani
    *
    * @param valori il vettore di booleani 
    * @throws NullPointerException se valori è null
    */
    public BoolvectDenso(final boolean[] valori) {
        Objects.requireNonNull(valori, "valori non può essere null");
        taglia = valori.length;
        this.valori = new boolean[valori.length];
        int dimensioneTMP = 1;
        for ( int i = 0; i < valori.length; i++){ 
            this.valori[i] = valori[i]; 
            if (this.valori[i] == true) dimensioneTMP = i+1;
        }
        this.dimensione = dimensioneTMP;    
    }


    //METODI


    @Override
    public Boolvect set(int p , boolean a){       
        if (p < 0 || p >= this.taglia) throw new IndexOutOfBoundsException("indice p non valido");
        // boolean[] valoriNuovi = this.valori; //questo NON va bene perchè poi modificando valoriNuovi modifico anche this.valori
        boolean[] valoriNuovi = this.valori.clone();
        valoriNuovi[p] = a;
        return new BoolvectDenso(valoriNuovi);       
    }
    

    @Override
    public boolean get(int p){
        if (p < 0 || p >= this.taglia) throw new IndexOutOfBoundsException("indice p non valido");
        if ( p > this.dimensione) return false;
        return this.valori[p];
    }


    @Override
    public Boolvect and (Boolvect b){
        Objects.requireNonNull(b, "b non può essere null");
        boolean[] andArray;
        if (this.taglia > b.getTaglia()) andArray = new boolean[this.taglia];
        else andArray = new boolean[b.getTaglia()];

        for ( int i = 0; i < andArray.length; i++){          //VA BENE CON B BOOLVECT DENSO
            if ( i >= this.taglia) andArray[i] = b.get(i);
            else if (i >= b.getTaglia()) andArray[i] = this.valori[i];
            else if (this.valori[i] == true && b.get(i) == true) andArray[i] = true;
            else andArray[i] = false;
        }
        return new BoolvectDenso(andArray);        //controllare quanti valori true ci sono rispetto alla taglia e scegliere
        // return new BoolvectSparso(andArray);
    }


    @Override
    public Boolvect or (Boolvect b){
        boolean[] myvalori = {true,false,false,true};
        return new BoolvectDenso(myvalori);  //per compilare
    }


    @Override
    public Boolvect xor (Boolvect b){
        boolean[] myvalori = {true,false,false,true};
        return new BoolvectDenso(myvalori);  //per compilare
    }


    @Override
    public int getTaglia(){
        return this.taglia;
    }


    /**
    * restituisce un vettore con i valori di Boolvect
    */
//     public boolean[] getValori(){
//         // return this.valori;         //cosi NON si può fare, restituisce il riferimento a valori e poi può essere modificato
//         boolean[] valoriTMP = new boolean[this.valori.length];
//         for (int i = 0; i < this.valori.length; i++) valoriTMP[i] = this.valori[i];
// 
//         return valoriTMP;
//     }


   @Override
    public String toString(){
        StringBuilder str =  new StringBuilder("");
        for ( boolean b : this.valori) str.append(b);
        return str.toString();
    }



}