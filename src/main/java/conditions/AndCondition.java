package conditions;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class AndCondition<T> extends AbstractCondition<T> {
    private Set<Condition<T>> conditions = new HashSet<>();

    public <T> AndCondition(Condition<T>...spc ) {
        super();
        for(Condition s:spc) {
            conditions.add(s);
        }
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        Predicate<Condition<T>> conditionPredicate = s -> s.isSatisfiedBy(candidate);
        return conditions.stream().allMatch(conditionPredicate);
    }

    @Override
    public AbstractCondition<T> and(Condition<T> s) {
        conditions.add(s);
        return this;
    }
}
