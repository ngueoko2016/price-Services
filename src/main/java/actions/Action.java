package actions;

public interface Action<T> {
    void execute(T candidte);
}
