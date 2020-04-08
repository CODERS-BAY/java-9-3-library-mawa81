import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private Book book;
    private LocalDate borrowed;
    private LocalDate returned;

    public Loan(Book book, LocalDate borrowed, LocalDate returned) {
        this.book = book;
        this.borrowed = borrowed;
        this.returned = returned;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(LocalDate borrowed) {
        this.borrowed = borrowed;
    }

    public LocalDate getReturned() {
        return returned;
    }

    public void setReturned(LocalDate returned) {
        this.returned = returned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(book, loan.book) &&
                Objects.equals(borrowed, loan.borrowed) &&
                Objects.equals(returned, loan.returned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, borrowed, returned);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", borrowed=" + borrowed +
                ", returned=" + returned +
                '}';
    }

}
