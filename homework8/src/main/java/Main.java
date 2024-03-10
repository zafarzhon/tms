/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient();
        patient.setTreatmentPlan("Убрать один зуб блаблабла");
        patient.setDoctor(Therapist.appointDoctor(new Dentist()));

        System.out.println(patient.getDoctor().treat());


        Patient patient1 = new Patient();
        patient1.setTreatmentPlan("отрезать палец блп блп бла");
        patient1.setDoctor(Therapist.appointDoctor(new Surgeon()));

        System.out.println(patient1.getDoctor().treat());

    }
}
