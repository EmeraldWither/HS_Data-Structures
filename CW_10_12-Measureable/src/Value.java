public class Value implements Measureable {

    private int value;
    public Value(int value){
        this.value = value;
    }
    @Override
    public int getMeasure() {
        return this.value;
    }
    
}
