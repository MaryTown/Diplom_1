package praktikum;

import net.datafaker.Faker;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    static Faker faker = new Faker();
    private final String name = String.valueOf(faker.funnyName());
    private final float price = (float) faker.number().randomDigit();

    Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING, name, price);
    Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, name, price);

    @Test
    public void getIngredientPriceTest() {
        float actualPrice = ingredientFilling.getPrice();
        Assert.assertEquals(price, actualPrice, 0.0);
    }

    @Test
    public void getIngredientNameTest() {
        String actualName = ingredientFilling.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getFillingTypeTest() {
        IngredientType actualType = ingredientFilling.getType();
        Assert.assertEquals(IngredientType.FILLING, actualType);
    }

    @Test
    public void getSauceTypeTest() {
        IngredientType actualType = ingredientSauce.getType();
        Assert.assertEquals(IngredientType.SAUCE, actualType);
    }

}