package hello.proxy.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderControllerV2  {

  private final OrderServiceV2 orderService;

  public OrderControllerV2(OrderServiceV2 orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/v2/request")
  public String request(String itemId) {
    log.info("request itemId={}", itemId);
    orderService.orderItem(itemId);
    return "ok";
  }

  @GetMapping("/v2/no-log")
  public String noLog() {
    return "noLog";
  }
}
