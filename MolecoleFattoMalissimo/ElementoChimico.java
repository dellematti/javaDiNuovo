import java.util.Objects;

public class ElementoChimico {




    //  Overview : la classe ElementoChimico è una classe concreta che modella un atomo
    //             le istanze di questa classe sono immutabili

    // AF : un atomo è rappresentato dal suo simbolo
    // RI : numeroAtomico e peso non possono essere minori di 1, 
    //      nome e simbolo non possono essere vuoti o null





    // Campi

    private final int numeroAtomico;   //parte da 1 e coincide col numero di righe
    private final String nome;
    private final String simbolo;
    private final float peso;



    // Costruttori


    //crea un istanza di elementoChimico, lancia un eccezione di tipo IllegalArgumentException se numeroAtomico o peso sono minori di 1,  
    //  lancia un eccezione di tipo NullPointerException se nome o simbolo sono null
    public ElementoChimico(final int numeroAtomico, final String nome, final String simbolo, final float peso){
        Objects.requireNonNull(nome, "nome non può essere null");
        Objects.requireNonNull(simbolo, "simbolo non può essere null");
        if ( nome.equals("")) throw new IllegalArgumentException ("nome non può essere vuoto");
        if (  simbolo.equals("")) throw new IllegalArgumentException ("nome non può essere vuoto");
        if ( numeroAtomico < 1) throw new IllegalArgumentException ("numeroAtomico minore di 1");
        if ( peso < 1) throw new IllegalArgumentException ("peso minore di 1");

        this.numeroAtomico = numeroAtomico;
        this.nome = nome;
        this.simbolo = simbolo;
        this.peso = peso;
    }

    // REQUIRES : ---
    // MODIFIES : ---
    // EFFECTS : restituisce il nome dell elemento chimico
    public String getNome (){
        return nome;
    }


    // REQUIRES : ---
    // MODIFIES : ---
    // EFFECTS : restituisce il peso dell elemento chimico
    public float getPeso (){
        return peso;
    }


    @Override 
    public boolean equals(Object o) {
        if (o == this) return true;       
        if (!(o instanceof ElementoChimico)) return false;
        ElementoChimico e = (ElementoChimico) o;

        return e.nome.equals(this.nome) && e.simbolo.equals(this.simbolo) && e.numeroAtomico == this.numeroAtomico && e.peso == this.peso;
    }


    @Override                             
    public int hashCode() {
        return Objects.hash(nome, simbolo, peso, numeroAtomico);
    }






    @Override
    public String toString(){            
        return simbolo;
    }





    
}
