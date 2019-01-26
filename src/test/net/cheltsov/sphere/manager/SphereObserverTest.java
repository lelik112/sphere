package net.cheltsov.sphere.manager;

import net.cheltsov.sphere.entity.Sphere;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SphereObserverTest {
    Sphere sphere = new Sphere(10);
    SphereObserver observer;
    @BeforeClass
    public void init() {
        observer = SphereObserver.getSphereObserver();
    }
    @Test
    public void testGetSphereObserverSame() throws Exception {
        SphereObserver anotherObserver = SphereObserver.getSphereObserver();
        Assert.assertTrue(observer == anotherObserver, "Observer is not a singleton");
    }

    @Test
    public void testHandleEvent() throws Exception {
        SphereProperties properties = observer.getSphereProperties(sphere);
        double squareBeforeChange = properties.getSquare();
        sphere.setRadius(20);
        double squareAfterChange = properties.getSquare();
        Assert.assertNotEquals(squareBeforeChange, squareAfterChange, 1.);
    }

    @Test
    public void testGetSphereProperties() throws Exception {
        SphereProperties properties = observer.getSphereProperties(sphere);
        Assert.assertNotNull(properties);
    }


}