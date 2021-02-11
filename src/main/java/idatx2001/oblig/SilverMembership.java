package idatx2001.oblig;

/**
 * The type Silver membership.
 */
public class SilverMembership extends Membership{

    private int bonusPointBalance;
    private int newPoints;
    private String membershipName = "";
    private float pointScalingFactor = 1.2f;

    /**
     * Instantiates a new Silver membership.
     */
    public SilverMembership(){
        this.membershipName = "Silver";
    }

    @Override
    public int registerPoints(int newPoints, int bonusPointBalance){
        this.bonusPointBalance = bonusPointBalance + Math.round(newPoints * pointScalingFactor);

        return this.bonusPointBalance;
    }

    @Override
    public String getMembershipName() {
        return membershipName;
    }
}
