package vit.homework.model.university;

public class UniversityComparatorByYearOfFoundation implements UniversityComparatorIntarface {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
