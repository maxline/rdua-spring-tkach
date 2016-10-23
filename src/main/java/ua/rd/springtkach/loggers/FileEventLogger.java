package ua.rd.springtkach.loggers;

import org.apache.commons.io.FileUtils;
import ua.rd.springtkach.beans.Event;

import java.io.File;
import java.io.IOException;

/**
 * @author Sergey Mikhluk.
 */
public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger() {
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException{
        this.file = new File(fileName);
        this.file.canWrite();
    }
}
