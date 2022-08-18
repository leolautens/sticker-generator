import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor implements ContentExtractor{

    public List<Content> extractContents(String json) {
        // Extract relevant data
        var parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contents = new ArrayList<Content>();

        //Fill the contents list
        for (Map<String, String> attributes : attributesList) {
            String title = attributes.get("title");
            String urlImage = attributes.get("image")
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");;

            var content = new Content(title, urlImage);

            contents.add(content);
        }

        return contents;
    }
}
