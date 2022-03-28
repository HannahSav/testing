package task3;

public class ManWithPartsBody extends Man{

    private final PartBody partBody;

    public ManWithPartsBody(String name, PartBody partBody) {
        super(name);
        this.partBody = partBody;
    }

    public PartBody getPartBody() {
        return partBody;
    }
}
