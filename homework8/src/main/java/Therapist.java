/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Therapist extends Doctor {
    @Override
    public String treat() {
        return "Выпить таблетки. много спать!!!";
    }

    static public Doctor appointDoctor(Doctor doctor) {
        return doctor;
    }
}
