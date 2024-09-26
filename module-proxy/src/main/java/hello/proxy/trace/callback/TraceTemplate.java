package hello.proxy.trace.callback;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class TraceTemplate {

  private final LogTrace trace;

  public TraceTemplate(LogTrace trace) {
    this.trace = trace;
  }

  public <T> T execute(String message, TraceCallback<T> callback) {
    TraceStatus status = null;
    try {
      status = trace.begin(message);
      T t = callback.call();

      trace.end(status);
      return t;
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
