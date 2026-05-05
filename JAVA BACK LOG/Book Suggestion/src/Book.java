public class Book {

    private String title;
    private String authorName;
    private String numberOfPages;
    private int suggestedPage;

    public Book(String theHobbit, String name, String title, String authorName, String numberOfPages) {
        this.title = title;
        this.authorName = authorName;
        this.numberOfPages = numberOfPages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSuggestedPage(int pages) {
        this.suggestedPage = pages;
    }

    public String getTitle()           { return title; }
    public String getNumberOfPages()   { return numberOfPages; }
    public int getSuggestedPage()      { return suggestedPage; }

}
