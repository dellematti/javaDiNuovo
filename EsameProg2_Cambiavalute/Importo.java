import java.util.Objects;



/**
 * classe concreta immutabile rappresentante un importo definito dal suo valore e dal tipo di valuta
 * è possibile effettuare somme e sottrazioni tra importi delle stessa valuta
 */
public class Importo {
    
    /** il valore dell importo, espresso in centesimi */
    private final int valore;

    /** la valuta dell importo */
    private final Valuta valuta;


    // AF: Importo dove il valore (in centesimi ) = valore e la valuta = valuta
    // RI: Valuta != null


    /**
     * costruisce un importo, definito dal suo valore in centesimi e valuta
     * 
     * @param valore il valore dell importo  //non ci sono controlli sull importo perchè può anche essere negativo, ad esempio nel caso di debiti
     * @param valuta la valuta dell importo
     * @throws NullPointerException se la valuta dell importo è {@code null}
     */
    public Importo(int valore, Valuta valuta) {
        
        this.valore = valore;
        this.valuta = Objects.requireNonNull(valuta, "La valuta dell importo non può essere null");
    }
    // aggiungere costruttore che riceve il valore in stringa e lo converte in centesimi


    /**
     * restituisce un nuovo importo equivalente alla somma tra {@code this} e il parametro
     * 
     * @param importo l importo da sommare
     * @return un nuovo importo equivalente alla somma tra {@code this} e il parametro
     * @throws NullPointerException se la valuta dell importo è {@code null}
     * @throws IllegalArgumentException se i due importi da somamre hanno valuta diversa
     */
    public Importo somma (Importo importo) {
        if(this.valuta != importo.getValuta()) throw new IllegalArgumentException("Gli importi devono avere la stessa valuta.");
        Objects.requireNonNull(importo, "Importo non può essere null");

        int valore = importo.getValore();
        System.out.println(this.valore + valore);
        return new Importo((this.valore + valore), this.valuta);
    }


    /**
     * restituisce il valore dell importo
     * 
     * @return il valore dell importo
     */
    public int getValore() {
        return valore;
    }


    /**
     * restituisce la valuta dell importo
     * 
     * @return la valuta dell importo
     */
    public Valuta getValuta() {
        return valuta;
    }


    @Override
    public String toString() {
        return "Importo [valore=" + valore/100 + "," + valore%100 + ", valuta=" + valuta.getSimbolo() + "]";
    }


    





    
}
