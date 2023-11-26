package praktikum;

import net.datafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        Assert.assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void removeIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient1));
        Assert.assertFalse(burger.ingredients.contains(ingredient1));
        Assert.assertTrue(burger.ingredients.contains(ingredient2));
    }

    @Test
    public void moveIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, burger.ingredients.indexOf(ingredient2));
        Assert.assertEquals(0, burger.ingredients.indexOf(ingredient2));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Faker faker = new Faker();
        Mockito.when(bun.getPrice()).thenReturn((float) faker.number().randomDigit());
        Mockito.when(ingredient1.getPrice()).thenReturn((float) faker.number().randomDigit()); //гугл говорит, что преобразование происходит автоматически, но с потерей точности
        Mockito.when(ingredient2.getPrice()).thenReturn((float) faker.number().randomDigit());

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Faker faker = new Faker();
        Mockito.when(bun.getName()).thenReturn(String.valueOf(faker.funnyName()));
        Mockito.when(bun.getPrice()).thenReturn((float) faker.number().randomDigit());

        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn(String.valueOf(faker.funnyName()));
        Mockito.when(ingredient1.getPrice()).thenReturn((float) faker.number().randomDigit());

        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn(String.valueOf(faker.funnyName()));
        Mockito.when(ingredient2.getPrice()).thenReturn((float) faker.number().randomDigit());

        String actualReceipt = burger.getReceipt();

        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()) +
                String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}