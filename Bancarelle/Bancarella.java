import java.util.*;

public class Bancarella{



    //  Overview : la classe Bancarella è una classe concreta che modella una bancarella
    //             le istanze di questa classe sono mutabili  
    //                                 //(perchè l inventario è mutabile ed è un parametro di bancarella che quindi diventa mutabile)

    // AF : una bancarella è rappresentata dal nome del proprietario,seguita dai giocattoli che vendono, con specificati anche
    //      la quantità e il prezzo dei vari giocattoli
    // RI : proprietario, inventario e listino non possono essere null, proprietario non può essere vuoto



    // campi

    private final String proprietario; 
    private final Inventario inventario;         
    private final Listino listino;          



    // Costruttori


    public Bancarella (final String proprietario, final Inventario inventario, final Listino listino ){
        this.proprietario = Objects.requireNonNull(proprietario, "proprietario non può essere null");
        this.inventario = Objects.requireNonNull(inventario, "inventario non può essere null");
        this.listino = Objects.requireNonNull(listino, "listino non può essere null");
        if ( proprietario.equals("")) throw new IllegalArgumentException ("proprietario non può essere vuoto");
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
            str.append(inventario + "\n");
        return str.toString();
    }




}
