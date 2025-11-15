package domashka8_inkapsulation_OOPstudents.inkapsulation;

public class Book {

    private static int totalBooks = 0;
    private final int MAX_YEAR = 2026;
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;
    private int pageCount;


    public Book(String title, String author, int year, boolean isAvailable, int pageCount) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
        this.pageCount = pageCount;
    }

    public Book() {this("", "", -1);}

    public Book(String title, String author, int year) {
        this(title, author, year, false, 0);
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public String displayInfo() {
        return title + '_' + author + '_';
    }

    public String displayInfo(boolean detailed) {
        if (detailed) {
        return title + '_' + author + '_' + year + '_';}
        else {return displayInfo();}
    }

    public void borrowBook() {
        assert isAvailable; // нельзя выдать книгу которой нет
        isAvailable = false;
    }

    public void borrowBook(String borrowerName) {
        assert isAvailable;
        System.out.println(borrowerName);
        isAvailable = false;
    }

    public void returnBook() {
        assert !isAvailable; // нельзя вернуть книгу которая есть
        isAvailable = true;
    }

    public void updateYear(int newYear) {
        year = newYear;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        assert title.length() > 0;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        assert author.length() > 0;
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        assert year > 0 && year < MAX_YEAR;
        this.year = year;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        assert pageCount > 0;
        this.pageCount = pageCount;
    }



}