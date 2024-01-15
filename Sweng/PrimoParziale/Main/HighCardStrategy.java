package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class HighCardStrategy implements Strategy{
    @Override
    public @NotNull Card chooseCard(Player me, Player other) {
        Iterator<Card> it = me.getCards();
        Card best = it.next();
        while(it.hasNext()){
            Card c = it.next();
            if (c.getRank().ordinal() < best.getRank().ordinal())
                best = c;
        }
        return best;
    }
}
