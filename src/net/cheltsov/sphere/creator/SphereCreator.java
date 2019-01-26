package net.cheltsov.sphere.creator;

import net.cheltsov.sphere.entity.Point;
import net.cheltsov.sphere.entity.Sphere;
import net.cheltsov.sphere.exception.SphereException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SphereCreator {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static List<Sphere> create(List<int[]> listIntData) {
        ArrayList<Sphere> sphereList = new ArrayList<>();
        if(listIntData == null) {
            LOGGER.log(Level.WARN, "There was a null in argument. No one sphere was created");
            return sphereList;
        }

        ListIterator<int[]> it = listIntData.listIterator();
        while (it.hasNext()) {
            int [] array = it.next();
            if(validate(array)) {
                Point point = new Point(array[0], array[1], array[2]);
                Sphere sphere = new Sphere(point, array[3]);
                sphereList.add(sphere);
            } else {
                LOGGER.log(Level.WARN, "Data from listIntData[" + it.previousIndex() +
                        "] is not correct. Sphere was not created");
            }
        }
        LOGGER.log(Level.INFO, "Number of " + sphereList.size() + " were created and added to sphereList");
        return sphereList;
    }
    //дополнительая валидация так как метод может быть вызван с данными не прошедшими через SphereParser

    public static boolean validate(int[] data) { //public на случай если где нибудь еще понадобится
        return data != null && data.length == 4 && data[3] >= 0;
    }
}
