package hello.template.strategy;

import hello.template.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

  @Test
  void callback() {
    TimeLogTemplate template = new TimeLogTemplate();
    template.execute(() -> log.info("비즈니스 로직1 실행"));
    template.execute(() -> log.info("비즈니스 로직2 실행"));
  }
}
