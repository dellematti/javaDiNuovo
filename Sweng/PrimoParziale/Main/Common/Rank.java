package it.unimi.di.sweng.tresette.common;

public enum Rank {
  //TODO se volete potete aggiunge attributi e metodi
  TRE (1),
  DUE (1),
  ASSO(3),
  RE(1),
  CAVALLO(1),
  FANTE(1),
  SETTE(0),
  SEI(0),
  CINQUE(0),
  QUATTRO(0);

  private final int points;

  Rank(int points) {
    this.points = points;
  }

  public int points() {
    return points;
  }
}
