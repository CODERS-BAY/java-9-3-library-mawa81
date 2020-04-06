import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Person {

    public String name;
    public List<Loan> loans;
    public LocalDate borrowed;
    public LocalDate returned;
    public Integer credits;

    public Person(String name) {
        this.name = name;
        this.loans = new ArrayList<>();
        this.borrowed = null;
        this.returned = null;
        this.credits = 0;
    }

/*    public Person(String name, List<Book> rentalBooks, Date borrowed, Date returned, Integer credits) {
        this.name = name;
        this.rentalBooks = rentalBooks;
        this.borrowed = borrowed;
        this.returned = returned;
        this.credits = credits;
    }*/

    public void rents(Book book, String borrowed) {
        if (credits >= 5) {
            this.loans.add(new Loan(book, LocalDate.parse(borrowed), null));

        } else {
            System.out.println("You have top up your credits!");
        }
    }

    public void returns(Book book, String returned) {
        if (credits >= 5) {
            Loan loan = new Loan(loans.get(loans.indexOf(book)));
            this.returned = LocalDate.parse(returned);
            Integer rentalDays = Math.toIntExact(getDifferenceDays(loan.getReturned(), this.returned));
            this.loans.remove(loans.contains(book));
            System.out.println("rentalDays" + rentalDays);
            this.credits -= (rentalDays * book.rentalFee);
        } else {
            System.out.println("You have top up your credits!");
        }
    }

    public void addCredits(Integer addCredits) {
        this.credits += addCredits;
    }

    private Long getDifferenceDays(LocalDate d1, LocalDate d2) {
        Long diff = DAYS.between(d1, d2);
        // Long diff = d2.getTime() - d1.getTime();
        return diff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(loans, person.loans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loans);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", loans=" + loans +
                ", borrowed=" + borrowed +
                ", returned=" + returned +
                ", credits=" + credits +
                '}';
    }
}
