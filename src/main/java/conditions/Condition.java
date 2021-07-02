package conditions;

public interface Condition<T> {
    boolean isSatisfiedBy(T candidate);
}
