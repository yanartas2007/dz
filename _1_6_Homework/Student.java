package _1_6_Homework;

public class Student implements Comparable<Student>{
    private String name;
    private double rating;
    private int missedClasses;

    public Student(String name , double rating, int missedClasses) {
        setName(name);
        setRating(rating);
        setMissedClasses(missedClasses);
    }

    public Student() {
        this("имя", 100.0, 0);
    }

    public String toString() {
        return getName() + " " + getRating() + " " + getMissedClasses();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getMissedClasses() {
        return missedClasses;
    }

    public void setMissedClasses(int missedClasses) {
        this.missedClasses = missedClasses;
    }

    @Override
    public int compareTo(Student s) {
        if (Integer.compare(missedClasses, s.missedClasses) == 0) {
            if (Double.compare(rating, s.rating) == 0) {
                return CharSequence.compare(name, s.name); // сначала написал String.compare, но среде не понравилось, она исправила на такое
            }
            else {return Double.compare(rating, s.rating);}
        }
        else {return Integer.compare(missedClasses, s.missedClasses);}
    }
}
