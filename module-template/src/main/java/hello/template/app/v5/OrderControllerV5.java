package hello.template.app.v5;

import hello.template.trace.callback.TraceTemplate;
import hello.template.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

  private final OrderServiceV5 orderService;
  private final TraceTemplate traceTemplate;

  public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
    this.orderService = orderService;
    this.traceTemplate = new TraceTemplate(trace);
  }

  @GetMapping("/v5/request")
  public String request(String itemId) {
    String message = "OrderController.request()";
    return traceTemplate.execute(message, () -> {
      orderService.orderItem(itemId);
      return "ok";
    });
  }
}
