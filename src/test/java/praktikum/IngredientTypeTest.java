package praktikum;

import org.junit.Test;
import org.junit.Assert;

public class IngredientTypeTest {

    @Test
    public void testSauceExistence() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void testFillingExistence() {
        Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}