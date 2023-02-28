import java.util.Set;
import java.util.HashSet;
import java.util.Objects;



public class TavolaPeriodica {

   
    //  Overview : la classe TavolaPeriodica è una classe concreta che modella una tavola periodica
    //             le istanze di questa classe sono immutabili

    // AF : ---
    // RI : elementi non può essere null e ogni Elemento chimico al suo interno non può essere null


    // Campi

    private final Set<ElementoChimico> elementi;



    // Costruttori
    
    //costruisce un istanza della tavola periodica, viene sollevata un eccezione di tipo NullPointerException se elementi è null
    public TavolaPeriodica(final Set<ElementoChimico> elementi){
        Objects.requireNonNull(elementi, "elementi non può essere null");
        this.elementi = new HashSet<>();
        for ( ElementoChimico e : elementi) this.elementi.add(e);
    }


    // Metodi


    // REQUIRES : ---
    // MODIFIES : ---
    // EFFECTS : restituisce il peso di uno specifico atomo, 
    //           se l atomo è nul viene soillevata un eccezione di tipo NullPointerException, 
    //           se l atomo è vuoto viene sollevata un eccezione di tipo IllegalArgumentException
    public float getPesoAtomo(final String atomo) {
        Objects.requireNonNull(atomo, "atomo non può essere null");
        float peso = 0;
        if ( atomo.equals("")) throw new IllegalArgumentException("atomo non può essere vuoto");
        for (ElementoChimico elemento: elementi){
            if( elemento.getNome().equals(atomo)) peso =  elemento.getPeso();
        }
        
        return peso;
    }
    //avendo questo come metodo statico potrei evitare di passare la tavolaperiodica alle molecole




}
