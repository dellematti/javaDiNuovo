package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Deck;
import org.jetbrains.annotations.NotNull;

public class Game {
  //TODO classe incompleta da completare

  private final Deck deck;
  private final Player[] players = new Player[2];

  @NotNull private Player attackPlayer;

  public Game(@NotNull Player p1, @NotNull Player p2, @NotNull Deck d) {
    deck = d;
    players[0] = p1;
    players[1] = p2;
    attackPlayer = p1;
  }

  @NotNull
  public Player opponentOf(@NotNull Player player) {
    if (players[0] == player)
      return players[1];
    return players[0];
  }

  public void playTurn() {
    Card attackCard = attackPlayer.chooseAttackCard(opponentOf(attackPlayer));
    Card answerCard = opponentOf(attackPlayer).chooseAnswerCard(attackPlayer);
    //TODO gioca le due carte, stabilisce il vincitore, aggiorna situazione (Se preferite potete cambiare valore di ritorno)
    if (!sameSuit(attackCard, answerCard))
      attackPlayer = players[0];
    else if (attackCard.getRank().ordinal() < answerCard.getRank().ordinal())
      attackPlayer = players[0];
    else
      attackPlayer = players[1];
  }

  private static boolean sameSuit(Card attackCard, Card answerCard) {
    return attackCard.getSuit() == answerCard.getSuit();
  }

  public @NotNull String playGame() {
    //TODO gestisce l'intera partita e ritorna una stringa in cui viene detto chi ha vinto e con che punteggio
    return null;
  }

  public Player getAttackPlayer() {
    return attackPlayer;
  }
}
