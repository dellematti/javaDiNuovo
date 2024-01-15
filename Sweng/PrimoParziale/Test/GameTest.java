package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Deck;
import it.unimi.di.sweng.tresette.common.Rank;
import it.unimi.di.sweng.tresette.common.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {

    @Test
    void playTurn(){
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        Deck d = mock(Deck.class);
        when(p1.getName()).thenReturn("Player 1");
        when(p2.getName()).thenReturn("Player 2");
        when(p1.chooseAttackCard(p2)).thenReturn(Card.get(Rank.CAVALLO, Suit.SPADE));
        when(p2.chooseAnswerCard(p1)).thenReturn(Card.get(Rank.ASSO, Suit.SPADE));
        Game SUT = new Game(p1,p2,d);
        SUT.playTurn();
        assertThat(SUT.getAttackPlayer().getName()).isEqualTo("Player 2");
    }

}
