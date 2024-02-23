/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */

/**
 * 2)*
 * Создать класс CreditCard c полями номер счета, текущая сумма на счету.
 * Добавьте метод, который позволяет начислять сумму на кредитную карточку.
 * Добавьте метод, который позволяет снимать с карточки некоторую сумму (нельзя опускать меньше нуля).
 * Добавьте метод, который выводит текущую информацию о карточке.
 * Напишите программу, которая создает три объекта класса CreditCard у которых заданы номер счета и начальная сумма
 * Тестовый сценарий для проверки:
 * Положите деньги на первые две карточки и снимите с третьей.
 * Выведите на экран текущее состояние всех трех карточек.
 */
public class CreditCard {
    private static final long low = 1_000_000_000_000_000L;
    private static final long high = 10_000_000_000_000_000L;
    private final long cardNumber = (long) (Math.random() * (high - low)) + low;
    private double balance;

    public boolean add(double amount) {
        if (amount < 0.5) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount < 0 || this.balance - amount < 0.0) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                ", balance=" + balance +
                '}';
    }
}
