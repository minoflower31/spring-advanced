package hello.template.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {

  private final Strategy<String> strategy;

  public ContextV1(Strategy<String> strategy) {
    this.strategy = strategy;
  }

  public void execute() {
    //부가 기능
    long start = System.currentTimeMillis();

    //핵심 기능
    strategy.call();

    long end = System.currentTimeMillis();
    log.info("execute time = {}", end - start);
  }
}
