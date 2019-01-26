package net.cheltsov.sphere.reader;

import net.cheltsov.sphere.exception.SphereException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SphereReader {
    public static final String DEFAULT_FILE_NAME = "data/data.txt";
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static List<String> readStrings() throws SphereException {
        return readStrings(DEFAULT_FILE_NAME);
    }

    public static List<String> readStrings(String fileName) throws SphereException {
        if(fileName == null) {
            throw new SphereException("Argument is null");
        }
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                stringList.add(br.readLine());
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FATAL, "File not found", e);
            throw new RuntimeException("Fie not found", e);
        } catch (IOException e) {
            throw new SphereException("Problem with reading from file", e);
        }
        LOGGER.log(Level.INFO, "Number of " + stringList.size() + " were read and added to stringList");
        return stringList;
    }

}
