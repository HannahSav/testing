package task3;

public class Robot {

    String currentPosition;
    String currentAction;
    private final RobotHead head;
    private Man defaultMan;

    public Robot() {
        currentPosition = ", сидящего в углу, ";
        head = new RobotHead();
        defaultMan = new Man("некто");
    }

    public class RobotHead {
        String currentAction;

        public void move() {
            up();
            rock();
        }

        public void up() {
            currentAction = this + getCurrentPosition() + "сначала резко дернулась вверх";
        }

        public void rock() {
            currentAction = currentAction + ", а затем едва заметно закачалась из стороны в сторону";
        }

        public String getCurrentAction() {
            return currentAction;
        }

        @Override
        public String toString() {
            return "Голова робота";
        }

    }

    public void standUp() {
        currentAction = this + " тяжело поднялся на ноги";
    }

    public void crossRoom(Man man) {
        if (man == null)
            man = defaultMan;
        currentAction = this + " сделал то, что показалось бы " + man.getName() +  " героической попыткой пересечь комнату";
    }

    public void stopNear(Man man) {
        if (man == null)
            man = defaultMan;
        currentAction = this + " остановился перед " + man.getName();
    }

    public void seeThrow(PartBody partBody) {
        if (partBody == null)
            currentAction = this + " посмотрел, как будто, сквозь что-то неизвестное";
        else
            currentAction = this + " посмотрел, как будто, сквозь " + partBody.getDescription();
    }

    public String getCurrentAction() {
        return currentAction;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public RobotHead getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "Он";
    }
}
