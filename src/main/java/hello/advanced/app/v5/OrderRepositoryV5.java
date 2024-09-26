package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

  private final TraceTemplate traceTemplate;

  public OrderRepositoryV5(LogTrace trace) {
    this.traceTemplate = new TraceTemplate(trace);
  }

  public void save(String itemId) {
    String message = "OrderRepository.save()";
    traceTemplate.execute(message, () -> {
      if (itemId.equals("ex")) {
        throw new IllegalStateException("예외 발생");
      }
      sleep(1000);
      return null;
    });
  }

  private void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
