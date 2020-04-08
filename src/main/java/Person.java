import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Person {

    public String name;
    public List<Loan> loansActually;
    public List<Loan> loansHistory;
    public LocalDate borrowed;
    public LocalDate returned;
    public Integer credits;

    public Person(String name) {
        this.name = name;
        this.loansActually = new ArrayList<>();
        this.loansHistory = new ArrayList<>();
        this.borrowed = null;
        this.returned = null;
        this.credits = 0;
    }

    public void rents(Book book, String borrowed) {
        //is the book in the loanlist?
        Loan loan = null;
        loan = setLoanifthisBookisinLoanlist(book, loan);

        if (loan == null) {
            if (credits >= 5) {
                this.loansActually.add(new Loan(book, LocalDate.parse(borrowed), null));

            } else {
                System.out.println("This loan is not possible! You have to top up your credits!");
            }
        } else {
            System.out.println("This entry is wrong! This book is already in your booklist!");
        }
    }

    public void returns(Book book, String returned) {
        //is the book in the loanlist?
        Loan loan = null;
        loan = setLoanifthisBookisinLoanlist(book, loan);

        if (loan != null) {

            if (credits >= 5) {
                this.loansActually.remove(loan);
                this.returned = LocalDate.parse(returned);

                //copy the returned loan to a history list
                loan.setReturned(this.returned);
                this.loansHistory.add(loan);

                Integer rentalDays = Math.toIntExact(getDifferenceDays(loan.getBorrowed(), this.returned));

                System.out.println("returning Book: " + book.getTitle() + " --> rental Days: " + rentalDays);
                this.credits -= (rentalDays * book.rentalFee);
            } else {
                System.out.println("Returning \"" + book.getTitle() + "\" is not possible! You have to top up your credits!");
            }
        } else {
            System.out.println("This entry is wrong! This book is not in your booklist!");
        }
    }

    private Loan setLoanifthisBookisinLoanlist(Book book, Loan loan) {
        for (int i = 0; i < loansActually.size(); i++) {
            if (loansActually.get(i).getBook().equals(book)) {
                loan = loansActually.get(i);
            }
        }
        return loan;
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
        return Objects.equals(loansActually, person.loansActually);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loansActually);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", loans=" + loansActually +
                ", credits=" + credits +
                '}';
    }
}
