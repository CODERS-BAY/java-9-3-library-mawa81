import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Person> persons;
    private List<Book> books;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

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

    @Override
    public String toString() {
        return "Library{" +
                "persons=" + persons +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (persons != null ? !persons.equals(library.persons) : library.persons != null) return false;
        return books != null ? books.equals(library.books) : library.books == null;
    }

    @Override
    public int hashCode() {
        int result = persons != null ? persons.hashCode() : 0;
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}
