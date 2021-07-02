package conditions;

import java.util.HashSet;
import java.util.Set;

public class OrCondition<T> extends AbstractCondition<T> {
    private Set<Condition<T>> conditions =new HashSet<Condition<T>>();
    public <T> OrCondition(Condition<T>...spc ) {
        super();
        for (Condition s:spc) {
            conditions.add(s);
        }
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        for (Condition<T> s: conditions){
             if(s.isSatisfiedBy(candidate))
                 return true;
        }
        return false;
    }
    @Override
    public AbstractCondition<T> or(Condition<T> s) {
        conditions.add(s);
        return this;
    }
}
