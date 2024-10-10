package hello.moduleaop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

  @Pointcut("execution(* hello.moduleaop.order..*(..))")
  public void allOrder() {} // pointcut signature

  @Pointcut("execution(* *..*Service.*(..))")
  public void allService() {}

  @Pointcut("allOrder() && allService()")
  public void orderAndService() {}
}
