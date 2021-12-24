package controls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackupFiles {
    public static File ordir = new File("C:\\MyApp\\orDir\\");
    public static File copydir = new File("C:\\MyApp\\copyDir");
    List<File> list = new ArrayList<>();

    public BackupFiles() {
        if (!ordir.exists()) ordir.mkdir();
        if (!copydir.exists()) copydir.mkdir();
    }

    public void copyFiles() {
        getFileList();
        for (File file : list) {
                String path = file.getParent().replace(ordir.getAbsolutePath(), copydir.getAbsolutePath());
                Path copyPath = Paths.get(path, file.getName());
                try {
                    // мне надо будет удалять старый файл и копировать новый
                    if(!copyPath.toFile().exists()) Files.copy(file.toPath(), copyPath);
                    else {
                        copyPath.toFile().delete();
                        if(!copyPath.toFile().exists()) Files.copy(file.toPath(), copyPath);
                    }
                    if (!file.isDirectory()) Logger.getLogger().info("  OK     " + file.getAbsolutePath());
                } catch (IOException e) {
                    Logger.getLogger().info("  ERROR    " + file.getAbsolutePath());
                }
            }
    }

    // если директория, то создадим массив файлов из всех файлов в каталоге
    private List<File> getFileList() {
        File file = ordir;
        if (file.isDirectory()) {
            File[] filesArray = file.listFiles();
            // перевод массива в коллекцию
            // list.addAll(Arrays.asList(filesArray));
            // либо
            List <File> tmpList = Arrays.asList(filesArray);
            list.addAll(tmpList);
        }
        int j = 1;
        for (int i = 0; i < j; i++) {
            file = list.get(i);
            if (file.isDirectory()) {
                File[] filesArray = file.listFiles();
                List <File> tmpList = Arrays.asList(filesArray);
                list.addAll(tmpList);
            }
            j = list.size();
        }
        return null;
    }
}
