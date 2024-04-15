import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        //----------------Creating objects------------------------
        List<Product> productList;
        {
            Store megaVigoda = new Store(343445, "Москва", "115035, г. Москва, Овчинниковская набережная, д. 18/1, стр. 2", "8 (495) 783-08-88");
            Store metro = new Store(253535, "Минск", "Минск, улица Дорожная, " + "1к1", "8 (800) 700-10-77");
            Store pyterochka = new Store(132454, "Санкт-Питербург", "Санкт-Питербург, " + "улица старакачловская, 13к7", "8 (590) 556-14-67");
            Store redAndWhite = new Store(666666, "Москва", "Москва, улица Каширская, 26к1", "8 (666) 666-66-67");
            Store ashan = new Store(857322, "Санкт-Питербург", "Санкт-Питербург, улица Победителей, 3к4", "8 (374) 947-59-34");
            Store perekrestok = new Store(539435, "Минск", "Минск, улица " + "старакачловская, 13к7", "8 (625) 143-12-47");

            Producer producer1 = new Producer("ООО МАРС", "Россия");
            Producer producer2 = new Producer("August Storck KG", "Германия");
            Producer producer3 = new Producer("Mondelēz International", "Австрия");
            Producer producer4 = new Producer("PepsiCo", "Россия");
            Producer producer5 = new Producer("ООО Мултон Партнерс", "Россия");
            Producer producer6 = new Producer("DELORD FRERES SA", "Франция");
            Producer producer7 = new Producer("Jack Daniel'S Properties, Inc.", "США");
            Producer producer8 = new Producer("Ladoga", "Россия");

            productList = List.of(new Product("Шоколадный батончик Snickers " + "50.5 г", 40, Category.SWEETS, List.of(metro, megaVigoda, perekrestok, pyterochka, ashan, redAndWhite), true, producer1), new Product("Шоколадный батончик Twix 55 г", 40, Category.SWEETS, List.of(metro, megaVigoda, perekrestok, pyterochka, ashan, redAndWhite), true, producer1), new Product("Набор шоколадных конфет Merci " + "Шоколадный мусс " + "210 г", 398, Category.SWEETS, List.of(metro, megaVigoda, perekrestok, pyterochka, ashan), true, producer3), new Product("Набор шоколадных конфет Merci Изюм с орехом" + " 210 г", 500, Category.SWEETS, List.of(metro, megaVigoda, perekrestok, pyterochka, ashan), true, producer3), new Product("Молочный шоколад Milka, с Печеньем, Флоу-пак, " + "300г", 295, Category.SWEETS, List.of(metro, perekrestok, pyterochka, ashan), true, producer2), new Product("Молочный шоколад Milka, c гречским орехом, " + "300г", 255, Category.SWEETS, List.of(metro, megaVigoda, ashan), true, producer2), new Product("Напиток энергетический Adrenaline Rush " + "безалкогольный 0,499 л", 119, Category.DRINKS, List.of(metro, megaVigoda, perekrestok, pyterochka, ashan, redAndWhite), true, producer4), new Product("Напиток энергетический Adrenaline Rush " + "безалкогольный 0,250 л", 95, Category.DRINKS, List.of(metro, perekrestok, pyterochka, ashan), true, producer4), new Product("Напиток газированный Добрый Cola 1,5 л ПЭТ", 109, Category.DRINKS, List.of(metro, megaVigoda, perekrestok, pyterochka, ashan), true, producer5), new Product("Напиток газированный Добрый Cola 1 л ПЭТ", 95, Category.DRINKS, List.of(metro, megaVigoda, ashan), true, producer5), new Product("Напиток газированный Добрый Cola 0,5 л ПЭТ", 76, Category.DRINKS, List.of(metro, megaVigoda, ashan), true, producer5), new Product("Виски Теннесси Джек Дениел`с, США, 1 л., 40%", 2639.99, Category.WHISKEY, List.of(redAndWhite), false, producer7), new Product("Виски бурбон Джим Бим США, 0.75 л., 40%", 1509.06, Category.WHISKEY, List.of(redAndWhite), false, producer7), new Product("Бренди Делор Фрер X.O. п/к Франция, 0.7 л., Арманьяк (Гасконь), 40%", 3999.99, Category.COGNAC, List.of(redAndWhite), false, producer6), new Product("Водка Царская Оригинальная, 40 %, 1000 мл", 749, Category.VODKA, List.of(megaVigoda, redAndWhite), true, producer8), new Product("Водка Царская Оригинальная, 40 %, 500 мл", 399, Category.VODKA, List.of(megaVigoda, redAndWhite), true, producer8), new Product("Водка Царская Оригинальная, 40 %, 50 мл", 85, Category.VODKA, List.of(megaVigoda, redAndWhite), true, producer8));
        }

        //-------------------------BEGIN--------------------------
        System.out.println("1) определить самый дорогой и дешевый товар");
        System.out.println(productList.stream().max(Comparator.comparingDouble(Product::getPrice)).get());
        System.out.println(productList.stream().min(Comparator.comparingDouble(Product::getPrice)).get());

        System.out.println("2) найти все товары которые возможно доставить до покупателя");
        System.out.println(productList.stream().filter(Product::isOnDelivery).collect(Collectors.toList()));

        System.out.println("3) посчитать среднюю стоимость товара указанной категории");
        // SWEETS
        System.out.println(productList.stream().filter(p -> p.getCategory() == Category.SWEETS).mapToDouble(Product::getPrice).average().getAsDouble());

        System.out.println("4) найти все товары определенного производителя");
        System.out.println(productList.stream().filter(p -> p.getProducer().getName().equalsIgnoreCase("ООО МАРС")).collect(Collectors.toList()));

        System.out.println("5) найти всех названия производителей указанной страны");
        System.out.println(productList.stream().map(Product::getProducer).filter(producer -> producer.getCountry().equalsIgnoreCase("россия")).map(Producer::getName).distinct().collect(Collectors.toList()));

        System.out.println("6) найти все магазины конкретного города");
        System.out.println(productList.stream().flatMap(p -> p.getListStories().stream()).filter(s -> s.getCity().equalsIgnoreCase("минск")).distinct().collect(Collectors.toList()));

        System.out.println("7) найти адрес магазина по указанному номеру телефона");
        System.out.println(productList.stream().flatMap(product -> product.getListStories().stream()).filter(s -> s.getPhoneNumber().equalsIgnoreCase("8 (590) 556-14-67")).distinct().map(Store::getAddress).collect(Collectors.joining()));

        System.out.println("8) все товары указанного номера магазина");
        System.out.println(productList.stream().filter(p -> p.getListStories().stream().anyMatch(store -> store.getPhoneNumber().equals("8 (590) 556-14-67"))).collect(Collectors.toList()));

        System.out.println("9) составить map где ключ это номер магазина, а значение - это номер телефона\n" + "    данного магазина");
        System.out.println(productList.stream().flatMap(p -> p.getListStories().stream()).distinct().collect(Collectors.toMap(Store::getId, Store::getPhoneNumber)));

        System.out.println("10) узнать все ли товары указанной категории можно доставить до покупателя");
        System.out.println(productList.stream().filter(product -> product.getCategory() == Category.SWEETS).allMatch(Product::isOnDelivery));

        System.out.println("11) посчитать количество магазинов");
        System.out.println(productList.stream().flatMap(p -> p.getListStories().stream()).distinct().count());

        System.out.println(("12) вывести товары отсортированные по стоимости (от большего к " + "меньшему)"));
        System.out.println(productList.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toList());


        //--------------------SECOND-PART---------------------------------------

        System.out.println("1) Найти среднее значение первых 10 чисел.");
        System.out.println(IntStream.iterate(1, i -> ++i).limit(10).average().orElse(0.0));

        System.out.println("2) Пропустить 5 чисел и вывести следующие 10 чисел, которые делятся на 3 без\n" + "    остатка");
        System.out.println(IntStream.iterate(1, i -> ++i).filter(i -> i % 3 == 0).skip(5).limit(10).boxed().collect(Collectors.toList()));

        System.out.println("3) Посчитать сумму 20 подряд идущих чисел");
        System.out.println(IntStream.iterate(1, i -> ++i).limit(20).sum());


        //-------------------------------extern-tasks---------------------------

        System.out.println(("к примеру из нашей домашки - найди среднюю стоимость по типу товара " + "(тип - это enum)"));
        System.out.println(productList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice))));

        System.out.println("есть набор строк - используя стрим верни одну строку, " +
                "котоая будет соединять исходные при помощь запятой -> “test1”, “test2”, “test3” -> “test1,test2,test3”");
        System.out.println(Stream.of("test1", "test2", "test3").collect(Collectors.joining(",")));

        System.out.println("Есть стрим из чисел\n" +
                "Необходимо взять n-количество подряд идущий чисел и определить сколько в них четных а сколько не-четных.\n" +
                "Так же посчитать сумму четных и нечетных чисел.\n" +
                "Результат представить в виде map<Type, Integer>");

        Stream<Integer> stream = Stream.iterate(1,i->++i).limit(10);
        // false -> for odd numbers
        // true  -> for even  numbers
//        Map<Boolean, Integer> collect = stream.collect(Collectors.partitioningBy(i -> i % 2 == 0,
//                Collectors.summingInt(Integer::intValue)));
//        System.out.println(collect);
        // or
        Map<Boolean, IntSummaryStatistics> collect =
                stream.collect(Collectors.partitioningBy(i -> i % 2 == 0,
                Collectors.summarizingInt(Integer::intValue)));
        for(Boolean st : collect.keySet()){
            System.out.println(st+" : "+collect.get(st).getSum()+"\n"+"Count " +
                    ": " + collect.get(st).getCount());
        }

    }
}
