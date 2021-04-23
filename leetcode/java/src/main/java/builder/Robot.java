package builder;

public class Robot implements RobotPlan {
    private String robotHead;

    @Override
    public void setRobotHead(String head) {
        robotHead = head;

    }

    public String getRobotHead() {
        return robotHead;
    }


}
