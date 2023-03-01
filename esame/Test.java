import java.util.ArrayList;

import java.util.List;

public class Test {
    

    public static void main(String[] args) {
        
        List <Double> numeri = new ArrayList <>() ;
        // List <Integer> numeriInt = new ArrayList <>() ;


        numeri.add(49.80401);
        numeri.add(49.80400);
        numeri.add(49.80309);
        numeri.add(49.80399);


        // numeriInt.add(23);
        // numeriInt.add(18);


        double media = Media.media(numeri);
        System.out.println(media);



        IndiciDuePassate varianza = new IndiciDuePassate(numeri);
        System.out.println(varianza.varianza());

        IndiciUnaPassata varianza2 = new IndiciUnaPassata(numeri);
        System.out.println(varianza2.varianza());






    }
}
