package conditions;

import java.util.HashSet;
import java.util.Set;

public class AndCondition<T> extends AbstractCondition<T> {
    private Set<Condition<T>> conditions = new HashSet<Condition<T>>();

    public <T> AndCondition(Condition<T>...spc ) {
        super();
        for (Condition s:spc) {
            conditions.add(s);
        }
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        for (Condition<T> s: conditions){
            if(!s.isSatisfiedBy(candidate))
                return false;
        }
        return true;
    }

    @Override
    public AbstractCondition<T> and(Condition<T> s) {
        conditions.add(s);
        return this;
    }
}
