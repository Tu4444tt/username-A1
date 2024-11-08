public class AssignmentOne {
    // Part 1- a class named HealthProfessional.
    public class HealthProfessional {
        private int ID;
        private String name;
        private String phonenum;

        public HealthProfessional() {
            // Default constructor
        }

        public HealthProfessional(int ID, String name, String phonenum) {
            this.ID = ID;
            this.name = name;
            this.phonenum = phonenum;
        }

        public void printDetails() {
            // Output information
            System.out.println("------------------------------" );
            System.out.println("The health professional details are: ID: " + ID + ", Name: " + name + ", Phone Number: "
                    + phonenum);
        }
    }
    
}
