package conditions;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class OrCondition<T> extends AbstractCondition<T> {
    private Set<Condition<T>> conditions = new HashSet<>();
    public <T> OrCondition(Condition<T>...spc ) {
        super();
        for (Condition s:spc) {
            conditions.add(s);
        }
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        Predicate<Condition<T>> conditionPredicate = s -> s.isSatisfiedBy(candidate);
        return conditions.stream().anyMatch(conditionPredicate);
    }
    @Override
    public AbstractCondition<T> or(Condition<T> s) {
        conditions.add(s);
        return this;
    }
}
