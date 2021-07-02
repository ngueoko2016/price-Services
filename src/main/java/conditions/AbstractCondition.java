package conditions;

public abstract class AbstractCondition<T> implements Condition<T> {
    public abstract boolean  isSatisfiedBy(T candidate);
    public AbstractCondition and(Condition<T> s){
         return new AndCondition(this,s);
     }
    public AbstractCondition or(Condition<T> s){
        return new OrCondition(this,s);
    }
    public AbstractCondition not(){
        return new NotCondition(this);
    }
}
