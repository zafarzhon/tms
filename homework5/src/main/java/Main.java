/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
public class Main {
    public static void main(String[] args) {
        cat();
        creditCard();
    }

    private static void cat() {
        Cat cat = new Cat("Murka", 7);
        System.out.println(cat);
        cat.setName("Pushok");
        System.out.println(cat.getName());
    }

    private static void creditCard() {
        CreditCard creditCard1 = new CreditCard();
        CreditCard creditCard2 = new CreditCard();
        CreditCard creditCard3 = new CreditCard();
        creditCard1.add(1000);
        creditCard2.add(1000);
        creditCard3.add(1000);

        System.out.println(creditCard1);
        System.out.println(creditCard2);
        System.out.println(creditCard3);


        creditCard3.withdraw(500);
        System.out.println(creditCard3);


    }
}
