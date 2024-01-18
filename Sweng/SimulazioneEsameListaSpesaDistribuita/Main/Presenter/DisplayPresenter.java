package it.unimi.di.sweng.lab11.presenter;

import it.unimi.di.sweng.lab11.Main;
import it.unimi.di.sweng.lab11.Observable;
import it.unimi.di.sweng.lab11.Observer;
import it.unimi.di.sweng.lab11.model.Model;
import it.unimi.di.sweng.lab11.presenter.strategy.GetStateStrategy;
import it.unimi.di.sweng.lab11.view.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DisplayPresenter implements Observer<Map<String, Integer>> {

  private final @NotNull DisplayView view;
  private final @NotNull GetStateStrategy strategy;

  public DisplayPresenter(@NotNull Model model, @NotNull DisplayView view, @NotNull GetStateStrategy strategy) {
    this.view = view;
    this.strategy = strategy;

    model.addObserver(this);
  }

  @Override
  public void update(@NotNull Observable<Map<String, Integer>> subject) {
    Map<String, Integer> items = strategy.getState(subject);
    List<String> keys = new ArrayList<>(items.keySet());
    Collections.sort(keys);
    for (int i = 0; i < Main.MAX_FOOD; i++) {
      if (i < keys.size())
        view.set(i, keys.get(i) + " " + items.get(keys.get(i)));
      else
        view.set(i, "---");
    }
  }
}
