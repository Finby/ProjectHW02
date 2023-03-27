package vit.homework.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name = "root")
public class XMLAgregated {

    @XmlElement(name = "universitiesInfo")
    UniversitiesXML universitiesXML;

    @XmlElement(name = "studentsInfo")
    StudentXML studentXML;

    @XmlElement(name = "statisticalInfo")
    StatisticXML statisticXML;

    @XmlElement(name = "reportDate")
    private String processedAt;

    public XMLAgregated() {
    }

    public XMLAgregated(UniversitiesXML universitiesXML, StudentXML studentXML, StatisticXML statisticXML) {
        this.universitiesXML = universitiesXML;
        this.studentXML = studentXML;
        this.statisticXML = statisticXML;
        this.processedAt = LocalDateTime.now().toString();
    }

}
