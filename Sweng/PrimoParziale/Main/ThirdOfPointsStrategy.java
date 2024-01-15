package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class ThirdOfPointsStrategy implements Strategy{


    private Strategy next;

    public ThirdOfPointsStrategy(Strategy next){
        this.next = next;
    }


    @Override
    public @NotNull Card chooseCard(Player me, Player other) {
        Iterator<Card> it = me.getCards();

        while(it.hasNext()){
            Card c = it.next();
            if (c.getRank().points() >= 1)
                return c;
        }
        return next.chooseCard(me,other);
    }
}
