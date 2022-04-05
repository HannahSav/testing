import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import task3.*;

public class RobotTest {

    private Robot robot;
    private ManWithPartsBody trillian;
    private Man smb;

    @BeforeEach
    void setUp() {
        robot = new Robot();
        trillian = new ManWithPartsBody("Триллиан", new PartBody("левое плечо"));
        trillian.setPositionX(15);
        trillian.setPositionY(15);
        smb = new Man("посторонний наблюдатель");
    }

    @Test
    @DisplayName("Stand up")
    public void standUpTest() {
        robot.standUp();
        Assertions.assertEquals("стоит", robot.getCurrentPosition());
        Assertions.assertEquals("Робот тяжело поднялся на ноги", robot.getCurrentAction());
    }

    @Test
    public void standUpTestError() {
        robot.standUp();
        robot.standUp();
        Assertions.assertEquals("стоит", robot.getCurrentPosition());
        Assertions.assertEquals("Робот уже стоит", robot.getCurrentAction());
    }

    @Test
    public void crossRoomSitTest() {
        robot.crossRoom(smb, 10, 10);
        Assertions.assertEquals("Робот должен сначала встать", robot.getCurrentAction());
    }

    @Test
    public void crossRoomChangePositionTest() {
        robot.standUp();
        robot.crossRoom(smb, 10, 10);
        Assertions.assertEquals("Робот сделал то, что показалось бы посторонний наблюдатель героической попыткой пересечь комнату", robot.getCurrentAction());
    }

    @Test
    public void crossRoomNoChangePositionTest() {
        robot.standUp();
        robot.crossRoom(smb, 10, 10);
        robot.crossRoom(smb, 10, 10);
        Assertions.assertEquals("Робот остался стоять на месте", robot.getCurrentAction());
    }

    @Test
    public void crossRoomNullManChangePositionTest() {
        robot.standUp();
        robot.crossRoom(null, 10, 10);
        Assertions.assertEquals("Робот сделал то, что показалось бы никого героической попыткой пересечь комнату", robot.getCurrentAction());
    }
    @Test
    public void crossRoomNullManNoChangePositionTest() {
        robot.standUp();
        robot.crossRoom(null, 10, 10);
        robot.crossRoom(null, 10, 10);
        Assertions.assertEquals("Робот остался стоять на месте", robot.getCurrentAction());
    }

    @Test
    public void stopNearSitTest() {
        robot.stopNear(trillian);
        Assertions.assertEquals("Робот должен сначала встать", robot.getCurrentAction());
    }

    @Test
    public void stopNearNullTest() {
        robot.standUp();
        robot.stopNear(null);
        Assertions.assertEquals("рядом никого нет", robot.getCurrentAction());
    }

    @Test
    public void stopNotNearTest() {
        robot.standUp();
        robot.crossRoom(smb, 10, 10);
        robot.stopNear(trillian);
        Assertions.assertEquals(10, robot.getPositionX());
        Assertions.assertEquals(10, robot.getPositionY());
        Assertions.assertEquals(15, trillian.getPositionX());
        Assertions.assertEquals(15, trillian.getPositionX());
        Assertions.assertEquals("рядом никого нет", robot.getCurrentAction());
    }

    @Test
    public void stopNear1Test() {
        robot.standUp();
        robot.crossRoom(smb, 14, 14);
        robot.stopNear(trillian);
        Assertions.assertEquals(14, robot.getPositionX());
        Assertions.assertEquals(14, robot.getPositionY());
        Assertions.assertEquals(15, trillian.getPositionX());
        Assertions.assertEquals(15, trillian.getPositionX());
        Assertions.assertEquals("Робот стоит перед Триллиан", robot.getCurrentAction());
    }

    @Test
    public void stopNear2Test() {
        robot.standUp();
        robot.crossRoom(smb, 16, 16);
        robot.stopNear(trillian);
        Assertions.assertEquals(16, robot.getPositionX());
        Assertions.assertEquals(16, robot.getPositionY());
        Assertions.assertEquals(15, trillian.getPositionX());
        Assertions.assertEquals(15, trillian.getPositionX());
        Assertions.assertEquals("Робот стоит перед Триллиан", robot.getCurrentAction());
    }

    @Test
    public void stopNearRunOverTest() {
        robot.standUp();
        robot.crossRoom(smb, 15, 15);
        robot.stopNear(trillian);
        Assertions.assertEquals(15, robot.getPositionX());
        Assertions.assertEquals(15, robot.getPositionY());
        Assertions.assertEquals(15, trillian.getPositionX());
        Assertions.assertEquals(15, trillian.getPositionX());
        Assertions.assertEquals("Робот наехал на Триллиан", robot.getCurrentAction());
    }

    @Test
    public void seeThrowTest() {
        robot.standUp();
        robot.crossRoom(smb, 15, 15);
        robot.seeThrow(trillian);
        Assertions.assertEquals("Робот посмотрел, как будто, сквозь левое плечо", robot.getCurrentAction());
    }

    @Test
    public void seeThrowNullPartBodyTest() {
        robot.standUp();
        robot.crossRoom(smb, 15, 15);
        robot.seeThrow(new ManWithPartsBody("Marta", null));
        Assertions.assertEquals("рядом никого нет", robot.getCurrentAction());
    }

    @Test
    public void seeThrowNullTest() {
        robot.seeThrow(null);
        Assertions.assertEquals("Робот должен сначала встать", robot.getCurrentAction());
    }

    @Test
    public void seeThrowNull2Test() {
        robot.standUp();
        robot.seeThrow(null);
        Assertions.assertEquals("рядом никого нет", robot.getCurrentAction());
    }
}
