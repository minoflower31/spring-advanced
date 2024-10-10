package hello.moduleaop;

import hello.moduleaop.order.OrderRepository;
import hello.moduleaop.order.OrderService;
import hello.moduleaop.order.aop.AspectV5Order;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
@Import({AspectV5Order.LogAspect.class, AspectV5Order.TransactionAspect.class})
public class AopTest {

  @Autowired
  OrderService orderService;

  @Autowired
  OrderRepository orderRepository;


  @Test
  void aopInfo() {
    log.info("isAopProxy, service={}", AopUtils.isAopProxy(orderService));
    log.info("isAopProxy, repository={}", AopUtils.isAopProxy(orderRepository));
  }

  @Test
  void success() {
    orderService.orderItem("itemA");
  }

  @Test
  void exception() {
    Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
            .isInstanceOf(IllegalStateException.class);
  }
}
