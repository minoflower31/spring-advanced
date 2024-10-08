package hello.template.trace.callback;

import hello.template.trace.TraceStatus;
import hello.template.trace.callback.TraceCallback;
import hello.template.trace.logtrace.LogTrace;

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
