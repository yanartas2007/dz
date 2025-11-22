package Classwork_Task_6_ООП;

public class Book {

    private String title;
    private String author;
    private int year;
    private boolean isAvailable;
    private int pageCount;


    public Book(String title, String author, int year, boolean isAvailable, int pageCount){
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
        this.pageCount = pageCount;
    }

    public Book() {
        this("","",-1);
    }

    public Book(String title, String author, int year) {
        this(title, author, year, false,0);
    }


    public String displayInfo(){
        return title + '_' + author + '_' + year + '_';
    }

    public void borrowBook(){
        assert isAvailable; // нельзя выдать книгу которой нет
        isAvailable = false;
    }

    public void returnBook(){
        assert !isAvailable; // нельзя вернуть книгу которая есть
        isAvailable = true;
    }

    public void updateYear(int newYear){
        year = newYear;
    }
}