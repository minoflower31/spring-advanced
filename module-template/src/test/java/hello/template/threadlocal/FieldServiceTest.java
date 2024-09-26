package hello.template.threadlocal;

import hello.template.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

  private final FieldService fieldService = new FieldService();

  @Test
  void field() {
    log.info("main Start");
    Runnable userA = () -> {
      fieldService.logic("userA");
    };

    Runnable userB = () -> {
      fieldService.logic("userB");
    };

    Thread threadA = new Thread(userA);
    threadA.setName("thread-A");
    Thread threadB = new Thread(userB);
    threadB.setName("thread-B");

    threadA.start();
    sleep(100);
    threadB.start();

    sleep(2000);
    log.info("main End");
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
