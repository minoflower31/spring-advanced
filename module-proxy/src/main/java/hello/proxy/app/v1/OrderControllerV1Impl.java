package hello.proxy.app.v1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderControllerV1Impl implements OrderControllerV1 {

  private final OrderServiceV1 orderService;

  public OrderControllerV1Impl(OrderServiceV1 orderService) {
    this.orderService = orderService;
  }

  @Override
  public String request(String itemId) {
    log.info("OrderService class={}", orderService.getClass());

    log.info("request itemId={}", itemId);
    orderService.orderItem(itemId);
    return "ok";
  }

  @Override
  public String noLog() {
    return "noLog";
  }
}
