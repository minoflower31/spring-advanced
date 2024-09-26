package hello.template.template;

import hello.template.template.code.AbstractTemplate;
import hello.template.template.code.SubclassLogic1;
import hello.template.template.code.SubclassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

  @Test
  void templateMethodV0() {
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
  void templateMethodV1() {
    AbstractTemplate template1 = new SubclassLogic1();
    AbstractTemplate template2 = new SubclassLogic2();

    template1.execute();
    template2.execute();
  }

  @Test
  void templateMethodV2() {
    AbstractTemplate template1 = new SubclassLogic1() {
      @Override
      protected void call() {
        log.info("biz logic1 execute");
      }
    };

    log.info("클래스 이름1={}", template1.getClass()); // 이름: $1
    template1.execute();

    AbstractTemplate template2 = new SubclassLogic2() {
      @Override
      protected void call() {
        log.info("biz logic2 execute");
      }
    };

    log.info("클래스 이름2={}", template2.getClass());  // 이름: $2
    template2.execute();
  }
}
