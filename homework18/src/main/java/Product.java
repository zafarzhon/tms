import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
@Data
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
    private Category category;
    List<Store> listStories;
    private boolean onDelivery;
    private Producer producer;

}
//
// new Product("Шоколадный батончик Snickers 50.5 г",40,
// new Store(,"Москва","115035, г. Москва, Овчинниковская набережная, д.
// 18/1, стр. 2", "8 495 783-08-88");
// new Producer("ООО Марс", "Россия");