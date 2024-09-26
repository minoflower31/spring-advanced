package hello.proxy.trace.template;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

  private final LogTrace trace;

  public AbstractTemplate(LogTrace trace) {
    this.trace = trace;
  }

  public T execute(String message) {
    TraceStatus status = null;
    try {
      status = trace.begin(message);
      T t = call();

      trace.end(status);
      return t;
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }

  protected abstract T call();
}
