import java.util.Objects;

/**
 * classe concreta immutabile rappresentante un TassoCambio, utile a convertire un Importo da una Valuta all altra basandosi sul valore di due importi
 */
public class TassoCambio implements Conversione {

    /** il primo importo del tasso id cambio */
    private final Importo importo1;

    /** il secondo importo del tasso id cambio */
    private final Importo importo2;

    // AF: il primo importo del tasso = importo1 e il secondo importo = importo2
    // RI: importo1 != null
    //     importo2 != null
    //     valuta di importo1 != valuta di importo2

    /**
     * 
     * @param importo1 il primo importo del tasso
     * @param importo2 il secondo importo del tasso
     * @throws IllegalArgumentException se i due importi hanno valuta differente
     * @throws NullPointerException se il primo importo è {@code null}
     * @throws NullPointerException se il secondo importo è {@code null}
     */
    public TassoCambio(Importo importo1, Importo importo2) {
        if (importo1.getValuta() == importo2.getValuta()) throw new IllegalArgumentException("I due importi del tasso di cambio devono avere valuta differente.");
        this.importo1 = Objects.requireNonNull(importo1, "Il primo importo del tasso id cambio non può essere null");
        this.importo2 = Objects.requireNonNull(importo2, "Il secondo importo del tasso id cambio non può essere null");
    }


    @Override
    public Importo converti (Importo importoDaConvertire) {
        if(importoDaConvertire.getValuta() != importo1.getValuta() && importoDaConvertire.getValuta() != importo2.getValuta()  )
            throw new IllegalArgumentException("importoDaConvertire è di valuta" + importoDaConvertire.getValuta() + "mentre importo1 e importo2 sono di valuta " + importo1.getValuta() + " e " + importo2.getValuta()  ); 
        Objects.requireNonNull(importoDaConvertire, "importoDaConvertire non può essere null");

        if(importoDaConvertire.getValuta() == importo2.getValuta()) {
            int valore = (importo1.getValore() * importoDaConvertire.getValore()) / importo2.getValore();
            return new Importo (valore, importo1.getValuta());
        }else {
            int valore = (importo2.getValore() * importoDaConvertire.getValore()) / importo1.getValore();
            return new Importo (valore, importo2.getValuta());
        }
    }


    /**
     * restituisce il primo importo del tasso
     * 
     * @return il primo importo del tasso
     */
    public Importo getImporto1() {
        return importo1;
    }


    /**
     * restituisce il secondo importo del tasso
     * 
     * @return il secondo importo del tasso
     */
    public Importo getImporto2() {
        return importo2;
    }


    @Override
    public String toString() {
        return "TassoCambio [importo1=" + importo1 + ", importo2=" + importo2 + "]";
    }



    


}
