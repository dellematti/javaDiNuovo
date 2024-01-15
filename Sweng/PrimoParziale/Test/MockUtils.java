package it.unimi.di.sweng.tresette;

import static org.mockito.Mockito.doAnswer;

import java.util.List;

public class MockUtils {
  @SafeVarargs
  public static <T> void whenIterated(Iterable<T> p, T... d) {
    doAnswer(a -> List.of(d).iterator()).when(p).iterator();
  }
}