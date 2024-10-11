package hello.moduleaop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class AspectV6Advice {

//  @Around("hello.moduleaop.order.aop.PointCuts.orderAndService())")
  public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
      //@Before
      log.info("[transaction start] {}", joinPoint.getSignature());
      Object result = joinPoint.proceed();

      //@AfterReturning
      log.info("[transaction commit] {}", joinPoint.getSignature());

      return result;
    } catch (Exception e) {
      //@AfterThrowing
      log.info("[transaction rollback] {}", joinPoint.getSignature());
      throw e;
    } finally {
      //@After
      log.info("[resource release ] {}", joinPoint.getSignature());
    }
  }

  @Before("hello.moduleaop.order.aop.PointCuts.orderAndService()")
  public void doBefore(JoinPoint joinPoint) {
    log.info("[before] {}", joinPoint.getSignature());
  }

  @AfterReturning(value = "hello.moduleaop.order.aop.PointCuts.orderAndService()", returning = "result")
  public void doReturn(JoinPoint joinPoint, Object result) {
    log.info("[ return] {} return={}", joinPoint.getSignature(), result);
  }

  @AfterReturning(value = "hello.moduleaop.order.aop.PointCuts.allOrder()", returning = "result")
  public void doReturn(JoinPoint joinPoint, String result) {
    log.info("[ return2] {} return={}", joinPoint.getSignature(), result);
  }

  @AfterThrowing(value = "hello.moduleaop.order.aop.PointCuts.orderAndService()", throwing = "ex")
  public void doThrowing(JoinPoint joinPoint, Exception ex) {
    log.info("[ex] {} message={}", joinPoint.getSignature(), ex.getMessage());
  }

  @After(value = "hello.moduleaop.order.aop.PointCuts.orderAndService()")
  public void doAfter(JoinPoint joinPoint) {
    log.info("[after] {}", joinPoint.getSignature());
  }
}
