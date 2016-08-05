package project.util;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by nsokh on 8/2/16.
 */
public class DataProviders {

    @DataProvider(name = "getJson")
    public static Iterator<Object[]> remoteServiceDataProvider() throws ParseException, IOException {

        Collection<Object[]> dp = new ArrayList<Object[]>() {
            {
                BufferedReader br = new BufferedReader(new FileReader("/Users/nsokh/hillel/TEstAutomationForYandex/src/test/resources/likes140.json"));
                try {
                    String line = br.readLine();
                    while (line != null) {
                        add(new Object[]{line});
                        line = br.readLine();
                    }
                } finally {
                    br.close();
                }
            }
        };

        return dp.iterator();
    }
}

//            DataSource sourceAnnotation = m.getAnnotation(DataSource.class);
//            final String jsonFile = sourceAnnotation.json();
