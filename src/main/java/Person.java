import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Person {

    private String name;
    private List<Loan> loansActually;
    private List<Loan> loansHistory;
    private LocalDate borrowed;
    private LocalDate returned;
    private Integer credits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoansActually() {
        return loansActually;
    }

    public void setLoansActually(List<Loan> loansActually) {
        this.loansActually = loansActually;
    }

    public List<Loan> getLoansHistory() {
        return loansHistory;
    }

    public void setLoansHistory(List<Loan> loansHistory) {
        this.loansHistory = loansHistory;
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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

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
                this.credits -= (rentalDays * book.getRentalFee());
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", loansActually=" + loansActually +
                ", loansHistory=" + loansHistory +
                ", borrowed=" + borrowed +
                ", returned=" + returned +
                ", credits=" + credits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (loansActually != null ? !loansActually.equals(person.loansActually) : person.loansActually != null)
            return false;
        if (loansHistory != null ? !loansHistory.equals(person.loansHistory) : person.loansHistory != null)
            return false;
        if (borrowed != null ? !borrowed.equals(person.borrowed) : person.borrowed != null) return false;
        if (returned != null ? !returned.equals(person.returned) : person.returned != null) return false;
        return credits != null ? credits.equals(person.credits) : person.credits == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (loansActually != null ? loansActually.hashCode() : 0);
        result = 31 * result + (loansHistory != null ? loansHistory.hashCode() : 0);
        result = 31 * result + (borrowed != null ? borrowed.hashCode() : 0);
        result = 31 * result + (returned != null ? returned.hashCode() : 0);
        result = 31 * result + (credits != null ? credits.hashCode() : 0);
        return result;
    }
}
