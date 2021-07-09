
package builder;

//The actual builder
public class OldRobotBuilder implements RobotBuilder{
    private Robot robot;

    public OldRobotBuilder() {
        this.robot = new Robot();

    }

    @Override
    public void buildRobotHead() {
        robot.setRobotHead("Tin Head");

    }

    public Robot getRobot() {
        return this.robot;
    }
}
