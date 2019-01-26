package net.cheltsov.sphere.action;

import net.cheltsov.sphere.entity.Point;
import net.cheltsov.sphere.entity.Sphere;
import net.cheltsov.sphere.exception.SphereException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SphereActionTest {

    private Sphere sphere;
    private Point point;

    @BeforeClass
    public void init() {
        sphere = new Sphere();
    }

    @Test
    public void testIsSphereTrue() {
        sphere.setRadius(10);
        Assert.assertTrue(SphereAction.isSphere(sphere));
    }

    @Test
    public void testIsSphereZeroFalse() {
        sphere.setRadius(0);
        Assert.assertFalse(SphereAction.isSphere(sphere), "r = 0, it is not a sphere");
    }

    @Test
    public void testIsSphereNullFalse() {
        Assert.assertFalse(SphereAction.isSphere(null), "null is not a sphere");
    }

    @DataProvider(name = "dataProviderForIsTouchMethod")
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {0, 6, 20, 6},
                {5, 10, 0, 5},
                {10, -15, 0, 15},
                {3, 4, 0, 5},
                {0, -3, -4, 5},
                {3, 0, -4, 5}
        };
    }

    @Test(dataProvider = "dataProviderForIsTouchMethod")
    public void testIsTouchParametersTrue(int x, int y, int z, int radius) {
        point = new Point(x, y, z);
        sphere.setPoint(point);
        sphere.setRadius(radius);
        Assert.assertTrue(SphereAction.isTouch(sphere), "Is not true as expected");
    }

}








