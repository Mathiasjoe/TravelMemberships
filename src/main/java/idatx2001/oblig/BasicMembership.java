package idatx2001.oblig;

/**
 * The type Basic membership.
 */
public class BasicMembership extends Membership{

    private int bonusPointBalance;
    private int newPoints;
    private String membershipName = "";
    private float pointScalingFactor = 1.0f;

    /**
     * Instantiates a new Basic membership.
     */
    public BasicMembership() {
        this.membershipName = "Basic";
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
