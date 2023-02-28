import java.util.Objects;

public class Book {

    // OVERVIEW : Questa classe serve a rappresentare un libro, le istanze di questa classe sono immutabili
//Le istanze di questa classe rappresentano dei libri. Gli oggetti di questo tipo solo immutabili (cosi la scrive il prigioniero)


    // AF: Un libro è rappresentato da name, isbnNumber e authorName, che sono banalmente il nome del libro, il numero isbn e il 
    //     nome dell autore del libro mentre publisher rappresenta il nome della casa produttrice che pubblica il libro
    // RI: name non può essere null o vuoto
    //     isbnNumber non può essere minore di zero
    //     authorName non può essere null o vuoto
    //     publisher non può essere null o vuoto


    // Campi

    private final String name;
    private final int isbnNumber;
    private final String authorName;
    private final String publisher;


    // Costruttori


    // EFFECTS : inizializza un libro, dato il suo nome, il suo numero ISBN, il nome dell autore e il nome del pubblicatore
    //           viene lanciata un eccezione di tipo  NullPointerException se nome è null
    //           viene lanciata un eccezione di tipo  IllegalArgumentException se nome è vuoto 
    //           viene lanciata un eccezione di tipo  IllegalArgumentException se il numero ISBN è minore di zero 
    //           viene lanciata un eccezione di tipo  NullPointerException se authorName è null
    //           viene lanciata un eccezione di tipo  IllegalArgumentException se authorName è vuoto 
    //           viene lanciata un eccezione di tipo  NullPointerException se publisher è null
    //           viene lanciata un eccezione di tipo  IllegalArgumentException se publisher è vuoto 
    public Book (final String name, final int isbnNumber, final String authorName, final String publisher){
        Objects.requireNonNull(name, "nome non può essere null");
        if (name.equals("")) throw new IllegalArgumentException ("nome non può essere una stringa vuota");
        if (isbnNumber < 0) throw new IllegalArgumentException ("il numero ISBN non può essere negativo");
        Objects.requireNonNull(authorName, "authorName non può essere null");
        if (authorName.equals("")) throw new IllegalArgumentException ("authorName non può essere una stringa vuota");
        Objects.requireNonNull(publisher, "publisher non può essere null");
        if (publisher.equals("")) throw new IllegalArgumentException ("publisher non può essere una stringa vuota");
        this.name = name;
        this.isbnNumber = isbnNumber;
        this.authorName = authorName;
        this.publisher = publisher;
    }



    // Metodi

    // EFFECTS : restituisce il nome del libro
    public String getNome(){
        return this.name;
    }
  
    // EFFECTS : restituisce il numero ISBN
    public int getIsbnNumber(){
        return this.isbnNumber;
    }
  
    // EFFECTS : restituisce il nome dell autore del libro
    public String getAuthorName(){
        return this.authorName;
    }
  
    // EFFECTS : restituisce il nome del pubblicatore
    public String getPublisher(){
        return this.publisher;
    }


    @Override
    public String toString(){
        return name + " " + isbnNumber + " " + authorName + " " + publisher;
    }

}