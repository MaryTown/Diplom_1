package praktikum;

import net.datafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    static Faker faker = new Faker();

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getDataIngredients() {
        return new Object[][]{
                {IngredientType.FILLING, String.valueOf(faker.funnyName()), (float) faker.number().randomDigit()},
                {IngredientType.SAUCE, String.valueOf(faker.funnyName()), (float) faker.number().randomDigit()}
        };
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0.0);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(type, actualType);
    }
}