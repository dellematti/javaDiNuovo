import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import java.util.Arrays;


public class Molecola {
    
  
    //  Overview : la classe Molecola è una classe concreta che modella una molecola
    //             le istanze di questa classe sono immutabili

    // AF : una molecola è rappresentata dall sua formula, cioè l insieme degli atomi che la compongono, in ordine alfabetico, dando priorità a C H N O
    // RI : atomi2numero non può essere null, formula non può essere null




    private final Map<String, Integer> atomi2numero; 
    private  final String formula;  
    private final String composizione;    
    private final float peso;
    private final TavolaPeriodica tavola;




    
    public Molecola (final String atomi, final TavolaPeriodica tavola){
        Objects.requireNonNull(atomi, "atomi non può essere null");
        Objects.requireNonNull(tavola, "tavola non può essere null");


        this.tavola = tavola;
        atomi2numero = new HashMap<>();
        float pesoTmp = 0;
        String formulaTmp = "";
        String[] elementi = Helpers.parseFormula(atomi);
        for ( int i = 0; i < elementi.length; i+= 2) atomi2numero.put(elementi[i], Integer.valueOf(elementi[i+1])  );
        
        Arrays.sort(elementi);
        for (int i = 0; i < elementi.length; i++ ){
            if (elementi[i].equals("C")){  //scambio elementi[i] con quello che c è in prima posizione, tanto ci saranno i numeri che non servono più
                elementi[0] = elementi[i];
                elementi[i] = "0";  
            }else if (elementi[i].equals("H")){  
                elementi[1] = elementi[i];
                elementi[i] = "0"; 
            }else if (elementi[i].equals("N")){  
                elementi[2] = elementi[i];
                elementi[i] = "0"; 
            }else if (elementi[i].equals("O")){  
                elementi[3] = elementi[i];
                elementi[i] = "0"; 
            }
        }

        for ( String atomo : elementi){
            if (! atomo.matches("-?\\d+(\\.\\d+)?")){   //se la stringa non è numerica
                formulaTmp += atomo;
                if (atomi2numero.get(atomo) > 1) {
                    formulaTmp += ( atomi2numero.get(atomo) );
                    float pesoAtomo = tavola.getPesoAtomo(atomo);
                    pesoTmp += pesoAtomo * atomi2numero.get(atomo);
                }
            }
        }
        formula = formulaTmp;
        peso = pesoTmp;

       
        if (elementi.length > 2) composizione = "composta";
        else composizione = "semplice";

    }



    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
       
        str.append(formula);
        str.append(", ");
        str.append(peso);
        str.append(", ");
        str.append(composizione);

        
        return str.toString();
    }




}
