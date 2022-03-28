import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import task3.Robot;
import task3.Somebody;
import task3.Trillian;

public class RobotTest {

    private Robot robot;
    private Trillian trillian;
    private Somebody smb;

    @BeforeEach
    void setUp() {
        robot = new Robot();
        trillian = new Trillian();
        smb = new Somebody();
    }

    @Test
    public void moveTest() {
        robot.getHead().move();
        Assertions.assertEquals("Голова робота, сидящего в углу, сначала резко дернулась вверх, а затем едва заметно закачалась из стороны в сторону", robot.getHead().getCurrentAction());
    }

    @Test
    public void standUpTest() {
        robot.standUp();
        Assertions.assertEquals("Он тяжело поднялся на ноги", robot.getCurrentAction());
    }

    @Test
    public void crossRoomTest() {
        robot.crossRoom(smb);
        Assertions.assertEquals("Он сделал то, что показалось бы посторонний наблюдатель героической попыткой пересечь комнату", robot.getCurrentAction());
    }

    @Test
    public void crossRoomNullTest() {
        robot.crossRoom(null);
        Assertions.assertEquals("Он сделал то, что показалось бы некто героической попыткой пересечь комнату", robot.getCurrentAction());
    }

    @Test
    public void stopNearTest() {
        robot.stopNear(trillian);
        Assertions.assertEquals("Он остановился перед Триллиан", robot.getCurrentAction());
    }

    @Test
    public void stopNearNullTest() {
        robot.stopNear(null);
        Assertions.assertEquals("Он остановился перед некто", robot.getCurrentAction());
    }

    @Test
    public void seeThrowTest() {
        robot.seeThrow(trillian.getLeftShoulder());
        Assertions.assertEquals("Он посмотрел, как будто, сквозь левое плечо", robot.getCurrentAction());
    }

    @Test
    public void seeThrowNullTest() {
        robot.seeThrow(null);
        Assertions.assertEquals("Он посмотрел, как будто, сквозь что-то неизвестное", robot.getCurrentAction());
    }
}
