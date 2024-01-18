package it.unimi.di.sweng.lab11;

import it.unimi.di.sweng.lab11.model.Model;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class ModelTest {

  @Test
  void modelIsObservable() {
    Model SUT = new Model();

    Observer<Map<String, Integer>> obs1 = mock(Observer.class);
    Observer<Map<String, Integer>> obs2 = mock(Observer.class);

    SUT.notifyObservers();

    verify(obs1, times(0)).update(any());
    verify(obs2, times(0)).update(any());

    SUT.addObserver(obs1);
    SUT.addObserver(obs2);

    SUT.notifyObservers();

    verify(obs1, times(1)).update(any());
    verify(obs2, times(1)).update(any());
  }

  @Test
  void toBuySuccessTest() {
    Model SUT = new Model();

    SUT.addToBuy("pere", 10);
    SUT.addToBuy("mele", 4);

    assertThat(SUT.getToBuy()).containsKey("pere");
    assertThat(SUT.getToBuy().get("pere")).isEqualTo(10);
    assertThat(SUT.getToBuy()).containsKey("mele");
    assertThat(SUT.getToBuy().get("mele")).isEqualTo(4);
    assertThat(SUT.getToBuy()).doesNotContainKey("giovanni");

    SUT.addToBuy("mele", 2);

    assertThat(SUT.getToBuy()).containsKey("mele");
    assertThat(SUT.getToBuy().get("mele")).isEqualTo(6);
  }

  @Test
  void boughtSuccessTest() {
    Model SUT = new Model();

    SUT.addToBuy("pere", 1);
    SUT.addToBuy("mele", 4);

    SUT.buy("pere");
    SUT.buy("mele");
    SUT.buy("mele");

    assertThat(SUT.getToBuy()).doesNotContainKey("pere");
    assertThat(SUT.getToBuy().get("mele")).isEqualTo(2);

    assertThat(SUT.getBought().get("mele")).isEqualTo(2);
    assertThat(SUT.getBought().get("pere")).isEqualTo(1);
  }

  @Test
  void toBuyFailTest() {
    Model SUT = new Model();

    assertThatThrownBy(() -> SUT.addToBuy("pere", -7))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Quantity cannot be negative");

    assertThatThrownBy(() -> SUT.addToBuy("mele", 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Quantity cannot be negative");

    SUT.addToBuy("pere", 10);
    SUT.addToBuy("mele", 1);
    SUT.addToBuy("banane", 4);

    SUT.buy("mele");

    SUT.addToBuy("meloni", 4);
    SUT.addToBuy("zucchine", 4);
    SUT.addToBuy("pasta", 4);
    SUT.addToBuy("pizza", 1);
    SUT.addToBuy("grissini", 3);

    assertThatThrownBy(() -> SUT.addToBuy("patolle", 2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Items limit reached");

    SUT.addToBuy("pizza", 1);
  }

  @Test
  void boughtFailTest() {
    Model SUT = new Model();

    SUT.addToBuy("patolle", 2);

    assertThatThrownBy(() -> SUT.buy("focaccia"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Cant buy items that doesnt exists");

    SUT.buy("patolle");
  }

  @Test
  void checkNotifications() {
    Model SUT = spy(Model.class);

    SUT.addToBuy("patolle", 2);
    verify(SUT, times(1)).notifyObservers();

    SUT.buy("patolle");
    verify(SUT, times(2)).notifyObservers();

    SUT.buy("patolle");
    verify(SUT, times(3)).notifyObservers();
  }

}
