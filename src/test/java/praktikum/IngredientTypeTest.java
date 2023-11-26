package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameters
    public static IngredientType[] data() {
        return IngredientType.values();
    }

    @Parameterized.Parameter
    public IngredientType ingredientType;

    @Test
    public void testIngredientType() {
        Assert.assertEquals(ingredientType.toString(), ingredientType.name());
        Assert.assertEquals(ingredientType.ordinal(), IngredientType.valueOf(ingredientType.name()).ordinal());
    }
}