package Comparator;

class SortbyDate implements Comparator<Date> {
    public int compare(Date p1, Date p2) {
        return p1.getDate().compareTo(p2.getDate());
    }
}