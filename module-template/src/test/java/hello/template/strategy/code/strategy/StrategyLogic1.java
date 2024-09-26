package hello.template.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic1 implements Strategy<String> {

  @Override
  public String call() {
    log.info("비즈니스 로직1 실행");
    return null;
  }
}
