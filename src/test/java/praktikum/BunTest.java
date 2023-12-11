package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }


    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][]{
                {"Название булочки 1", 20},
                {"Название булочки 2", -202839.2F},
                {"Название булочки 3", 0.01f},
                {"Название булочки 4", Float.MAX_VALUE},
                {null, 24},
                {"", 201},
                {"sadfh433sfs&6ef;'pFHj6^%", -20}
        };
    }

    @Test
    public void testGetBunName() {
        Bun bun = new Bun(expectedName, expectedPrice);
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun(expectedName, expectedPrice);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.0);
    }

}