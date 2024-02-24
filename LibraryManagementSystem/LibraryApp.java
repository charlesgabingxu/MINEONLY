import java.util.ArrayList;

interface LibraryItem {
    void borrowItem();

    void returnItem();

    boolean isBorrowed();
}

class Book implements LibraryItem {
    private String title;
    private String author;
    private boolean borrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        borrowed = true;
        System.out.println("The Book \"" + title + "\" has been borrowed by a user.");
    }

    @Override
    public void returnItem() {
        borrowed = false;
        System.out.println("The Book \"" + title + "\" has returned to the library by a user.");
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

class DVD implements LibraryItem {
    private String title;
    private String director;
    private boolean borrowed;

    public DVD(String title, String director) {
        this.title = title;
        this.director = director;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        borrowed = true;
        System.out.println("The DVD \"" + title + "\" has been borrowed by a user.");
    }

    @Override
    public void returnItem() {
        borrowed = false;
        System.out.println("The DVD \"" + title + "\" has returned to the library by a user.");
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return title + " (The Director: " + director + ")";
    }
}

abstract class LibraryUser {
    abstract void borrowItem(LibraryItem item);

    abstract void returnItem(LibraryItem item);

    abstract void printItemsBorrowed();
}

class Student extends LibraryUser {
    private ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    @Override
    void borrowItem(LibraryItem item) {
        item.borrowItem();
        borrowedItems.add(item);
    }

    @Override
    void returnItem(LibraryItem item) {
        item.returnItem();
        borrowedItems.remove(item);
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("Student Borrowed Items:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.toString());
        }
    }
}

class Teacher extends LibraryUser {
    private ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    @Override
    void borrowItem(LibraryItem item) {
        item.borrowItem();
        borrowedItems.add(item);
    }

    @Override
    void returnItem(LibraryItem item) {
        item.returnItem();
        borrowedItems.remove(item);
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("Teacher Borrowed Items:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.toString());
        }
    }
}

public class LibraryApp {
    public static void showInformation() {
        Book BOOK1 = new Book("Noli Me Tangere", "Jose Rizal");
        DVD DVD1 = new DVD("Wall-E", "Andrew Stanton");

        Student student1 = new Student();
        Teacher teacher1 = new Teacher();

        System.out.println("Borrowed Items");
        student1.borrowItem(BOOK1);
        teacher1.borrowItem(DVD1);

        System.out.println("\nLibrary Management System");
        student1.printItemsBorrowed();
        teacher1.printItemsBorrowed();

        System.out.println("\nReturned Borrowed Items");
        student1.returnItem(BOOK1);
        teacher1.returnItem(DVD1);

        System.out.println("\nLibrary Management System");
        student1.printItemsBorrowed();
        teacher1.printItemsBorrowed();
    }
}
