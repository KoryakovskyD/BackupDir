package controls;

import views.MainFrame;

import java.util.Properties;

public class BackupDir {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.info("App start");
        AppProperties ap = new AppProperties();
        Properties prop = ap.getProp();
        // получить пару ключ значение из файла
        String orDir = prop.getProperty("orDir");
        String copyDir= prop.getProperty("copyDir");
        // записать пару ключ значение в файл
        prop.setProperty("key1", "value1");
        prop.setProperty("key2", "value2");
        ap.setAtr();
        //BackupFiles bf = new BackupFiles(orDir,copyDir);
        //bf.copyFiles();
        logger.info("App end");

        MainFrame mainFrame = new MainFrame();
    }
}
