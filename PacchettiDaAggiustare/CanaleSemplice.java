import java.util.*;


public class CanaleSemplice implements Canale{

    // OVERVIEW : è una classe concreta di Canale che rappresenta un canale che riceve dei pacchetti e li può inoltrare,
    //            in maniera semplice ovvero un pacchetto alla vola, garantendo che non vengano alterati
    //            gli oggetti di questo tipo sono immutabili


    // AF : un canale semplice è raprpesentato dal destinatario a cui inoltra i messaggi

    // RI: destinatario != null



    // Campi
    private final Destinatario destinatario;

    // Costruttori

    // EFEFCTS: inizializzo un canaleSemplice , dato un destinatario
    //          viene lanciata
    public CanaleSemplice ( final Destinatario destinatario){
        this.destinatario = Objects.requireNonNull(destinatario, "destinatario non può essere null");
    }


    @Override
    public boolean inoltra (final Pacchetto pacchetto){
        Objects.requireNonNull(pacchetto, "pacchetto non può essere null");
        return destinatario.ricevi(pacchetto);
    }

    // EFFECTS : restituisce i parametri del destinario associato al canale
    public Parametri parametri(){
        return destinatario.parametri();
    }





}