package bo;

import entity.Fruit;
import utils.Validation;

public class FruitInputer {
    private Fruit fruit;

    public FruitInputer() {
        fruit = new Fruit();
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public void inputFruitInformation() {
        fruit.setId(-1);
        fruit.setName(Validation.getString("Enter fruit name: ",
                Validation.NAME_PATTERN,
                "Invalid input, input must be fruit name"
                )
        );

        fruit.setPrice(Validation.getDouble("Enter price: ",
                Double.MIN_VALUE,
                Double.MAX_VALUE
                )
        );

        fruit.setQuantity(Validation.getInt("Enter quantity: ",
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
                ));

        fruit.setOrigin(Validation.getString("Enter Origin: "));
    }
}
