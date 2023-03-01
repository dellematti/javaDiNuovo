import java.util.List;
import java.util.Objects;

/**
 * OVERVIEW : le istanze di questa classe servono a rappresentare il calcolo degli indici di varianza e media effettuati
 *            su un elenco di osservazioni (numeri appartenenti ad R)
 *            Gli oggetti di questo tipo sono immutabili
 */
public class IndiciUnaPassata implements Indici {

    /**
     *  AF : La classe è rappresentata dai suoi due indici di media e varianza
     *  RI : ---
     */


    // CAMPI

    private final double media;
    private final double varianza;


    // COSTRUTTORI

    /**
     * Costruttore che inizializza IndiciUnaPassata dato un elenco di osservazioni x[i] appartenenti ad R
     * 
     * @param osservazioni sono i numeri su cui calcolare la varianza
     * @throws NullPointerException se osservazioni è null
     * @throws NullPointerException se un elemento di osservazioni è null
     */
    public IndiciUnaPassata(List <Double> numeri) {
        Double x1 = 0.0;
        Double x2 = 0.0; 
        int n = numeri.size();

        for ( Double d : numeri) {
            Objects.requireNonNull(d, "numeri non può avere elementi null");
            x1 += Math.pow(d, 2);
            x2 += d;
        }
        media = x2/n;
        varianza = ( n * x1 - Math.pow(x2,2) ) / n * (n-1);
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
