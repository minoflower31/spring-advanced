package hello.template.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubclassLogic2 extends AbstractTemplate {

  @Override
  protected void call() {
    log.info("biz logic2 execute");
  }
}
