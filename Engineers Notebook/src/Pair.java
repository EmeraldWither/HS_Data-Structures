public class Pair <T> {
    private T first;
    private T second;
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
    public void swap() {
        T tmp = first;
        first = second;
        second = tmp;
    }
    @Override
    public String toString() {
        return "first: " + first + " | second: " + second;
    }
}


