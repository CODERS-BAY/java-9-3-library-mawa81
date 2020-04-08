import java.util.ArrayList;
import java.util.List;

public class Library {

    public List<Person> persons;
    public List<Book> books;

    public Library() {
        this.persons = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public void removePerson(Person person) {
        this.persons.remove(person);
    }

    public List<Person> getAllPersons() {
        return persons;
    }

    public void setAllPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void setAllBooks(List<Book> books) {
        this.books = books;
    }

}
