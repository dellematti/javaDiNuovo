import java.util.Objects;

/**
 * sono presenti i vari tipi di valuta, identificati da nome e dal loro simbolo
 */
public enum Valuta {
    // potrei anche associare un solo valore dei due e poi usare Valuta.name() per l altro, invece di avere sia nome che simbolo
    $ ("Dollaro", '$'),
    € ("Euro", '€'),
    ₣ ("Franco", '₣'),
    ₺ ("Lira", '₺'),
    ₹ ("Rupia", '₹'),
    £ ("Sterlina", '£'),
    ¥ ("Yen", '¥');


    /** il nome della valuta */
    private final String nome;

    /** il simbolo della valuta */
    private final char simbolo;


    // AF: valuta di nome = nome e simbolo = simbolo
    // RI: nome non vuoto e != null  

    /**
     * costruisce una Valuta, definita dal nome e dal simbolo
     * 
     * @param nome il nome della valuta
     * @param simbolo il simbolo della valuta
     * @throws NullPointerException se il nome della valuta è {@code null}
     * @throws IllegalArgumentException se nome è vuoto
     */
    Valuta(final String nome,final char simbolo) {
        if (nome.isEmpty()) throw new IllegalArgumentException("Il nome della valuta non può essere vuoto.");
        this.nome = Objects.requireNonNull(nome, "Il nome della valuta non può essere null");
        this.simbolo = simbolo;
    }



    /**
     * restituisce il nome della valuta
     * 
     * @return il nome della valuta
     */
    public String getNome() {
        return nome;
    }



    /**
     * restituisce il simbolo della valuta
     * 
     * @return il simbolo della valuta
     */
    public char getSimbolo() {
        return simbolo;
    }


    @Override
    public String toString() {
        return "Valuta [nome=" + nome + ", simbolo=" + simbolo + "]";
    }

}
