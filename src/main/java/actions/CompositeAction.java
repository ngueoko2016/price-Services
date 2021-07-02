package actions;

import java.util.HashSet;
import java.util.Set;

public class CompositeAction<T>  implements Action<T> {

    Set<Action<T>> actions = new HashSet<Action<T>>();

    public CompositeAction(Action<T> ... action) {
        for (Action a:action) {
            actions.add(a);
        }
    }

    @Override
    public void execute(T candidte) {
     for (Action<T> action:actions){
         action.execute(candidte);
     }
    }
}
