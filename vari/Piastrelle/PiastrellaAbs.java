
/**
 * classe astratta che modella una piastrella, caratterizzata dalla sua superficie e dal costo
 */
public abstract class PiastrellaAbs implements Rivestimento {

    /* superficie della piastrella in cm quadri */
    private final int superficie;

    /*costo della piastrella */
    private final int costo;

    // AF: superficie = superficie della piastrella
    //     costo = costo della piastrella
    // RI: superficie > 0
    //     costo > 0


    /**
     * costruisce una Piastrella definita a partire dalla superficie e dal suo costo
     * 
     * @param superficie la superficie della piastrella
     * @param costo il costo della piastrella
     * @throws IllegalArgumentException se superficie è <= 0
     * @throws IllegalArgumentException se costo è <= 0
     */
    public PiastrellaAbs (final int superficie, final int costo) {   //costruttore public o private?
        if (superficie <= 0) throw new IllegalArgumentException("La superficie non può essere minore o uguale a zero, superficie inserita: " + superficie);
        if (costo <= 0) throw new IllegalArgumentException("Il costo non può essere minore o uguale a zero, costo inserito: " + costo);
        this.superficie = superficie;
        this.costo = costo;
    }
    

    
    @Override
    public int superficie() {
        return this.superficie;
    }


    @Override
    public int costo() {
        return this.costo;
    }


}