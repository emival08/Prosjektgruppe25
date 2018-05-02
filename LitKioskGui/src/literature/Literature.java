package literature;
/**
 * Classifies the literature
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
 *
 **/


public abstract class Literature {
    private String title;
    private String publisher;
    private String edition;

    public Literature(String title,String author, String publisher, String edition) {
        this.title = title;
        this.publisher = publisher;
        this.edition = edition;

    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getEdition() {
        return edition;
    }

    public abstract String getLiteratureInformation();

}
 