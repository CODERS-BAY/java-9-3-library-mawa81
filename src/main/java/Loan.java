import java.time.LocalDate;

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
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", borrowed=" + borrowed +
                ", returned=" + returned +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        if (book != null ? !book.equals(loan.book) : loan.book != null) return false;
        if (borrowed != null ? !borrowed.equals(loan.borrowed) : loan.borrowed != null) return false;
        return returned != null ? returned.equals(loan.returned) : loan.returned == null;
    }

    @Override
    public int hashCode() {
        int result = book != null ? book.hashCode() : 0;
        result = 31 * result + (borrowed != null ? borrowed.hashCode() : 0);
        result = 31 * result + (returned != null ? returned.hashCode() : 0);
        return result;
    }
}
