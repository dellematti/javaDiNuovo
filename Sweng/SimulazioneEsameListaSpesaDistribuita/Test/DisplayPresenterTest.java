package it.unimi.di.sweng.lab11;

import it.unimi.di.sweng.lab11.model.Model;
import it.unimi.di.sweng.lab11.presenter.DisplayPresenter;
import it.unimi.di.sweng.lab11.presenter.strategy.GetBoughtStrategy;
import it.unimi.di.sweng.lab11.presenter.strategy.GetToBuyStrategy;
import it.unimi.di.sweng.lab11.view.DisplayView;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class DisplayPresenterTest {

  @Test
  void updateToBuyTest() {
    Model model = mock(Model.class);
    DisplayView view = mock(DisplayView.class);

    DisplayPresenter SUT = new DisplayPresenter(view, GetToBuyStrategy.TO_BUY_STRATEGY);

    SUT.update(model);

    verify(model, times(1)).getState1();
    for (int row = 0; row < Main.MAX_FOOD; row++)
      verify(view, times(1)).set(eq(row), anyString());
  }

  @Test
  void updateBoughtTest() {
    Model model = mock(Model.class);
    DisplayView view = mock(DisplayView.class);

    DisplayPresenter SUT = new DisplayPresenter(view, GetBoughtStrategy.BOUGHT_STRATEGY);

    SUT.update(model);

    verify(model, times(1)).getState2();
    for (int row = 0; row < Main.MAX_FOOD; row++)
      verify(view, times(1)).set(eq(row), anyString());
  }

}
