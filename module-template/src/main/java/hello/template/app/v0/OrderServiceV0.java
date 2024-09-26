package hello.template.app.v0;

import hello.template.app.v0.OrderRepositoryV0;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

  private final OrderRepositoryV0 orderRepository;

  public void orderItem(String itemId) {
    orderRepository.save(itemId);
  }

}
