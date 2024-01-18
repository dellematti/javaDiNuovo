package it.unimi.di.sweng.lab11.view;


import it.unimi.di.sweng.lab11.presenter.Presenter;
import org.jetbrains.annotations.NotNull;

public interface InputView {
    void addHandlers(@NotNull Presenter presenter);

    void showError(@NotNull String s);

    void showSuccess();
}
