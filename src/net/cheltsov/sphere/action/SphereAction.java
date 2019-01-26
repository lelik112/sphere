package net.cheltsov.sphere.action;


import net.cheltsov.sphere.entity.Sphere;
import net.cheltsov.sphere.exception.SphereException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereAction {

    public static boolean isSphere(Sphere sphere) {
        if(sphere == null) {
            return false;
        }
        return (sphere.getRadius() > 0);
    }

    public static boolean isTouch(Sphere sphere) {
        if(sphere == null) {
            return false;
        }
        double distanceX = Math.hypot(sphere.getPoint().getY(), sphere.getPoint().getZ());
        double distanceY = Math.hypot(sphere.getPoint().getX(), sphere.getPoint().getZ());
        double distanceZ = Math.hypot(sphere.getPoint().getX(), sphere.getPoint().getY());
        return (distanceX == sphere.getRadius() || distanceY == sphere.getRadius() || distanceZ == sphere.getRadius());
    }
}
