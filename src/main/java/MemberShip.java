public class MemberShip {

    private int bonusPointBalance;
    private int newPoints;
    private String membershipName = "";

    public MemberShip(String membershipName) {
        this.membershipName = membershipName;
    }


    public int registerPoints(int newPoints, int bonusPointBalance){
    this.bonusPointBalance = newPoints + bonusPointBalance;
    return this.bonusPointBalance;

    }


}
