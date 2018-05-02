package literature;
/**
 * Classifies a magazine.
 *
 * @author (Pernille, Emil og Ørjan)
 * @version (Version nummer 0.1)
 *
 **/


public class Magazine extends Literature {
    private String releaseDate;

    public Magazine(String title, String author, String publisher,String releaseDate, String edition)
    {
        super(title,author,publisher,edition);
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public String getLiteratureInformation()
    {
        return "\nTitle: " + getTitle() +
                "\nPublisher: " + getPublisher() +
                "\nRelease date: " + getReleaseDate() +
                "\nEdition:" + getEdition();
    }

}