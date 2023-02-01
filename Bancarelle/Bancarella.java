import java.util.*;

public class Bancarella{



    //  Overview : la classe Bancarella è una classe concreta che modella una bancarella
    //             le istanze di questa classe sono mutabili  
    //                                 //(perchè l inventario è mutabile ed è un parametro di bancarella che quindi diventa mutabile)

    // AF : una bancarella è rappresentata dal nome del proprietario,seguita dai giocattoli che vendono, con specificati anche
    //      la quantità e il prezzo dei vari giocattoli
    // RI : proprietario, inventario e listino non possono essere null, proprietario non può essere vuoto



    // campi

    public final String proprietario; 
    private final Inventario inventario;         
    private final Listino listino;           //dopo vedo se listino public o private



    // Costruttori


    public Bancarella (final String proprietario, final Inventario inventario, final Listino listino ){
        Objects.requireNonNull(proprietario, "proprietario non può essere null");
        Objects.requireNonNull(inventario, "inventario non può essere null");
        Objects.requireNonNull(listino, "listino non può essere null");
        if ( proprietario == "") throw new IllegalArgumentException ("proprietario non può essere vuoto");

        this.proprietario = proprietario;
        this.inventario = inventario;
        this.listino = listino;
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
            str.append(inventario + "\n");
        return str.toString();
    }




}