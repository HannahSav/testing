package task3;

public class Trillian extends Man{

    private final PartBody leftShoulder;

    public Trillian() {
        super("Триллиан");
        leftShoulder = new PartBody("левое плечо");
    }

    public PartBody getLeftShoulder() {
        return leftShoulder;
    }
}
