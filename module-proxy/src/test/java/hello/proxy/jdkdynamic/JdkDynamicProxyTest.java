package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.AImpl;
import hello.proxy.jdkdynamic.code.AInterface;
import hello.proxy.jdkdynamic.code.BImpl;
import hello.proxy.jdkdynamic.code.BInterface;
import hello.proxy.jdkdynamic.code.TimeInvocationHandler;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JdkDynamicProxyTest {

  @Test
  void dynamicA() {
    AInterface target = new AImpl();
    TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);

    AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(),
        new Class[]{AInterface.class}, timeInvocationHandler);

    proxy.call();
    proxy.test();
    log.info("target.getClass() = {}", target.getClass());
    log.info("proxy.getClass() = {}", proxy.getClass());

  }

  @Test
  void dynamicB() {
    BInterface target = new BImpl();
    TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);

    BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(),
        new Class[]{BInterface.class}, timeInvocationHandler);

    proxy.call();
    log.info("target.getClass() = {}", target.getClass());
    log.info("proxy.getClass() = {}", proxy.getClass());

  }

}
