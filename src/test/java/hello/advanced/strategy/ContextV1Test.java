package hello.advanced.strategy;


import hello.advanced.strategy.code.strategy.ContextV1;
import hello.advanced.strategy.code.strategy.Strategy;
import hello.advanced.strategy.code.strategy.StrategyLogic1;
import hello.advanced.strategy.code.strategy.StrategyLogic2;
import hello.advanced.template.code.AbstractTemplate;
import hello.advanced.template.code.SubclassLogic1;
import hello.advanced.template.code.SubclassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

  @Test
  void strategyV0() {
    logic1();
    logic2();
  }

  private void logic1() {
    //부가 기능
    long start = System.currentTimeMillis();

    //핵심 기능
    log.info("biz logic1 execute");

    long end = System.currentTimeMillis();
    log.info("execute time = {}", end - start);
  }
  private void logic2() {
    //부가 기능
    long start = System.currentTimeMillis();

    //핵심 기능
    log.info("biz logic2 execute");

    long end = System.currentTimeMillis();
    log.info("execute time = {}", end - start);
  }

  @Test
  void strategyV1() {
    StrategyLogic1 strategy1 = new StrategyLogic1();
    ContextV1 context1 = new ContextV1(strategy1);
    context1.execute();

    StrategyLogic2 strategy2 = new StrategyLogic2();
    ContextV1 context2 = new ContextV1(strategy2);
    context2.execute();
  }

  @Test
  void strategyV2() {
    ContextV1 context1 = new ContextV1(() -> {
      log.info("biz logic1 execute");
      return null;
    });
    context1.execute();
  }

}
