import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task3.Robot;

public class HeadTest {
    private Robot robot;
    private Robot.RobotHead head;

    @Test
    public void UpHead(){
        robot = new Robot();
        head = robot.getHead();
        head.up();
        Assertions.assertEquals(head.getCurrentAction(), "Голова робота сначала резко дернулась вверх");
    }

    @Test
    public void UpHeadAfterUp(){
        robot = new Robot();
        head = robot.getHead();
        head.up();
        head.up();
        Assertions.assertEquals(head.getCurrentAction(), "Голова робота находится в положении поднята");
    }

    @Test
    public void DownHead(){
        robot = new Robot();
        head = robot.getHead();
        head.down();
        Assertions.assertEquals(head.getCurrentAction(), "Голова робота находится в положении опущена");
    }

    @Test
    public void DownHeadAfterUp(){
        robot = new Robot();
        head = robot.getHead();
        head.up();
        head.down();
        Assertions.assertEquals(head.getCurrentAction(), "Голова робота резко опустилась");
    }

    @Test
    public void UpWithStanding(){
        robot = new Robot();
        head = robot.getHead();
        robot.standUp();
        head.up();
        Assertions.assertEquals(head.getCurrentAction(), "Голова робота не может изменять положение стоя");
    }

    @Test
    public void RockWithStanding(){
        robot = new Robot();
        head = robot.getHead();
        robot.standUp();
        head.rock();
        Assertions.assertEquals(head.getCurrentAction(), " робот с опущеной головой (Голова робота не может изменять положение стоя)");
    }

    @Test
    public void RockWithSitting(){
        robot = new Robot();
        head = robot.getHead();
        head.rock();
        Assertions.assertEquals(head.getCurrentAction(), " робот с опущеной головой (Голова робота находится в положении опущена)");
    }

    @Test
    public void RockWithUpAndSitting(){
        robot = new Robot();
        head = robot.getHead();
        head.up();
        head.rock();
        Assertions.assertEquals(head.getCurrentAction(), "Голова робота затем едва заметно закачалась из стороны в сторону");
    }
}
