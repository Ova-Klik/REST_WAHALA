import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class BookSuggestion1 {

    private final List<Book> bookStore;
    private Random rand = new Random();

    public BookSuggestion1() {
        this.bookStore = new ArrayList<>();
    }

    public Book suggestBook(){
        if(bookStore.isEmpty()) return null;
        int randomBookIndex = rand.nextInt(bookStore.size());
        Book randomBook= bookStore.get(randomBookIndex);
        int pages = Integer.parseInt(randomBook.getNumberOfPages());
        int randomPage = rand.nextInt(pages) + 1;
        randomBook.setSuggestedPage(randomPage);

        return randomBook;
    }

    public boolean addBook(Book book) {
        if(hasBook(book)) return false;
        if(book != null){
            bookStore.add(book);
            return true;
        }
        return false;
    }

    public boolean hasBook(Book book){
        if(bookStore.contains(book)) return true;
        return false;
    }

    public boolean removeBook(String title) {
        Book book = getBookByTitle(title);
        if(book!=null){
            bookStore.remove(book);
            return true;
        }
        return false;
    }

    public Book getBookByTitle(String title){
        for(Book book : bookStore){
            if(book.getTitle().equalsIgnoreCase(title)) return book;
        }
        return null;
    }

    public boolean updateBook(String oldBookTitle, String newBookTitle){
        Book book = getBookByTitle(oldBookTitle);
        if(book!=null){
            book.setTitle(newBookTitle);
            return true;
        }
        return false;
    }

    public List<Book> getAllBooks() {
        return bookStore;
    }


}
