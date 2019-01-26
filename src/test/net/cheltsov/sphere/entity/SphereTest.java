package net.cheltsov.sphere.entity;


import org.testng.annotations.Test;


public class SphereTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetRadiusNegativeNumberException() {
        Sphere sphere = new Sphere();
        sphere.setRadius(-1);
    }

}
