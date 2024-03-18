/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Therapist extends Doctor {
    @Override
    String treat() {
        return "Выпить таблетки. много спать!!!";
    }

    public void appointDoctor(Patient patient) {
        int treatmentPlan = patient.getTreatmentPlan();
        Doctor doctor = DoctorFactory.getDoctor(treatmentPlan);
        patient.setDoctor(doctor);
    }
}
