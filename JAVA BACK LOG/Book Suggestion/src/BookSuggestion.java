import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookSuggestion {

    private BookSuggestion1 bookSystem;
    private Book hobbit;
    private Book animalFarm;

    @BeforeEach
    public void setUp() {
        bookSystem    = new BookSuggestion1();
        hobbit    = new Book("The Hobbit",  "J.R.R",  "Tolkien", "uncle T", "310");
        animalFarm = new Book("Animal Farm", "George", "Orwell", "G.O", "112");
    }


    @Test
    public void hasBook_shouldReturnFalse_whenBookDoesExist() {
        boolean result = bookSystem.hasBook(hobbit);
        assertFalse(result);
    }

    @Test
    public void hasBook_shouldReturnTrue_whenBookExist() {
        bookSystem.addBook(hobbit);
        boolean result = bookSystem.hasBook(hobbit);
        assertTrue(result);
    }

    @Test
    public void addBook_shouldReturnTrue_whenBookIsAdded() {
        boolean result = bookSystem.addBook(hobbit);
        assertTrue(result);
    }


    @Test
    public void addBook_shouldReturnFalse_whenBookIsDuplicate() {
        bookSystem.addBook(hobbit);
        boolean result = bookSystem.addBook(hobbit);
        assertFalse(result);
    }

    @Test
    public void getAllBooks_shouldReturnZero_whenBookStoreIsEmpty() {
        assertEquals(0, bookSystem.getAllBooks().size());
    }

    @Test
    public void addBook_shouldIncreaseBookStoreSize() {
        bookSystem.addBook(hobbit);
        bookSystem.addBook(animalFarm);
        assertEquals(2, bookSystem.getAllBooks().size());
    }

    @Test
    void getBookByTitle_shouldReturnNull_whenBookDoesNotExist() {
        Book result = bookSystem.getBookByTitle("Booker");
        assertEquals(null,result);
    }

    @Test
    void getBookByTitle_shouldReturnBook_whenBookExist() {
        bookSystem.addBook(hobbit);
        Book book = bookSystem.getBookByTitle("The HObbit");
        assertEquals(hobbit,book);
    }

    @Test
    public void removeBook_shouldReturnTrue_whenBookExists() {
        bookSystem.addBook(hobbit);
        boolean result = bookSystem.removeBook("The Hobbit");
        assertTrue(result);
    }

    @Test
    public void removeBook_shouldReturnTrue_whenBookExists_andCaseIsDifferent() {
        bookSystem.addBook(hobbit);
        boolean result = bookSystem.removeBook("the hobbit");
        assertTrue(result);
    }


    @Test
    public void removeBook_shouldReturnFalse_whenBookDoesNotExist() {
        bookSystem.addBook(hobbit);
        boolean result = bookSystem.removeBook("coder");
        assertFalse(result);
    }

    @Test
    public void removeBook_shouldDecreaseListSize() {
        bookSystem.addBook(hobbit);
        bookSystem.addBook(animalFarm);
        bookSystem.removeBook("The Hobbit");
        assertEquals(1, bookSystem.getAllBooks().size());
    }

    @Test
    public void updateBook_shouldReturnTrue_whenBookTitleIsUpdated() {
        bookSystem.addBook(hobbit);
        boolean result = bookSystem.updateBook("The Hobbit", "The Hobbit Returns");
        assertTrue(result);
    }


    @Test
    public void updateBook_shouldReturnFalse_whenUpdatedTitle_isDifferent_fromOldTitle() {
        bookSystem.addBook(hobbit);
        String oldBookTitle = hobbit.getTitle();
        boolean result = bookSystem.updateBook("The Hobbit", "The Hobbit Returns");
        assertNotEquals(oldBookTitle, hobbit.getTitle());
    }

    @Test
    public void updateBook_shouldReturnTrue_whenUpdatedTitle_isSameAsNewBookTitle() {
        bookSystem.addBook(hobbit);
        String oldBookTitle = hobbit.getTitle();
        boolean result = bookSystem.updateBook("The Hobbit", "The Hobbit Returns");
        assertEquals("The Hobbit Returns",hobbit.getTitle());
    }


    @Test
    public void suggestBook_shouldReturnNull_whenListIsEmpty() {
        Book result = bookSystem.suggestBook();
        assertEquals(null,result);

    }

    @Test
    public void suggestBook_shouldReturnBook_whenBookStoreIsNotEmpty() {
        bookSystem.addBook(hobbit);
        Book result = bookSystem.suggestBook();
        assertEquals(hobbit,result);
    }


    @Test
    public void suggestBook_shouldReturnBook_withSuggestedPageBetween1And100() {
        bookSystem.addBook(hobbit);
        Book book = bookSystem.suggestBook();
        assertTrue(book.getSuggestedPage() >= 1 && book.getSuggestedPage() <= 100);
    }


}