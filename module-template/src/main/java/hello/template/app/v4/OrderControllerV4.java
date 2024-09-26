package hello.template.app.v4;

import hello.template.app.v4.OrderServiceV4;
import hello.template.trace.logtrace.LogTrace;
import hello.template.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

  private final OrderServiceV4 orderService;
  private final LogTrace logTrace;

  @GetMapping("/v4/request")
  public String request(String itemId) {
    AbstractTemplate<String> template = new AbstractTemplate<>(logTrace) {

      @Override
      protected String call() {
        orderService.orderItem(itemId);
        return "ok";
      }
    };

    return template.execute("OrderController.request");
  }
}
