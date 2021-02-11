package idatx2001.oblig;

import java.time.LocalDate;

/**
 * Holds all the information of the Bonus Member.
 */
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


    /**
     * Creates an instance of a bonusmember.
     *
     * @param memberNumber       the number for the member.
     * @param enrolledDate       the date the registered points
     * @param bonusPointsBalance the amount of points the member has.
     * @param name               the name of the Member
     * @param eMailAddress       The members eMail Address
     * @param password           The members password.
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name,
                       String eMailAddress, String password) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = password;
        this.membership = checkAndSetMembership(bonusPointsBalance);
    }

    /**
     * Returns the number of the member in the register.
     *
     * @return the member number
     */
    public int getMemberNumber() {
        return memberNumber;
    }

    /**
     * Get the date from the registered points.
     *
     * @return the date from the day of the register.
     */
    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }


    /**
     * Gets bonus points balance.
     *
     * @return the bonus points balance
     */
    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    /**
     * Gets mail address.
     *
     * @return the mail address
     */
    public String geteMailAddress() {
        return eMailAddress;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets membership.
     *
     * @return the membership
     */
    public Membership getMembership() {
        return membership;
    }

    /**
     * Sets bonus points balance.
     *
     * @param bonusPointsBalance the bonus points balance
     */
    public void setBonusPointsBalance(int bonusPointsBalance) {
        this.bonusPointsBalance = bonusPointsBalance;
    }

    /**
     * Check and set membership membership.
     *
     * @param bonusPointsBalance the bonus points balance
     * @return the membership
     */
    public Membership checkAndSetMembership(int bonusPointsBalance){
        Membership membership = new BasicMembership();
        if(bonusPointsBalance > SILVER_LIMIT){
            membership = new SilverMembership();
        } if(bonusPointsBalance > GOLD_LIMIT){
            membership = new GoldMembership();
        }
        return membership;
    }

    /**
     * Checks if the password is correct.
     *
     * @param password the password
     * @return success if the password is correct.
     */
    public boolean checkPassword(String password){
        boolean success = false;
        if(password.equals(this.password)){
            success = true;
        }
        return success;
    }

    /**
     * Register the bonus points.
     *
     * @param newPoints the new points
     */
    public void registerBonusPoints(int newPoints){
        int pointsToRegister = this.membership.registerPoints(getBonusPointsBalance(),newPoints);
        setBonusPointsBalance(pointsToRegister);
        this.membership = checkAndSetMembership(getBonusPointsBalance());

    }


}