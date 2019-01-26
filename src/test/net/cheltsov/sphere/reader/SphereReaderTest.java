package net.cheltsov.sphere.reader;

import net.cheltsov.sphere.exception.SphereException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
//@Test(priority = 1) //Разкоментить если вылетит error с неизвестным символом (и закоментить обратно после первого запуска)
public class SphereReaderTest {
    public static List<String> stringListExpected = new ArrayList<>();
    public static List<String> stringListActual;
    public static String TEMP_FILE_NAME = "temp/tempData.txt";


    @BeforeTest(groups = "general")
    public void beforeTest() throws Exception{
        String[] data = {"1 -1-1 22 33",
                "44.5.5 55 664",
                "77 88f 99",
                "---11555",
                "sdfsad",
                "2 55 44 11",
                "3 -55 44 11",
                "4 00 04 40",
                "5 -70 80 4-2",
                "-88 80 09 4-3",
                "23 5 4 11"};
        File file = new File(TEMP_FILE_NAME);
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        for(String s: data) {
            stringListExpected.add(s);
            fw.write(s + System.lineSeparator());
        }
        fw.close();
    }

    @Test(groups = "general")
    public void testReadStrings() throws SphereException {
        stringListActual = SphereReader.readStrings(TEMP_FILE_NAME);
        assertEquals(stringListExpected, stringListActual, "Data was read not correct");
    }
    @Test(expectedExceptions = SphereException.class, expectedExceptionsMessageRegExp = "Argument is null")
    public void testReadStringNullArgumentException() throws Exception {
        SphereReader.readStrings(null);
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testReadStringFileNotFoundException() throws Exception {
        SphereReader.readStrings("There_is_not_a_file");
    }


}