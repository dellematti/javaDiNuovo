// cntrl shift p     configure java runtime
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import java.util.Scanner;

public class MainProva{


    public static void main(final String[] args){

        // List <ElementoChimico> listaAtomi = new ArrayList <ElementoChimico> ();
        Set<ElementoChimico> listaAtomi = new HashSet<>();


        final Scanner s = new Scanner(System.in);
        int numeroAtomico = 1;  
        while (s.hasNextLine()){
            final String nome = s.next();
            final String simbolo = s.next();
            final float peso = s.nextFloat();

            ElementoChimico atomo = new ElementoChimico(numeroAtomico, nome, simbolo, peso);
            listaAtomi.add(atomo);
            numeroAtomico += 1;
        }
        // System.out.println(listaAtomi);
        TavolaPeriodica tavolaPeriodica = new TavolaPeriodica(listaAtomi);
        
        String tmp = "NaCl";     //questa poi va letta dalla riga di comando
        Molecola molecola = new Molecola(tmp, tavolaPeriodica);  //passerò direttamente la riga di comando
        System.out.println(molecola);







    }



}
