package pl.coderslab.advanced.lambda;

@FunctionalInterface
public interface Calculate<N> {
    N calculate(N n);
}
