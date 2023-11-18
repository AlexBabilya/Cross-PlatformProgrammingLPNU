import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Lab03{
    public static void main(String[] args) throws IOException {
        List<Movie> moviesFromFirstFile = Files.readAllLines(Paths.get("first.txt"))
                .stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    String title = parts[0];
                    int year = Integer.parseInt(parts[1]);
                    String producer = parts[2];
                    return new Movie(title, year, producer);
                })
                .collect(Collectors.toList());

        List<Movie> moviesFromSecondFile = Files.readAllLines(Paths.get("second.txt"))
                .stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    String title = parts[0];
                    int year = Integer.parseInt(parts[1]);
                    String producer = parts[2];
                    return new Movie(title, year, producer);
                })
                .collect(Collectors.toList());
        moviesFromFirstFile.addAll(moviesFromSecondFile);
        Collections.sort(moviesFromFirstFile, Comparator.comparingInt(Movie::getYear));

        for (Movie movie: moviesFromFirstFile)
    {
            System.out.println(movie);
        }
        // Create a map with the key producer's name and the value - list of movies produced by the corresponding person or organization.
        Map<String, List<Movie>> producerMovieMap = moviesFromFirstFile.stream()
                .collect(Collectors.groupingBy(Movie::getProducer, TreeMap::new, Collectors.toList()));

        // Create a map with a key of year and a value of a set of movie titles.
        Map<Integer, Set<String>> yearMovieSet = moviesFromFirstFile.stream()
                .collect(Collectors.groupingBy(Movie::getYear, TreeMap::new, Collectors.mapping(Movie::getTitle, Collectors.toSet())));

        // Output the results.
        System.out.println("Producer - Movies:");
        producerMovieMap.forEach((producer, movies) -> {
            System.out.println(producer + " - " + movies);
        });

        System.out.println("\nYear - Movie Titles:");
        yearMovieSet.forEach((year, titles) -> {
            System.out.println(year + " - " + titles);
        });
    }
}

