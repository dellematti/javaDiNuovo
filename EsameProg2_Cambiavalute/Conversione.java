
/**
 * interfaccia che descrive il comportamento di conversione, per convertire un Importo in un altro Importo differente
 */
public interface Conversione {
    // nel contesto del tema d' esame abbiamo solo un tipo di conversione, ma potrebbe essere utile averne altri
    
    /**
     * converte un importo in un importo differente
     * 
     * @param importoDaConvertire è l importo da convertire
     * @return un nuovo importo ottenuto convertendo l importo ricevuto 
     * @throws IllegalArgumentException se la Valuta di importoDaConvertire non è del tipo adatto alla conversione
     * @throws NullPointerException se importoDaConvertire è {@code null}
     */
    public Importo converti (Importo importoDaConvertire);

}
