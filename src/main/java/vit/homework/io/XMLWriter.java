package vit.homework.io;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vit.homework.model.xml.XMLAgregated;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLWriter {
    static {
        System.setProperty("log4j.configurationFile", "src/main/java/vit/homework/resources/log4j2.xml");
    }
    private static final Logger log = LogManager.getLogger(XMLWriter.class);

    public static void writeToFile(Marshaller marshaller, XMLAgregated xmlAgregated, String filePath) {
        log.log(Level.INFO, "XMLWriter.writeToFile() - Starting.");

        FileOutputStream outputStream = null;
        try {
            File file = new File(filePath);
            file.createNewFile();
            outputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            marshaller.marshal(xmlAgregated, outputStream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        log.log(Level.INFO, "XMLWriter.writeToFile() - Successfully ended.");
    }
}
