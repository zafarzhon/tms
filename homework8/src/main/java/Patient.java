/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Patient {
    private Doctor doctor;

    private String TreatmentPlan;


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getTreatmentPlan() {
        return TreatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        TreatmentPlan = treatmentPlan;
    }
}
