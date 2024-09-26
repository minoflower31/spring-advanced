package hello.proxy.pureproxy.proxy.code;

public class ProxyPatternClient {

  private Subject subject;

  public ProxyPatternClient(Subject target) {
    this.subject = target;
  }

  public void execute() {
    subject.operation();
  }
}
