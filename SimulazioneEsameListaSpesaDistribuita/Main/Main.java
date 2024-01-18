package it.unimi.di.sweng.lab11;

import it.unimi.di.sweng.lab11.model.Model;
import it.unimi.di.sweng.lab11.presenter.CommandPresenter;
import it.unimi.di.sweng.lab11.presenter.DisplayPresenter;
import it.unimi.di.sweng.lab11.presenter.InputPresenter;
import it.unimi.di.sweng.lab11.presenter.strategy.GetBoughtStrategy;
import it.unimi.di.sweng.lab11.presenter.strategy.GetToBuyStrategy;
import it.unimi.di.sweng.lab11.view.CommandView;
import it.unimi.di.sweng.lab11.view.DisplayView;
import it.unimi.di.sweng.lab11.view.InputAlimentView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

  public static final int MAX_FOOD = 8;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    primaryStage.setTitle("Grocery List");

    CommandView[] command = new CommandView[2];

    InputAlimentView input = new InputAlimentView();
    DisplayView display = new DisplayView(MAX_FOOD, "Cose da comprare");
    DisplayView display2 = new DisplayView(MAX_FOOD, "Cose comprate");

    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.setPadding(new Insets(10, 10, 10, 10));

    gridPane.add(input, 0, 0);
    GridPane.setColumnSpan(input, GridPane.REMAINING);
    for (int i = 0; i < 2; i++) {
      command[i] = new CommandView("Buy", MAX_FOOD, "Compratore#" + i);
      gridPane.add(command[i], i, 1);
    }

    gridPane.add(display, 3, 1);
    gridPane.add(display2, 4, 1);

    Model model = new Model();
    InputPresenter inputPresenter = new InputPresenter(model, input);
    CommandPresenter commandPresenter1 = new CommandPresenter(model, command[0]);
    CommandPresenter commandPresenter2 = new CommandPresenter(model, command[1]);
    new DisplayPresenter(model, display, GetToBuyStrategy.TO_BUY_STRATEGY);
    new DisplayPresenter(model, display2, GetBoughtStrategy.BOUGHT_STRATEGY);

    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();

    input.addHandlers(inputPresenter);
    command[0].addHandlers(commandPresenter1);
    command[1].addHandlers(commandPresenter2);

    model.notifyObservers();
  }
}
