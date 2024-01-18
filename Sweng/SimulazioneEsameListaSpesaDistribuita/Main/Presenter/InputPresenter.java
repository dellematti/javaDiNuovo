package it.unimi.di.sweng.lab11.presenter;

import it.unimi.di.sweng.lab11.model.Model;
import it.unimi.di.sweng.lab11.view.InputAlimentView;
import org.jetbrains.annotations.NotNull;

public class InputPresenter implements Presenter {

  private final @NotNull Model model;
  private final @NotNull InputAlimentView view;

  public InputPresenter(@NotNull Model model, @NotNull InputAlimentView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void action(@NotNull String item, @NotNull String qty) {
    try {
      model.addToBuy(item, Integer.parseInt(qty));
      view.showSuccess();
    }
    catch (IllegalArgumentException e) {
      view.showError(e.getMessage());
    }
  }
}
