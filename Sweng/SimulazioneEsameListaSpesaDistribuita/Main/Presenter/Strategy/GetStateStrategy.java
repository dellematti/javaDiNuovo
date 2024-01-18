package it.unimi.di.sweng.lab11.presenter.strategy;

import it.unimi.di.sweng.lab11.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface GetStateStrategy {

  @NotNull Map<String, Integer> getState(Observable<Map<String, Integer>> subject);
}
