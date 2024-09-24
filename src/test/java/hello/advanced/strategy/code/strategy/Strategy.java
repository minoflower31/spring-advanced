package hello.advanced.strategy.code.strategy;

@FunctionalInterface
public interface Strategy<T> {

  T call();

}
