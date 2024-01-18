package it.unimi.di.sweng.lab11;

import org.jetbrains.annotations.NotNull;

public interface Observable<T> {
  void notifyObservers();

  void addObserver(@NotNull Observer<T> obs);

  @NotNull T getState1();

  @NotNull T getState2();
}
