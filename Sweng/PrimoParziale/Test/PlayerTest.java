package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Rank;
import it.unimi.di.sweng.tresette.common.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

    @Test
    void testIterator(){
        Player p = new Player("Player 1");
        p.addToPersonalDeck(Card.get(Rank.RE, Suit.COPPE));
        p.addToPersonalDeck(Card.get(Rank.TRE, Suit.SPADE));
        p.addToPersonalDeck(Card.get(Rank.FANTE, Suit.DENARI));
        p.addToPersonalDeck(Card.get(Rank.CAVALLO, Suit.BASTONI));
        List<Card> newList = new ArrayList<>();
        Iterator<Card> it = p.iterator();
        while(it.hasNext()){
            newList.add(it.next());
        }

        assertThat(newList).containsExactlyInAnyOrder(Card.get(Rank.CAVALLO, Suit.BASTONI), Card.get(Rank.RE, Suit.COPPE), Card.get(Rank.FANTE, Suit.DENARI), Card.get(Rank.TRE, Suit.SPADE));
    }

    @ParameterizedTest
    @CsvSource({
            "CS,AB,3D,1",
            "RC,RS,RD,1",
            "AB,AD,AS,3"
    })
    void getPointsTest(String carta1, String carta2, String carta3, int output){
        Player p = new Player("Player 1");
        p.addToPersonalDeck(Card.of(carta1));
        p.addToPersonalDeck(Card.of(carta2));
        p.addToPersonalDeck(Card.of(carta3));
        assertThat(p.getPoints()).isEqualTo(output);
    }


    @ParameterizedTest
    @CsvSource({
            "CS,AB,-1",
            "AC,RS,1",
            "AB,AS,0"
    })
    void comparePlayerTest(String carta1, String carta2, int risultato){
        Player p1 = new Player("Player 1");
        p1.addToPersonalDeck(Card.of(carta1));
        Player p2 = new Player("Player 2");
        p2.addToPersonalDeck(Card.of(carta2));
        assertThat(p1.compareTo(p2)).isEqualTo(risultato);
    }

    @Test
    void chooseCardWithStrategyTest(){

        Player SUT = new Player("Player");
        SUT.giveCard(Card.get(Rank.RE, Suit.SPADE));
        Player p2 = mock(Player.class);
        Strategy s = mock(Strategy.class);
        when(s.chooseCard(SUT, p2)).thenReturn(Card.get(Rank.RE, Suit.SPADE));
        SUT.setAttackStrategy(s);
        SUT.setAnswerStrategy(s);
        assertThat(SUT.chooseAnswerCard(p2)).isEqualTo(Card.get(Rank.RE, Suit.SPADE));
        SUT.giveCard(Card.get(Rank.RE, Suit.SPADE));
        assertThat(SUT.chooseAttackCard(p2)).isEqualTo(Card.get(Rank.RE, Suit.SPADE));

    }





}
