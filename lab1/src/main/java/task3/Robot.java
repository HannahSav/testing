package task3;

import static java.lang.Math.abs;

public class Robot {

    PositionRobot currentPosition;
    String currentAction;
    private final RobotHead head;
    private final Man noMan = new Man("никого");
    private int positionX, positionY;

    public Robot() {
        currentPosition = PositionRobot.сидит;
        head = new RobotHead();
    }

    public class RobotHead {
        String currentAction;
        PositionRobotHead currentPosition = PositionRobotHead.опущена;

        public void up() {
            if (getCurrentPosition().equals("сидит") && currentPosition == PositionRobotHead.опущена) {
                currentAction = this + " сначала резко дернулась вверх";
                currentPosition = PositionRobotHead.поднята;
            } else {
               faultAction();
            }
        }

        public void down() {
            if (getCurrentPosition().equals("сидит") && currentPosition == PositionRobotHead.поднята) {
                currentAction = this + " резко опустилась";
                currentPosition = PositionRobotHead.опущена;
            } else {
                faultAction();
            }
        }

        public void rock() {
            if (getCurrentPosition().equals("сидит") && Robot.this.getCurrentAction().equals("поднята")) {
                currentAction = this + " затем едва заметно закачалась из стороны в сторону";
            } else {
                faultAction();
                currentAction = currentAction + " и с опущеной головой";
            }
        }

        private void faultAction() {
            currentAction = this + " не может изменять положение стоя";
        }

        public String getCurrentAction() {
            return currentAction;
        }

        public String getCurrentPositionHead() {
            return currentPosition.toString();
        }

        @Override
        public String toString() {
            return "Голова робота";
        }

    }

    public void standUp() {
        if (currentPosition == PositionRobot.сидит) {
            currentPosition = PositionRobot.стоит;
            currentAction = this + " тяжело поднялся на ноги";
        } else {
            currentAction = this + " уже стоит";
        }
    }

    public void crossRoom(Man man, int changeToX, int changeToY) {
        if (currentPosition == PositionRobot.стоит) {
            if (man == null)
                man = noMan;
            if (changeToX != positionX && changeToY != positionY) {
                currentAction = this + " сделал то, что показалось бы " + man.getName() + " героической попыткой пересечь комнату";
                positionX = changeToX;
                positionY = changeToY;
            } else {
                currentAction = this + " остался стоять на месте";
            }
        } else {
            currentAction = this + " должен сначала встать";
        }
    }

    public boolean stopNear(Man man) {
        if (currentPosition == PositionRobot.стоит) {
            if (man == null) {
                currentAction = "рядом никого нет";
                return false;
            }
            if (abs(positionX - man.getPositionX()) < 2 && abs(positionY - man.getPositionY()) < 2) {
                if (positionX == man.getPositionX() && positionY == man.getPositionY()) {
                    currentAction = this + " наехал на " + man.getName();
                } else
                    currentAction = this + " стоит перед " + man.getName();
                return true;
            }
            currentAction = "рядом никого нет";
            return false;
        }
        currentAction = this + " должен сначала встать";
        return false;
    }

    public void seeThrow(ManWithPartsBody man) {
        if (stopNear(man)) {
            if (man.getPartBody() == null)
                currentAction = this + " не может посмотреть через ничего";
            else
                currentAction = this + " посмотрел, как будто, сквозь " + man.getPartBody().getDescription();
        } else
            currentAction = this + " должен сначала остановиться рядом с этим человеком";

    }

    public String getCurrentAction() {
        return currentAction;
    }

    public String getCurrentPosition() {
        return currentPosition.toString();
    }

    public RobotHead getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "Робот";
    }
}
