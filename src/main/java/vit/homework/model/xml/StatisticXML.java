package vit.homework.model.xml;

import vit.homework.model.statistic.Statistic;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class StatisticXML {

    @XmlElement(name = "statisticsEntry")
    private ArrayList<Statistic> statisticArrayList;

    public StatisticXML(ArrayList<Statistic> statisticArrayList) {
        this.statisticArrayList = statisticArrayList;
    }

    public StatisticXML() {
    }
}
