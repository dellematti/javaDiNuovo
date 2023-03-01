import java.util.List;
import java.util.Objects;

/**
 * OVERVIEW: classe di utilità che offre metodi statici per il calcolo della media tra numeri
 */

public class Media {

    private Media(){}


    /**
    * restituisce la media dell elenco di numero che gli viene passato
    * <p>
    * La media viene restituita (approssimazoine di tot dopo la virgola      da aggiungere)
    *
    * @param numeri i numeri di cui calcolare la media
    * @return la media dei numeri
    * @throws NullPointerException se numeri è null
    * @throws NullPointerException se un elemento contenuto in numeri è null
    */
    public static double media(List <Double> numeri) {
        Objects.requireNonNull(numeri, "numeri non può essere null");
        Double sum = 0.0;
        for (Double f : numeri){
            Objects.requireNonNull(f, "il contenuto di numeri non può essere null");
            sum += f;
        }
        return sum / numeri.size();
    }




    // public static double media(List <Integer> numeri) {
    // }






}