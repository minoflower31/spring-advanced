package hello.advanced.threadlocal;

import hello.advanced.threadlocal.code.FieldService;
import hello.advanced.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

  private final ThreadLocalService threadLocalService = new ThreadLocalService();

  @Test
  void field() {
    log.info("main Start");
    Runnable userA = () -> {
      threadLocalService.logic("userA");
    };

    Runnable userB = () -> {
      threadLocalService.logic("userB");
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
