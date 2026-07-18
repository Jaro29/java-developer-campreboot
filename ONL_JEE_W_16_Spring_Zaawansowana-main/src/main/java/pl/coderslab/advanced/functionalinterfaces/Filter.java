package pl.coderslab.advanced.functionalinterfaces;

    @FunctionalInterface
    public interface Filter<V> {
        boolean check(V v);
    }

