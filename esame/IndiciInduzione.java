import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IndiciInduzione implements Indici {

    /**
     *  AF : La classe è rappresentata dai suoi due indici di media e varianza
     *  RI : ---
     */


    // CAMPI

    private final double media;
    private final double varianza;  


    /**
     * Costruttore che inizializza IndiciInduzione dato un elenco di osservazioni x[i] appartenenti ad R
     * 
     * @param osservazioni sono i numeri su cui calcolare la varianza
     * @throws NullPointerException se osservazioni è null
     * @throws NullPointerException se un elemento di osservazioni è null
     */
    public IndiciInduzione(List <Double> osservazioni) {
        Objects.requireNonNull(osservazioni, "osservazioni non può essere null");
        Double u = 0.0, uPrecedente = 0.0;
        Double o = 0.0; 
        int n = osservazioni.size();
        int idx = 1;
        for ( Double x : osservazioni){
            Objects.requireNonNull(x, "osservazioni non può contenere null");
            uPrecedente = u;
            u = u +  (x - u) / idx;

            // o = o + (  (x - u) * ( x - uPrecedente ));
            idx++;
        }
        media = u;
        varianza = o/ n-1;
    }


    // METODI

    @Override
    public double varianza () {
        return varianza;
    }
    
    
    @Override
    public double media () {
        return media;
    }

}
