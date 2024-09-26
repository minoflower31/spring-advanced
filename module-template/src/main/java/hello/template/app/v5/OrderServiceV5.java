package hello.template.app.v5;

import hello.template.app.v5.OrderRepositoryV5;
import hello.template.trace.callback.TraceTemplate;
import hello.template.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

  private final OrderRepositoryV5 orderRepository;
  private final TraceTemplate traceTemplate;

  public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
    this.orderRepository = orderRepository;
    this.traceTemplate = new TraceTemplate(trace);
  }

  public void orderItem(String itemId) {
    String message = "OrderService.orderItem()";
    traceTemplate.execute(message, () -> {
      orderRepository.save(itemId);
      return null;
    });
  }
}
