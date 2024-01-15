package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Rank;
import it.unimi.di.sweng.tresette.common.Suit;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Player implements Iterable<Card>,Comparable<Player>{
  // TODO classe incompleta da completare

  // TODO rendere la classe Comparable con altri Player confrontando i punteggi per decretare vittoria

  // TODO rendere la classe Iterable sulle carte che ha preso (personalDeck)
  //      sfruttabile volendo in strategie che tengono conto delle carte già giocate

  private @NotNull final String name;
  private @NotNull final List<Card> cards = new ArrayList<>();
  private @NotNull final List<Card> personalDeck = new ArrayList<>();
  private Strategy attackStrategy;
  private Strategy answerStrategy;


  public Player(@NotNull String name) {
    this.name = name;
  }

  @NotNull
  private Card chooseCardWithStrategy(@NotNull Player opponent, @NotNull Strategy strategy) {
    Card c = strategy.chooseCard(this,opponent);
    cards.remove(c);
    return c;
  }

  public void setAttackStrategy(Strategy attacco) {
    this.attackStrategy = attacco;
  }
  public void setAnswerStrategy(Strategy answer) {
    this.answerStrategy = answer;
  }

  @NotNull
  public Card chooseAttackCard(@NotNull Player opponent) {
    return chooseCardWithStrategy(opponent, attackStrategy);
  }

  @NotNull
  public Card chooseAnswerCard(@NotNull Player opponent) {
    return chooseCardWithStrategy(opponent, answerStrategy);
  }

  public int getPoints() {
    int points = 0;
    for (Card c:personalDeck)
      points += c.getRank().points();
    return points/3;
  }

  @NotNull
  public String getName() {
    return name;
  }

  @Override
  @NotNull
  public String toString() {
    return getName() +
        " <" + getPoints() + ">" +
        " " + cards;
  }

  public void shoutResult() {
    System.out.printf("Sono %s e ho vinto con %d punti%n", getName(), getPoints());
  }

  public void addToPersonalDeck(Card card) {
    personalDeck.add(card);
  }

  @NotNull
  @Override
  public Iterator<Card> iterator() {
    return Collections.unmodifiableList(personalDeck).iterator();
  }

  @NotNull
  public Iterator<Card> getCards() {
    return Collections.unmodifiableList(cards).iterator();
  }

  @Override
  public int compareTo(@NotNull Player o) {
    return Integer.compare(this.getPoints(), o.getPoints());
  }

  public void giveCard(Card card) {
    cards.add(card);
  }
}
