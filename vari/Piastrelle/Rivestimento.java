

/**
 * l interfaccia descrive il comportamento di un rivestimento, inteso come un qualunque possibile 
 * rivestimento caratterizzato dalla superficie che andrà a coprire e dal costo
 */
public interface Rivestimento {

    /**
     * restituisce la superficie del rivestimento
     * 
     * @return la superficie del rivestimento
     */
    public int superficie();


    /**
     * restituisce il costo del rivestimento
     * 
     * @return il costo del rivestimento
     */
    public int costo();


    
}