package idatx2001.oblig;


/**
 * The type Gold membership.
 */
public class GoldMembership extends Membership{


    private int bonusPointBalance;
    private int newPoints;
    private String membershipName = "";
    private float pointScalingFactor1 = 1.3f;
    private float pointScalingFactor2 = 1.5f;

    /**
     * Instantiates a new Gold membership.
     */
    public GoldMembership(){

        this.membershipName = "Gold";
    }


    @Override
    public int registerPoints(int newPoints, int bonusPointBalance){
        float pointScalingFactor;

        if(bonusPointBalance < 90000){
            pointScalingFactor = pointScalingFactor1;
        }else{
            pointScalingFactor = pointScalingFactor2;
        }
        this.bonusPointBalance = bonusPointBalance + Math.round(newPoints * pointScalingFactor);
        return this.bonusPointBalance;
    }



    @Override
    public String getMembershipName() {
        return membershipName;
    }

}


