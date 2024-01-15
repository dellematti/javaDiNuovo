package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class sampleCardConversionTest {


  // in Card abbiamo messo il costruttore statico of(String) che
  // viene chiamato implicitamente dai test parametrici
  // vedi esempio qui sotto

  @ParameterizedTest
  @CsvSource({
      "CS,AB,3D",
      "RC,RS,7D"
  })
  public void check(Card a, Card b, Card c) {
    System.out.println(a + ", " + b + ", " + c);
  }
}
