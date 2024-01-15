package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Suit;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class moreEqualSuitsStrategyTest implements Strategy{

    private final Strategy next;

    public moreEqualSuitsStrategyTest(Strategy next) {
        this.next = next;
    }


    @Override
    public @NotNull Card chooseCard(Player me, Player other) {
        Map<Suit, Integer> suits = new HashMap<>();
        Iterator<Card> it = me.getCards();
        while(it.hasNext()){
            Card c = it.next();
            Suit suit = c.getSuit();
            if (suits.containsKey(suit))
                suits.put(suit,suits.get(suit)+1);
            else suits.put(suit,1);
        }
        Suit best = Suit.SPADE;
        int numeroMinimo = -1;
        for (Suit s : suits.keySet()){
            if (suits.get(s) > numeroMinimo) {
                numeroMinimo = suits.get(s);
                best = s;
            }
        }
        if (numeroMinimo < 2)
            return next.chooseCard(me,other);
        it = me.getCards();
        while (it.hasNext()) {
            Card c = it.next();
            if (c.getSuit() == best)
                return c;
        }
        return next.chooseCard(me,other);
    }
}
