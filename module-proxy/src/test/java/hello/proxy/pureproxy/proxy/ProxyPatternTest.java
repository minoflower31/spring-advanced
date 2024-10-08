package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import hello.proxy.pureproxy.proxy.code.Subject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

  @Test
  void noProxyTest() {
    Subject realSubject = new RealSubject();
    ProxyPatternClient proxyPatternClient = new ProxyPatternClient(realSubject);
    proxyPatternClient.execute();
    proxyPatternClient.execute();
    proxyPatternClient.execute();
  }

  @Test
  void proxyTest() {
    Subject realSubject = new RealSubject();
    Subject cacheProxy = new CacheProxy(realSubject);
    ProxyPatternClient proxyPatternClient = new ProxyPatternClient(cacheProxy);
    proxyPatternClient.execute();
    proxyPatternClient.execute();
    proxyPatternClient.execute();
  }
}
