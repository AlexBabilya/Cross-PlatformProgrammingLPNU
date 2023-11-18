
public class Movie {
    private String title;
    private int year;
    private String producer;
        
    public Movie(String title, int year, String producer) {
        this.title = title;
        this.year = year;
        this.producer = producer;
    }

    public String getTitle() {
        return title; 
    }

    public int getYear() {
        return year;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return title + " " + year;
    }
}
