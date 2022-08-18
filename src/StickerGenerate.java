import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickerGenerate{
    
    public void createSticker(InputStream inputStream, String newSticker, String title) throws IOException {

        // Read image
        BufferedImage ogImage = ImageIO.read(inputStream);

        // Create a new image in memory with transparency and new size
        int width = ogImage.getWidth();
        int height = ogImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copy the original image in a new image (in memory)
        Graphics graphics = newImage.getGraphics();
        graphics.drawImage(ogImage, 0, 0, null);

        // Config font
        var text = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(text);

        // Write a quote in new image
        graphics.drawString(title, 150, newHeight - 100);

        // Write a new image in file
        ImageIO.write(newImage, "png", new File(newSticker));
    }

}
