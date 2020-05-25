public class Book {
    private String title;
    private String author;
    private String language;
    private String genre;
    private Integer pages;
    private Integer rentalFee;

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
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", pages=" + pages +
                ", rentalFee=" + rentalFee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (language != null ? !language.equals(book.language) : book.language != null) return false;
        if (genre != null ? !genre.equals(book.genre) : book.genre != null) return false;
        if (pages != null ? !pages.equals(book.pages) : book.pages != null) return false;
        return rentalFee != null ? rentalFee.equals(book.rentalFee) : book.rentalFee == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (rentalFee != null ? rentalFee.hashCode() : 0);
        return result;
    }
}
