import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String language;
    private String genre;
    private Integer pages;
    public Integer rentalFee;

    public Book(String title, String author, String language, String genre, Integer pages, Integer rentalFee) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.genre = genre;
        this.pages = pages;
        this.rentalFee = rentalFee;
    }

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.language = "Unknown";
        this.genre = "Unknown";
        this.pages = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(Integer rentalFee) {
        this.rentalFee = rentalFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(language, book.language) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(pages, book.pages) &&
                Objects.equals(rentalFee, book.rentalFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, language, genre, pages, rentalFee);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", language='" + getLanguage() + '\'' +
                ", genre='" + getGenre() + '\'' +
                ", pages=" + getPages() +
                '}';
    }
}
