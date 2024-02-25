import java.util.Objects;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int count;

    public Product(String name, double price, int count) {
        this.id = GeneratorId.getRandomId();
        setName(name);
        setPrice(price);
        setCount(count);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if (name.isBlank()
                && (name.length() < 8 || name.length() > 30)) {
            System.err.println("ERROR");
            return;
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0.1) {
            System.err.println("ERROR");
            return;
        }
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < 0) {
            System.err.println("ERROR");
            return;
        }
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getId() == product.getId() && Double.compare(getPrice(), product.getPrice()) == 0 && getCount() == product.getCount() && Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getCount());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
