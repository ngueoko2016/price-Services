package conditions;

public class NotCondition<T> extends AbstractCondition<T> {
    private Condition<T> condition;

    public NotCondition(Condition<T> s) {
        this.condition =s;
    }
    @Override
    public boolean isSatisfiedBy(T t) {
        return !condition.isSatisfiedBy(t);
    }
}
