package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.jetbrains.annotations.NotNull;

public interface Strategy {
  // TODO implementare almeno 3 strategie usabili per scelta prima carta (attacco)
  //      e 3 strategie usabili per scelta seconda carta (risposta), strutturandole
  //      secondo il pattern CHAIN OF RESPONSIBILITY
  //      E' possibile che alcune strategie siano condivise (cioè indipendenti da turno):
  //      ad esempio una eventuale strategia che gioca una carta legale qualsiasi
  //      Possibile anche fare strategie "Ciapa nò" in cui i punti giocano in maniera negativa
  //      (strategia spesso usata senza dirlo anche dai genitori quando giocano con i figli piccoli)

  @NotNull
  Card chooseCard(Player me, Player other);
}
