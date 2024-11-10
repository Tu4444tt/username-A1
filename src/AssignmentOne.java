import java.util.ArrayList;

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
     // Part 2 – Child classes (GeneralPractitioner and Dietitian)
     class GeneralPractitioner extends HealthProfessional {
        // General Practitioner subclass content
        // Subclass instance variable
        private boolean isGeneralPractitioner;

        // Subclass default constructor
        public GeneralPractitioner() {

        }

        // Subclass second constructor
        public GeneralPractitioner(int ID, String name, String phonenum) {

            super(ID, name, phonenum);
            this.isGeneralPractitioner = true;

        }

        // Override the printDetails method from the base class
        @Override
        public void printDetails() {
            super.printDetails();
            System.out.println(" Is GeneralPractitioner or not:" + isGeneralPractitioner);
        }
    }

    class Dietitian extends HealthProfessional {
        // Dietitian subclass content
        // Subclass instance variable
        private boolean isGeneralPractitioner;

        // Subclass default constructor
        public Dietitian() {

        }

        // Subclass second constructor
        public Dietitian(int ID, String name, String phonenum) {
            super(ID, name, phonenum);
            this.isGeneralPractitioner = false;
        }

        // Override the printDetails method from the base class
        @Override
        public void printDetails() {
            super.printDetails();
            System.out.println(" Is GeneralPractitioner or not:" + isGeneralPractitioner);
        }
    }
// Part 4 – Class Appointment

    // class Physician
    public class Physician {
        private String name;

        public Physician(String name) {
            this.name = name;
        }

        public String getName() {
            // Get name
            return name;
        }
    }

    // class Appointment
    public class Appointment {
        private String PatientName;
        private String PatientPhoneNumber;
        private String preferredTimeSlot;
        private Physician physician;

        public Appointment() {
            // Default constructor
        }

        public Appointment(String PatientName, String PatientPhoneNumber, String preferredTimeSlot, Physician physician) {
            this.PatientName = PatientName;
            this.PatientPhoneNumber = PatientPhoneNumber;
            this.preferredTimeSlot = preferredTimeSlot;
            this.physician = physician;
        }

        // Getters and Setters
        public void printDetails() {
            System.out.println("------------------------------");
            System.out.println("Name: " + PatientName);
            System.out.println("Phone Number: " + PatientPhoneNumber);
            System.out.println("Preferred Time Slot: " + preferredTimeSlot);
            System.out.println("Physician: " + physician.getName());
     

        }
        public String  getPhoneNumber() {
            return PatientPhoneNumber;
        }
    
    }

    ArrayList<Appointment> appointments = new ArrayList<>();

    public void createAppointment(String PatientName, String PatientPhoneNumber, String preferredTimeSlot,
            Physician physician) {
        Appointment appointment = new Appointment(PatientName, PatientPhoneNumber, preferredTimeSlot, physician);
        appointments.add(appointment);
    }

    public void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("There are no existing appointments available!");
        } else {
            System.out.println("------------------------------");
            System.out.println("Here are no existing appointments:");
            for (Appointment appointment : appointments) {
                appointment.printDetails();

            }
        }
    }

    public void cancelBooking(String PatientPhoneNumber) {
        for (Appointment appointment : appointments) {
            if (appointment.getPhoneNumber().equals(PatientPhoneNumber)) {
                appointments.remove(appointment);
                System.out.println("------------------------------" );
                System.out.println("The appointment has been successfully cancelled!\n");
                return;
            }
        }
        System.out.println("------------------------------" );
        System.out.println("No reservation was found for this phone number.\n");
    }
/**
 * @param args
 */
public static void main(String[] args) {


    // Part 3 – Using classes and objects
    // Create objects using instance methods
    AssignmentOne assignment = new AssignmentOne();
    // Create three General Practitioner objects
    GeneralPractitioner gp1 = assignment.new GeneralPractitioner(1,  "Alias", "+8613888880001");
    GeneralPractitioner gp2 = assignment.new GeneralPractitioner(2,  "Bob","+8613888880002");
    GeneralPractitioner gp3 = assignment.new GeneralPractitioner(3,  "Cilina",   "+8613888880003");

    // Create two Dietitian objects
    Dietitian Di1 = assignment.new Dietitian (4, "Daved", "+8613888880004");
    Dietitian Di2= assignment.new  Dietitian(5,"Echo", "+8613888880005");

    // Use the print methods from both the base class and the subclasses to print the details of all health professionals
    System.out.println(" Part 3 – Using classes and objects" );
    gp1.printDetails();
    gp2.printDetails();
    gp3.printDetails();
    Di1.printDetails();
    Di2.printDetails();
    






    // Part 5 – Collection of appointments
    // Declare an ArrayList that can store instances (objects) of Appointment class.

        // Book two appointments with General Practitioners
       assignment.createAppointment("Patient1", "1234567890", "08:00", assignment.new Physician("Alias"));
       assignment.createAppointment("Patient2", "1111111111", "12:00", assignment.new Physician("BOB"));

        // Book two more appointments with Dietitians
        assignment.createAppointment("Patient3", "1234567891", "14:30", assignment.new Physician("Daved"));
        assignment.createAppointment("Patient4", "1111111112", "16:00", assignment.new Physician("Echo"));

        // Print the existing appointments
        System.out.println("------------------------------" );
        System.out.println(" Part 5 – Collection of appointments");
        assignment. printExistingAppointments();

        // Cancel one of the existing appointments
        assignment. cancelBooking("1234567890");

        // Print the existing appointments again to show the updated list
        assignment.printExistingAppointments();
       
}
}
