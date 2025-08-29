package designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBreakSingleton {
  public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
    EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
    EagerInitializedSingleton instance2 = null;

      Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
      for (Constructor<?> constructor :  constructors){
          constructor.setAccessible(true);
          instance2 = (EagerInitializedSingleton) constructor.newInstance();
      }

    System.out.println(instance1.hashCode());
    System.out.println(instance2.hashCode());
  }
}
