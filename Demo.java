class Artist {
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayInformation() {
        System.out.println("Artist Name: " + name);
    }
}

class Artwork {
    private String title;
    private int year;
    private Artist artist;

    public Artwork(String title, int year, Artist artist) {
        this.title = title;
        this.year = year;
        this.artist = artist;
    }

    public Artwork(String title, int year) {
        this.title = title;
        this.year = year;
        this.artist = new Artist("Unknown Artist");
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void displayInformation() {
        System.out.println("Artwork Title: " + title);
        System.out.println("Year: " + year);
        artist.displayInformation();
    }

    public Artwork shallowCopy() {
        return new Artwork(this.title, this.year, this.artist);
    }

    public Artwork deepCopy() {
        return new Artwork(this.title, this.year, new Artist(this.artist.getName()));
    }
}

public class Demo {
    public static void main(String[] args) {
        Artist artist1 = new Artist(" Vincent van Gogh");

        Artwork artwork1 = new Artwork("Starry Night", 1889, artist1);
        Artwork artwork2 = new Artwork("Sunflowers", 1498);

        System.out.println("Original Artworks:");
        artwork1.displayInformation();
        artwork2.displayInformation();

        Artwork shallowCopy = artwork1.shallowCopy();
        Artwork deepCopy = artwork1.deepCopy();

        artist1 = new Artist("Vincent van Gogh");

        System.out.println("\nAfter Modifying Artist Name:");
        artwork1.displayInformation();
        System.out.println("\nShallow Copy:");
        shallowCopy.displayInformation();
        System.out.println("\nDeep Copy:");
        deepCopy.displayInformation();
    }
}
