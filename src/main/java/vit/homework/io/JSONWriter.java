package vit.homework.io;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vit.homework.model.xml.XMLAgregated;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class JSONWriter {
    static {
        System.setProperty("log4j.configurationFile", "src/main/java/vit/homework/resources/log4j2.xml");
    }
    private static final Logger log = LogManager.getLogger(JSONWriter.class);


    public static void writeToFile(String outputData, String filePath) {
        log.log(Level.INFO, "JSONWriter.writeToFile() - Starting.");
        if (filePath == null) {
            File dirXML = new File("./src/main/java/vit/homework/resources/jsonReqs");
            if (!dirXML.exists())
                dirXML.mkdirs();
            String date = LocalDate.now().toString();
            try {
                filePath = Path.of(dirXML.getCanonicalPath(), "req" + date + ".json").toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        FileOutputStream outputStream = null;
        try {
//            File file = new File(filePath);
//            file.createNewFile();
            Files.write(Path.of(filePath), outputData.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        log.log(Level.INFO, "JSONWriter.writeToFile() - Successfully ended.");
    }
}
