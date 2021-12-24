package controls;

import java.io.*;
import java.util.Date;

public class Logger {
    // делаем из класса синглтон, чтобы можно было создать только один объект этого класса
    static Logger logger;
    private Logger() {}
    File file = new File("logger.log");



    // реализация синглтона
    public static Logger getLogger() {
        if (logger==null) logger = new Logger();
        return logger;
    }

    public void info (String message) {

        try (FileWriter fw = new FileWriter(file, true)) {
             // проверка на существование файла
             if(!file.exists()) file.createNewFile();
             Date date = new Date(System.currentTimeMillis());
             fw.write("\n" + date + ": " + message);
        } catch (IOException e) {
                System.out.println("Error creating logfile");
        }
    }

    public String getTextLoger() {
        String string = "";
        char[] buffer = new  char[1024];
        try(FileReader fr = new FileReader(file)) {
            while (fr.read(buffer) != -1){
                string += new String(buffer);
            }
        }catch (IOException e) {
            System.out.println("Error reading log file.");
        }
        return string;
    }
}

