package pl.coderslab.advanced.functionalinterfaces;

public class IntegerFilter implements Filter<Integer> {
    @Override
    public boolean check(Integer v) {
        return v < 20;
    }
}
