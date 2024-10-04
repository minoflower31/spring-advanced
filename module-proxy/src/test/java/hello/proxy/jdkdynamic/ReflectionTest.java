package hello.proxy.jdkdynamic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReflectionTest {

  @Test
  void reflection0() {
    Hello target = new Hello();

    //공통로직1 시작
    log.info("start");
    String result1 = target.callA(); // 호출 메서드만 다름
    log.info("result1: {}", result1);

    //공통로직2 종료
    log.info("start");
    String result2 = target.callB();
    log.info("result2: {}", result2);
  }

  @Test
  void reflection1()
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    // 클래스 정보
    Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

    Hello target = new Hello();
    Method methodCallA = classHello.getMethod("callA");
    Object result1 = methodCallA.invoke(target);
    log.info("result1: {}", result1);

    Method methodCallB = classHello.getMethod("callB");
    Object result2 = methodCallB.invoke(target);
    log.info("result2: {}", result2);
  }

  @Test
  void reflection2()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
    // 클래스 정보
    Class<?> classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

    Hello target = new Hello();
    dynamicCall(classHello.getMethod("callA"), target);
    dynamicCall(classHello.getMethod("callB"), target);
  }

  private void dynamicCall(Method method, Object target)
      throws InvocationTargetException, IllegalAccessException {
    log.info("start");
    Object result = method.invoke(target);
    log.info("result: {}", result);
  }

  @Slf4j
  static class Hello {

    public String callA() {
      log.info("callA");
      return "A";
    }

    public String callB() {
      log.info("callB");
      return "B";
    }
  }
}
