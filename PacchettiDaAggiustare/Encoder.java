import java.util.*;
// import java.lang.Object;
import java.nio.charset.*;
import java.util.zip.*;

public class Encoder {

    // OVERVIEW: classe con solo metodi statici di utilità ( che non può essere istanziata) che serve per codificare un messaggio
  
    private Encoder() {}

    // EFFECTS 
    public static Byte[] codifica (final String messaggio, Charset charset ){
        Objects.requireNonNull(messaggio, "messaggio non può essere null");
        Objects.requireNonNull(charset, "charset non può essere null");
        if ( messaggio.equals("")) throw new IllegalArgumentException ("stringa vuota");

        ByteBuffer buf = charset.encode(messaggio);
        byte[] arr = new byte[buf.remaining()];
        buf.get(arr);
        return arr;
        // return charset.encode(messaggio);
    }


}