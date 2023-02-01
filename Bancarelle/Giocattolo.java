import java.util.*;

public class Giocattolo{
    

    //  Overview : la classe Giocattolo è una classe concreta che modella un giocattolo
    //             le istanze di questa classe sono immutabili

    // AF : un giocattolo viene rappresentato dal suo nome, seguito dal materiale di cui è composto
    // RI : nome e materiale non devono essere null e non devono essere stringhe vuote



    // campi


    public final String nome;
    public final String materiale;


    // anche se non serve che sia private con i getter, si può comunque fare. All esame situazioni simili con oggetti
    // immutabili, conviene iniziare a farli con i campi public e poi se avanza tempo,si può convertirli in private con getter



    // costruttore

    
    public Giocattolo(final String nome, final String materiale){
        Objects.requireNonNull(nome, "nome non può essere null");
        Objects.requireNonNull(materiale, "materiale non può essere null");
        if ( nome == "") throw new IllegalArgumentException ("nome non può essere vuoto");
        if ( materiale == "") throw new IllegalArgumentException ("nome non può essere vuoto");
        this.nome = nome;
        this.materiale = materiale;
    }

    
    
    // metodi


    // public boolean equals(Giocattolo g ) {                                         //ATTENZIONE l equals NON è da fare così 
    //     if (g.nome.equals(this.nome) && g.materiale.equals(this.materiale) ) return true;
    //     return false;
    // }


    @Override 
    public boolean equals(Object o) {
        if (o == this) return true;        //non è da mettere per forza ma in equals con tante comparazioni può essere utile
        if (!(o instanceof Giocattolo)) return false;
        Giocattolo g = (Giocattolo) o;

        return g.nome.equals(this.nome) && g.materiale.equals(this.materiale);
    }


    @Override                              //se faccio l override di equals, DEVO farlo anche per hashcode
    public int hashCode() {
        return Objects.hash(nome, materiale);
    }




    // @Override                         //questo dovrebbe essere un hashcode fatto meglio, ma va bene anche quello sopra
    // public int hashCode() {
    //     int result = Short.hashCode(nome);
    //     result = 31 * result + Short.hashCode(materiale);
    //     return result;
    // }





    @Override
    public String toString(){
        return this.nome + " di "+ this.materiale;
    }




}
// il getNome e getMateriale non servono per forza perchè i parametri sono String (quindi immutabili) e sono final