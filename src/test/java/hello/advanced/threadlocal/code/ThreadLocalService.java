package hello.advanced.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

  private final ThreadLocal<String> nameStore = new ThreadLocal<>();

  public String logic(String name) {
    log.info("저장할 name={} -> nameStore 확인={}", name, nameStore.get());
    nameStore.set(name);
    sleep(1000);
    log.info("nameStore 조회={}", nameStore.get());
    return nameStore.get();
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
