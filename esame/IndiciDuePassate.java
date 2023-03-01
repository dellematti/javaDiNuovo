import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OVERVIEW : le istanze di questa classe servono a rappresentare il calcolo degli indici di varianza e media
 *            Gli oggetti di questo tipo sono immutabili
 */
public class IndiciDuePassate implements Indici {


    /**
     * AF : la classe viene raprpesentata dall elenco di osservazioni su cui devono calcolare la varianza e la
     * media, le osservazioni sono numeri appartenenti ad R.
     * RI : osservazioni != null e ogni suo elemento != null
     */

    
    // CAMPI

    private final List <Double > osservazioni;


    // COSTRUTTORI

    /**
     * Costruttore che inizializza IndiciDuePassate dato un elenco di osservazioni x[i] appartenenti ad R
     * 
     * @param osservazioni sono i numeri su cui calcolare la varianza
     * @throws NullPointerException se osservazioni è null
     * @throws NullPointerException se un elemento di osservazioni è null
     */
    public IndiciDuePassate(List <Double> osservazioni) {
        Objects.requireNonNull(osservazioni, "osservazioni non può essere null");
        this.osservazioni = new ArrayList<Double> ();
        for ( Double b : osservazioni){
            Objects.requireNonNull(b, "osservazioni non può contenere null");
            this.osservazioni.add(b);
        }
    }



    // METODI

    @Override
    public double varianza () {
        Double media = Media.media(osservazioni);
        Double sum = 0.0;
        for ( Double d : this.osservazioni) {
            sum += Math.pow ( d - media, 2);
        }
        return sum / this.osservazioni.size() -1;
    }


    @Override
    public double media () {
        return Media.media(osservazioni);
    }





}
