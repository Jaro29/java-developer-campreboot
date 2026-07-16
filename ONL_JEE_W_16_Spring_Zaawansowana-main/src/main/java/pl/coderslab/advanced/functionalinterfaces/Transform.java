package pl.coderslab.advanced.functionalinterfaces;

@FunctionalInterface
public interface Transform<T, S> {
    T transform(S s);
}
