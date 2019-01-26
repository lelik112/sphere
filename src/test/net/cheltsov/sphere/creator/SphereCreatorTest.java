package net.cheltsov.sphere.creator;

import net.cheltsov.sphere.entity.Point;
import net.cheltsov.sphere.entity.Sphere;
import net.cheltsov.sphere.manager.SphereProperties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static net.cheltsov.sphere.parser.SphereParserTest.intListActual;
import static net.cheltsov.sphere.reader.SphereReaderTest.TEMP_FILE_NAME;
//@Test(priority = 3)  //Разкоментить если вылетит error с неизвестным символом (и закоментить обратно после первого запуска)
public class SphereCreatorTest {
    public static List<Sphere> sphereListActual;
    @Test(groups = "general")
    public void testCreate() throws Exception {
        int sizeExpected = 8;
        sphereListActual = SphereCreator.create(intListActual);
        int sizeActual = sphereListActual.size();
        Assert.assertEquals(sizeExpected, sizeActual);
    }
    @AfterTest(groups = "general")
    public void destroy() {
        File file = new File(TEMP_FILE_NAME);
        file.delete();
    }

    @Test
    public void testCreateNullArgumentEmptyList() {
        List<Sphere> sphereListActual = SphereCreator.create(null);
        if(sphereListActual == null) {
            Assert.fail("Method returned null");
        }
        Assert.assertTrue(sphereListActual.isEmpty(), "list is not empty");
    }

    @Test
    public void testCreateIncorrectData() {
        int[][] data = {{1, -1, -1},
                {44, 5, 5, -55},
                {2, 55, 44, 0},
                {3, -20, 44, 11},
                {3, -55, 44, 11, 3},
                {3, 44, 11, -3},
                {3, 11},
        };
        List<int[]> listInt = new ArrayList<>();

        for (int[] k: data) {
            listInt.add(k);
        }
        List<Sphere> sphereList = SphereCreator.create(listInt);
        List<SphereProperties> propertiesListActual = new ArrayList<>();
        for(Sphere s:sphereList) {
            propertiesListActual.add(s.getSpereProperties());
        }
        List<SphereProperties> propertiesListExpected = new ArrayList<>();
        propertiesListExpected.add(new Sphere(new Point(2, 55, 44), 0).getSpereProperties());
        propertiesListExpected.add(new Sphere(new Point(3, -20, 44), 11).getSpereProperties());
        Assert.assertEquals(propertiesListActual, propertiesListExpected, "something went wrong");

    }
}