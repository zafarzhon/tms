/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public final class DoctorFactory {
    private static final Therapist therapist = new Therapist();
    private static final Surgeon surgeon = new Surgeon();
    private static final Dentist dentist = new Dentist();

    private DoctorFactory() {
    }

    public static Doctor getDoctor(String type) {
        return switch (type.toLowerCase().trim()) {
            case "therapist" -> therapist;
            case "surgeon" -> surgeon;
            case "dentist" -> dentist;
            default -> {
                System.err.println("Error in type doctor");
                yield null;
            }
        };
    }

    public static Doctor getDoctor(int treatmentPlan) {
        return switch (treatmentPlan) {
            case 0 -> therapist;
            case 1 -> surgeon;
            case 2 -> dentist;
            default -> {
                System.err.println("Error in appoint doctor");
                yield null;
            }
        };
    }
}
