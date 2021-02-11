package idatx2001.oblig;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
     * The member archive holds all the bonus members. The archive provides
     * functionality for adding members to the register, looking up bonuspoints
     * of given members, registering new bonuspoints and listing all the members.
     *
     * @author arne
     */
    public class MemberArchive {

        // Use a HashMap, since the members have a unique member number.
        private HashMap<Integer, BonusMember> members;

        /**
         * Creates a new instance of MemberArchive.
         */
        public MemberArchive() {
            this.members = new HashMap<>();
            this.fillRegisterWithTestdata();
        }

        /**
         * Adds a new member to the register. The new member must have a memebr number
         * different from exsisting members. If not, the new member will not be added.
         *
         * @return {@code true} if the new member was added successfully,
         *         {@code false} if the new member could not be added, due to a
         *          membernumber that allready exsists.
         */
        public boolean addMember(BonusMember bonusMember) {
            boolean success = false;
            if(!this.members.containsKey(bonusMember.getMemberNumber())){
                this.members.putIfAbsent(bonusMember.getMemberNumber(), bonusMember);
                success = true;
            }
            return success;
        }

        /**
         * Registers new bonuspoints to the member with the member number given
         * by the parameter {@code memberNumber}. If no member in the register
         * matches the provided member number, {@code false} is returned.
         *
         * @param memberNumber the member number to add the bonus points to
         * @param bonusPoints the bonus points to be added
         * @return {@code true} if bonuspoints were added successfully,
         *         {@code flase} if not.
         */
        public boolean registerPoints(int memberNumber, int bonusPoints) {
            boolean success = false;
            if(this.members.containsKey(memberNumber)){
                this.members.get(memberNumber).registerBonusPoints(bonusPoints);
                success = true;
            }
            return success;
        }


        /**
         * Lists all members to the console.
         */
        public void listAllMembers() {
            for(Map.Entry<Integer, BonusMember> entry : members.entrySet()){
                System.out.println("---------------");
                System.out.println("Members name: " + entry.getValue().getName());
                System.out.println("Members email: " + entry.getValue().geteMailAddress());
                System.out.println("Member number: " + entry.getValue().getMemberNumber());
                System.out.println("Members bonuspoint balance: " + entry.getValue().getBonusPointsBalance());
                System.out.println("Membership status: " + entry.getValue().getMembership().getMembershipName());
                System.out.println("\n");
            }
        }

    /**
     * Finds the bonuspoint balance for a member by searching for its number.
     *
     * @param memberNumber The number for the member
     * @param password Checks if the password is correct
     * @return -1 if the Memburnumber doesn't exist or the password is incorrect.
     * @return the Bonuspoint balance if the member is found.
     */
        public int findPoints(int memberNumber, String password){
            int bonusPoints = -1;
            if(this.members.containsKey(memberNumber)){
                if(this.members.get(memberNumber).checkPassword(password)){
                    bonusPoints = this.members.get(memberNumber).getBonusPointsBalance();
                }

            }
            return bonusPoints;
        }


        /**
         * Fills the register with some arbitrary members, for testing purposes.
         */
        private void fillRegisterWithTestdata() {
            BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "123");
            this.members.put(member.getMemberNumber(), member);
            member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz", "123");
            this.members.put(member.getMemberNumber(), member);
            member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no", "123");
            this.members.put(member.getMemberNumber(), member);
            member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org", "123");
            this.members.put(member.getMemberNumber(), member);
            member = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com", "123");
            this.members.put(member.getMemberNumber(), member);

        }


    }

