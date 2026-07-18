package pl.coderslab.advanced.lambda;

@FunctionalInterface
public interface Converter<T, R> {
    R convert(T t);
}
