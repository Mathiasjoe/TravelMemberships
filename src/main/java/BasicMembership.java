public class BasicMembership extends Membership{

    private float pointScalingFactor = 1.0f;

    public BasicMembership() {
        super("Basic");
    }

    public int registerPoints(int newPoints, int bonusPointBalance){
        return Math.round(super.registerPoints(bonusPointBalance, newPoints) * pointScalingFactor );
    }


    /**public String getMembershipName{
        return this.membershipName;
    }
     **/


}
