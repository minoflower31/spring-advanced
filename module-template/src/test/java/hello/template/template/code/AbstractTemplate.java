package hello.template.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

  public void execute() {
    //부가 기능
    long start = System.currentTimeMillis();

    //핵심 기능
    call();

    long end = System.currentTimeMillis();
    log.info("execute time = {}", end - start);
  }

  protected abstract void call();
}
