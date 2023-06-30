public class Test {
    public static void main(String[] args) {
        



        // $100

        Importo importo = new Importo(100, Valuta.$);
        Importo importo2 = new Importo(104, Valuta.$);
        Importo importo3 = new Importo(1027, Valuta.€);


        System.out.println(importo);
        System.out.println(importo.somma(importo2));
        // System.out.println(importo.somma(importo3));
    

        Cassa cassa = new Cassa();

        cassa.versa(importo);
        cassa.versa(importo2);
        cassa.versa(importo3);

        for (Valuta val : Valuta.values()) {
          System.out.println(val.name());   
        }
        System.out.println(Valuta.values()[0]);  

        

    
    
    
    
    
    
    }



}
