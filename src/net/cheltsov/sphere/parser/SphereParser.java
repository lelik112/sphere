package net.cheltsov.sphere.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SphereParser {
    private static final String REGEX = "([-]?[\\d]++)[^\\d-]*([-]?[\\d]++)[^\\d-]*([-]?[\\d-]++)[\\D]+([\\d]++)";
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final int SIZE_ARRAY_DATA = 4;

    public static List<int[]> parse(List<String> listStringData) {
        List<int[]> intList = new ArrayList<>();
        if(listStringData == null) {
            LOGGER.log(Level.WARN, "There was a null in argument. No one string was parsed");
            return intList;
        }
        Pattern par = Pattern.compile(REGEX);
        Matcher mat;
        ListIterator<String> it = listStringData.listIterator();
        while (it.hasNext()) {
            mat = par.matcher(it.next());
            if (mat.find()) { //Вот тут происходит валидация. Какой смысл создавать отдельный метод или класс и повторять код?
                int[] arrayData = new int[SIZE_ARRAY_DATA];
                for (int i = 0; i < arrayData.length; i++) {
                    arrayData[i] = Integer.parseInt(mat.group(i + 1));
                }
                intList.add(arrayData);
            } else {
                LOGGER.log(Level.WARN, "Data from listStringData[" + it.previousIndex() +
                "] is not correct and string was not parsed");
            }
        }
        LOGGER.log(Level.INFO, "Number of " + intList.size() +
                " were parsed and added to intList");
        return intList;
    }
}
