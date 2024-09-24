package hello.advanced.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic2 implements Strategy<String> {

  @Override
  public String call() {
    log.info("비즈니스 로직2 실행");
    return null;
  }
}
