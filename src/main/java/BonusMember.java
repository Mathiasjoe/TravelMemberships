import java.time.LocalDate;

public class BonusMember {

    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;


    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name,
                       String eMailAddress, String password, Membership membership) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = password;
        this.membership = membership;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setBonusPointsBalance(int bonusPointsBalance) {
        this.bonusPointsBalance = bonusPointsBalance;
    }

    public Membership checkAndSetMembership(int bonusPointsBalance){
        Membership membership = new BasicMembership();
        if(bonusPointsBalance > SILVER_LIMIT){
            membership = new SilverMembership();
        } if(bonusPointsBalance > GOLD_LIMIT){
            membership = new GoldMembership();
        }
        return membership;
    }

    public boolean checkPassword(String password){
        boolean success = false;
        if(password.equals(this.password)){
            success = true;
        }
        return success;
    }

    public void registerBonusPoints(int newPoints){
        int pointsToRegister = this.membership.registerPoints(getBonusPointsBalance(),newPoints);
        setBonusPointsBalance(pointsToRegister);
        checkAndSetMembership(getBonusPointsBalance());

    }


}