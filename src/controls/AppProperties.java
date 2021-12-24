package controls;

import java.io.*;
import java.util.Properties;

public class AppProperties {
    private Properties prop;
    private Logger logger = Logger.getLogger();
    private File  propFile;

    public AppProperties() {
        try {
            prop  = new Properties();
            propFile = new File("prop.properties");
            if (!propFile.exists()) propFile.createNewFile();
            prop.load(new FileReader("prop.properties"));
        } catch (FileNotFoundException e) {
            logger.info("FileNotFoundException");
        } catch (IOException e) {
            logger.info("IOException");
        }
    }

    public Properties getProp() {
        return prop;
    }

    public void setAtr() {
        // запись объекта в файл
        try {
            prop.store(new FileWriter(propFile), null);
        } catch (IOException e) {
            logger.info("File properties don't write");
        }
    }
}
