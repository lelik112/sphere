package net.cheltsov.sphere.parser;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static net.cheltsov.sphere.reader.SphereReaderTest.stringListActual;
import static org.testng.Assert.*;
//@Test(priority = 2) //Разкоментить если вылетит error с неизвестным символом (и закоментить обратно после первого запуска)
public class SphereParserTest {
    public static List<int[]> intListExpected = new ArrayList<>();
    public static List<int[]> intListActual;
    @BeforeClass(groups = "general")
    public void init() {
        int[][] data = {{1, -1, -1, 22},
                {44, 5, 5, 55},
                {2, 55, 44, 11},
                {3, -55, 44, 11},
                {4, 0, 4, 40},
                {5, -70, 80, 4},
                {-88, 80, 9, 4},
                {23, 5, 4, 11}
        };
        for (int[] k: data) {
            intListExpected.add(k);
        }
    }
    @Test(groups = "general")
    public void testParse() throws Exception {
        intListActual = SphereParser.parse(stringListActual);
        assertEquals(intListExpected, intListActual);
    }
    @Test()
    public void testParseNullArgumentEmptyList() {
        List<int[]> intListActual = SphereParser.parse(null);
        if(intListActual == null) {
            Assert.fail("Method returned null");
        }
        Assert.assertTrue(intListActual.isEmpty(), "list is not empty");
    }

}