import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        /*
        Connects to IMDB api and searches the top 250 contents
        ContentExtractor extractor = new ImdbContentExtractor();
        String url = "https://imdb-api.com/en/API/MostPopularMovies/API_KEY";
        */

        ContentExtractor extractor = new NasaContentExtractor();
        String url = "https://api.nasa.gov/planetary/apod?api_key=API_KEY";

        var http = new ClientHttp();
        String json = http.dataSearch(url);

        // Data visualization IMDB
        List<Content> contents = extractor.extractContents(json);

        var cli = new StickerGenerate();
        for (int i = 0; i < 3; i++) {
            Content content = contents.get(i);

            InputStream inputStream = new URL(content.urlImage()).openStream();
            String newSticker = "output/" + content.title() + ".png";

            cli.createSticker(inputStream, newSticker, content.title());

            System.out.println("\u001b[1mTitle: " + "\u001b[m" + "\u001b[32m" + content.title() + "\u001b[m");
            System.out.println();
        }
    }
}
