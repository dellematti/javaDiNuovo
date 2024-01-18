package it.unimi.di.sweng.lab11;

import it.unimi.di.sweng.lab11.model.Model;
import it.unimi.di.sweng.lab11.presenter.CommandPresenter;
import it.unimi.di.sweng.lab11.view.CommandView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CommandPresenterTest {

  @Test
  void actionTest() {
    Model model = mock(Model.class);
    CommandView view = mock(CommandView.class);

    CommandPresenter SUT = new CommandPresenter(model, view);

    SUT.action("patolle", "2");
    SUT.action("mele", "1");
    SUT.action("patolle", "2");

    verify(model, times(2)).buy("patolle");
    verify(model, times(0)).buy("pere");
    verify(model, times(1)).buy("mele");
  }

  @Test
  void updateTest() {
    Model model = mock(Model.class);
    CommandView view = mock(CommandView.class);

    CommandPresenter SUT = new CommandPresenter(model, view);

    SUT.update(model);

    verify(model, times(1)).getState1();
    for (int row = 0; row < Main.MAX_FOOD; row++)
      verify(view, times(1)).set(eq(row), anyString());
  }

}
