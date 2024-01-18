package it.unimi.di.sweng.lab11.presenter.strategy;

import it.unimi.di.sweng.lab11.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public enum GetBoughtStrategy implements GetStateStrategy {
  BOUGHT_STRATEGY;

  @Override
  public @NotNull Map<String, Integer> getState(Observable<Map<String, Integer>> subject) {
    return subject.getState2();
  }
}
