public class Test{


    public static void main(final String[] args) {

        boolean[] myvalori = {true,false,false,true};
        Boolvect boolvect = new BoolvectDenso(myvalori);

     

        System.out.println(boolvect);
        Boolvect boolvect2 = boolvect.set(1,true);
        System.out.println(boolvect2);

        Boolvect and = boolvect.and(boolvect2);
        System.out.println(and);

    }

}