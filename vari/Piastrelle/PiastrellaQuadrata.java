
/**
 * classe concreta immutabile che rappresenta una Piastrella di tipo quadrato, caratterizzata quindi dalla singola dimensione 
 * di uno qualunque dei suoi lati
 */
public class PiastrellaQuadrata extends PiastrellaAbs {

    /*misura del lato della piastrella */
    private final int lato;

    // AF: lato della piastrella = lato
    // RI: lato > 0


    /**
     * costruisce una PiastrellaQuadrata definita dal suo lato e dal costo
     * 
     * @param lato il lato della piastrella
     * @param costo il costo della piastrella
     */
    public PiastrellaQuadrata ( final int lato, final int costo) {   //lancio eccezioni per lato?
        super(lato*lato, costo);
        this.lato = lato;
    }


    /**
     * restituisce il lato della piastrella
     * 
     * @return il lato della piastrella
     */
    public int lato() {
        return this.lato;
    }



    @Override
    public String toString() {
        return "Superficie: " + super.superficie() + " costo:  " + super.costo() + " lato:  " + lato;
    }



}