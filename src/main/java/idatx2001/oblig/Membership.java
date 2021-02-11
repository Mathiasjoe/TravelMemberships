package idatx2001.oblig;

/**
 * Represents a basic membership
 */
public abstract class Membership {


    /**
     * Register the points for a member.
     * @param newPoints the new points added to the register
     * @param bonusPointBalance the points already registered to the member
     * @return the total amount of points.
     */
    public abstract int registerPoints(int newPoints, int bonusPointBalance);

    /**
     * Get the name of the Membership status
     * @return Gold, Silver or Basic, depending on the amount of points in the register.
     */
    public abstract String getMembershipName();


}




