package net.cheltsov.sphere.manager;

import net.cheltsov.sphere.entity.Point;
import net.cheltsov.sphere.entity.Sphere;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SpherePropertiesTest {
    Sphere sphere;
    SphereProperties sp;
    @BeforeClass
    public void init() {
        sphere = new Sphere(new Point(0, 10, 10), 5);
        sp = sphere.getSpereProperties();
    }
    @Test
    public void testCalculatePropertiesSquare() throws Exception {
        double squareExpected = 100.;

        Assert.assertEquals(sp.getSquare(), squareExpected, 0.001 , "Square was calculated incorrectly");
    }
    @Test
    public void testCalculatePropertiesVolume() throws Exception {
        double volumeExpected = 166.66667;
        Assert.assertEquals(sp.getVolume(), volumeExpected, 0.001, "Volume was calculated incorrectly");
    }
    @Test
    public void testCalculatePropertiesRatio() throws Exception {
        double ratioExpected = 1.;
        Assert.assertEquals(sp.getRatio(), ratioExpected, 0.001, "Ratio was calculated incorrectly");
    }

}