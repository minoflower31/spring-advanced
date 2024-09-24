package hello.advanced.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

  public void execute(Strategy strategy) {
    //부가 기능
    long start = System.currentTimeMillis();

    //핵심 기능
    strategy.call();

    long end = System.currentTimeMillis();
    log.info("execute time = {}", end - start);
  }
}
