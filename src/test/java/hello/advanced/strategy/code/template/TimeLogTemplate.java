package hello.advanced.strategy.code.template;

import hello.advanced.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

  public void execute(Callback callback) {
    //부가 기능
    long start = System.currentTimeMillis();

    //핵심 기능
    callback.call();

    long end = System.currentTimeMillis();
    log.info("execute time = {}", end - start);
  }
}
