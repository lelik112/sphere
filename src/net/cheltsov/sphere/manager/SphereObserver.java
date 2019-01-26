package net.cheltsov.sphere.manager;

import net.cheltsov.sphere.entity.Sphere;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class SphereObserver {
    private static SphereObserver instanse;
    private static final Logger LOGGER = LogManager.getRootLogger();

    private HashMap<Sphere, SphereProperties> sphereMap;
    private SphereObserver() {
        sphereMap = new HashMap<>();
    }

    public static SphereObserver getSphereObserver() {
        if (instanse == null) {
            instanse = new SphereObserver();
            LOGGER.log(Level.INFO, "Singeltone SphereObserver was created");
        }
        return instanse;
    }

    public void handleEvent(Sphere sphere) {
        if(sphere == null) {
            return;
        }
        SphereProperties sphereProperties = sphereMap.putIfAbsent(sphere, new SphereProperties(sphere));
        if(sphereProperties != null) {
            sphereProperties.calculateProperties(sphere);
        }
    }

    public SphereProperties getSphereProperties(Sphere sphere) {
        return sphereMap.get(sphere);
    }
}
