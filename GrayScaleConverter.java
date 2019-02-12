
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import edu.duke.*;

public class GrayScaleConverter {
    // I started with the image I wanted (inImage)
    public void makeGray(){        
        // create BufferImage and file
        BufferedImage img = null;
        File f = null;
        // read image
        try{
            f = new File("image.jpg");
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }
        // get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = img.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                int avg = (r+g+b)/3;
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                img.setRGB(x, y, p);
            }
        }
        // write image
        try{
          f = new File("Output.jpg");
          ImageIO.write(img, "jpg", f);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

