public class SilverMembership extends MemberShip{

    private float pointScalingFactor = 1.2f;

    public SilverMembership(){
        super("Silver");
    }

    public int registerPoints(int newPoints, int bonusPointBalance){
        return Math.round(super.registerPoints(bonusPointBalance, newPoints) * pointScalingFactor);
    }
}
