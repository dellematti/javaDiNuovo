package it.unimi.di.sweng.lab11;

import it.unimi.di.sweng.lab11.model.Model;
import it.unimi.di.sweng.lab11.presenter.InputPresenter;
import it.unimi.di.sweng.lab11.view.InputAlimentView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class InputPresenterTest {

  @Test
  void actionTest() {
    Model model = mock(Model.class);
    InputAlimentView view = mock(InputAlimentView.class);

    InputPresenter SUT = new InputPresenter(model, view);

    SUT.action("patolle", "2");

    verify(model, times(1)).addToBuy("patolle", 2);
  }

  @Test
  void actionFailTest() {
    Model model = new Model();
    InputAlimentView view = mock(InputAlimentView.class);

    InputPresenter SUT = new InputPresenter(model, view);

    SUT.action("patolle", "-2");

    verify(view, times(1)).showError("Quantity cannot be negative");
    clearInvocations(view);

    SUT.action("pere", "10");
    SUT.action("mele", "1");
    SUT.action("banane", "4");
    SUT.action("meloni", "4");
    SUT.action("zucchine", "4");
    SUT.action("pasta", "4");
    SUT.action("pizza", "1");
    SUT.action("grissini", "3");

    SUT.action("patolle", "2");
    verify(view, times(1)).showError("Items limit reached");
    clearInvocations(view);

    SUT.action("pizza", "1");
    verify(view, times(0)).showError("Items limit reached");
  }

}
