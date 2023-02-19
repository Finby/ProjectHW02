package vit.homework.model.university;

import org.apache.commons.lang3.StringUtils;

public class UniversityComparatorById implements UniversityComparatorIntarface {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getId(), o2.getId());
    }
}
