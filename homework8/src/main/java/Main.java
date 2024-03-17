/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        /*
           code 0 - Therapist
           code 1 - Surgeon
           code 2 - Dentist
        */

        Therapist therapist = (Therapist) DoctorFactory.getDoctor("THeraPist");

        Patient[] patients = new Patient[]{new Patient(0), new Patient(1),
                new Patient(2)};

        for (Patient patient : patients) {
            therapist.appointDoctor(patient);
            System.out.println(patient.getDoctor());
        }

        for (Patient patient : patients) {
            System.out.println(patient.getDoctor().treat());
        }


    }
}
