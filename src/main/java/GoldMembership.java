public class GoldMembership extends Membership{

    private float pointScalingFactor1 = 1.3f;
    private float pointScalingFactor2 = 1.5f;

    public GoldMembership(){
        super("Gold");
    }

    public int registerPoints(int newPoints, int bonusPointBalance){
        float pointScalingFactor;
        if(bonusPointBalance < 90000){
            pointScalingFactor = pointScalingFactor1;
        }else{
            pointScalingFactor = pointScalingFactor2;
        }
        return Math.round(super.registerPoints(bonusPointBalance, newPoints) * pointScalingFactor);
    }


}
