package vit.homework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vit.homework.model.xml.XMLAgregated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class Converters {

    public static XMLAgregated convertXmlToObject(InputStream in) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(XMLAgregated.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (XMLAgregated) unmarshaller.unmarshal(in);
    }

    public static String convertObjectToJsonString(XMLAgregated input) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .serializeSpecialFloatingPointValues()
                .create();

        return gson.toJson(input);
    }
}
