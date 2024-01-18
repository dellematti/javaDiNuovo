package it.unimi.di.sweng.lab11.model;

import it.unimi.di.sweng.lab11.Main;
import it.unimi.di.sweng.lab11.Observable;
import it.unimi.di.sweng.lab11.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Model implements Observable<Map<String, Integer>> {

  private final @NotNull Set<String> uniqueItems;
  private final @NotNull Map<String, Integer> toBuy;
  private final @NotNull Map<String, Integer> bought;
  private final @NotNull List<Observer<Map<String, Integer>>> subscribers;

  public Model() {
    uniqueItems = new HashSet<>();
    toBuy = new HashMap<>();
    bought = new HashMap<>();
    subscribers = new ArrayList<>();
  }

  @Override
  public void notifyObservers() {
    for(var s : subscribers)
      s.update(this);
  }

  @Override
  public void addObserver(@NotNull Observer<java.util.Map<String, Integer>> obs) {
    subscribers.add(obs);
  }

  @Override
  public @NotNull Map<String, Integer> getState1() {
    return getToBuy();
  }

  @Override
  public @NotNull Map<String, Integer> getState2() {
    return getBought();
  }

  public void addToBuy(@NotNull String item, int qty) {
    if (qty <= 0)
      throw new IllegalArgumentException("Quantity cannot be negative");
    if (uniqueItems.size() >= Main.MAX_FOOD && !uniqueItems.contains(item))
      throw new IllegalArgumentException("Items limit reached");
    uniqueItems.add(item);
    toBuy.put(item, toBuy.getOrDefault(item, 0) + qty);

    notifyObservers();
  }

  public void buy(@NotNull String item) {
    if (! toBuy.containsKey(item))
      throw new IllegalArgumentException("Cant buy items that doesnt exists");
    int newQty = toBuy.get(item)-1;
    if (newQty > 0)
      toBuy.put(item, newQty);
    else
      toBuy.remove(item);
    bought.put(item, bought.getOrDefault(item, 0) + 1);

    notifyObservers();
  }

  public @NotNull Map<String, Integer> getToBuy() {
    return new HashMap<>(toBuy);
  }

  public @NotNull Map<String, Integer> getBought() {
    return new HashMap<>(bought);
  }

}
