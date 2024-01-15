package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Rank;
import it.unimi.di.sweng.tresette.common.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


public class StrategyTest {

    @Test
    void highCardStrategyTest(){
        Player p = mock(Player.class);
        Player other = mock(Player.class);
        when(p.getCards()).thenAnswer(a-> List.of(Card.get(Rank.RE, Suit.SPADE), Card.get(Rank.ASSO, Suit.DENARI), Card.get(Rank.CINQUE, Suit.SPADE)).iterator());
        HighCardStrategy s = new HighCardStrategy();
        Card c = s.chooseCard(p,other);
        assertThat(c).isEqualTo(Card.get(Rank.ASSO, Suit.DENARI));
    }

    @Test
    void thirdOfPointsStrategy(){
        Player p = mock(Player.class);
        Player other = mock(Player.class);
        when(p.getCards()).thenAnswer(a-> List.of(Card.get(Rank.RE, Suit.SPADE), Card.get(Rank.ASSO, Suit.DENARI), Card.get(Rank.CINQUE, Suit.SPADE)).iterator());
        ThirdOfPointsStrategy s = new ThirdOfPointsStrategy(new HighCardStrategy());
        Card c = s.chooseCard(p,other);
        assertThat(c).isEqualTo(Card.get(Rank.RE, Suit.SPADE));
    }

    @Test
    void thirdOfPointsStrategyNext(){
        Player p = mock(Player.class);
        Player other = mock(Player.class);
        when(p.getCards()).thenAnswer(a-> List.of(Card.get(Rank.CINQUE, Suit.SPADE), Card.get(Rank.SEI, Suit.DENARI), Card.get(Rank.SETTE, Suit.SPADE)).iterator());
        ThirdOfPointsStrategy s = new ThirdOfPointsStrategy(new HighCardStrategy());
        Card c = s.chooseCard(p,other);
        assertThat(c).isEqualTo(Card.get(Rank.SETTE, Suit.SPADE));
    }

    @Test
    void lowerCardStrategyTest(){
        Player p = mock(Player.class);
        Player other = mock(Player.class);
        when(p.getCards()).thenAnswer(a-> List.of(Card.get(Rank.RE, Suit.SPADE), Card.get(Rank.ASSO, Suit.DENARI), Card.get(Rank.CINQUE, Suit.SPADE)).iterator());
        LowerCardStrategyTest s = new LowerCardStrategyTest();
        Card c = s.chooseCard(p,other);
        assertThat(c).isEqualTo(Card.get(Rank.CINQUE, Suit.SPADE));
    }

    @Test
    void moreEqualSuitsStrategyTest(){
        Player p = mock(Player.class);
        Player other = mock(Player.class);
        when(p.getCards()).thenAnswer(a-> List.of(Card.get(Rank.RE, Suit.SPADE), Card.get(Rank.ASSO, Suit.DENARI), Card.get(Rank.CINQUE, Suit.SPADE)).iterator());
        moreEqualSuitsStrategyTest s = new moreEqualSuitsStrategyTest(new LowerCardStrategyTest());
        Card c = s.chooseCard(p,other);
        assertThat(c).isEqualTo(Card.get(Rank.RE, Suit.SPADE));
    }


}
