package hello.template.strategy.code.strategy;

@FunctionalInterface
public interface Strategy<T> {

  T call();

}
