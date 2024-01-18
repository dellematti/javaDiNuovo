package it.unimi.di.sweng.lab11.presenter;

import it.unimi.di.sweng.lab11.Main;
import it.unimi.di.sweng.lab11.Observable;
import it.unimi.di.sweng.lab11.Observer;
import it.unimi.di.sweng.lab11.model.Model;
import it.unimi.di.sweng.lab11.view.CommandView;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CommandPresenter implements Observer<Map<String, Integer>>, Presenter {

  private final @NotNull Model model;
  private final @NotNull CommandView view;

  public CommandPresenter(@NotNull Model model, @NotNull CommandView view) {
    this.model = model;
    this.view = view;

    model.addObserver(this);
  }

  @Override
  public void update(@NotNull Observable<Map<String, Integer>> subject) {
    Map<String, Integer> toBuy = subject.getState1();
    List<String> keys = new ArrayList<>(toBuy.keySet());
    Collections.sort(keys);
    for (int i = 0; i < Main.MAX_FOOD; i++) {
      if (i < keys.size())
        view.set(i, keys.get(i));
      else
        view.set(i, "---");
    }
  }

  @Override
  public void action(@NotNull String item, @NotNull String row) {
    try {
      model.buy(item);
    }
    catch (IllegalArgumentException ignored) {}
  }
}
