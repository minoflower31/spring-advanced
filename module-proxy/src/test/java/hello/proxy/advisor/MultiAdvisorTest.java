package hello.proxy.advisor;

import hello.proxy.common.service.ServiceImpl;
import hello.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class MultiAdvisorTest {

  @Test
  @DisplayName("Multiple proxy")
  void multiAdvisorTest1() {
    // client -> proxy2 -> proxy1 -> target

    ServiceInterface target = new ServiceImpl();
    ProxyFactory proxyFactory1 = new ProxyFactory(target);
    DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
    proxyFactory1.addAdvisor(advisor1);
    ServiceInterface proxy1 = (ServiceInterface) proxyFactory1.getProxy();

    ProxyFactory proxyFactory2 = new ProxyFactory(proxy1);
    DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
    proxyFactory2.addAdvisor(advisor2);
    ServiceInterface proxy2 = (ServiceInterface) proxyFactory2.getProxy();

    proxy2.save();
  }

  @Test
  @DisplayName("Once Proxy, Multiple Advisor")
  void multiAdvisorTest2() {
    // client -> proxy -> advisor2 -> advisor1 -> target

    DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
    DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());

    ServiceInterface target = new ServiceImpl();
    ProxyFactory proxyFactory= new ProxyFactory(target);

    proxyFactory.addAdvisors(advisor2, advisor1);
//    proxyFactory.addAdvisor(advisor1);
    ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

    proxy.save();
  }

  @Slf4j
  static class Advice1 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
      log.info("call Advice1.invoke()");
      return invocation.proceed();
    }
  }

  @Slf4j
  static class Advice2 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
      log.info("call Advice2.invoke()");
      return invocation.proceed();
    }
  }

}
