
/**
 * Write a description of GrayScaleConverterUsingDukeLibrary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class GrayScaleConverterUsingDukeLibrary {
    // starting with the inImage (the input image)
    public ImageResource makeGray(ImageResource inImage){
        // make a blank image of the same size of inImage (the input image) and call it outImage
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // for each pixel in outImage:
        for (Pixel pixel: outImage.pixels()){
            // call the corresponding pixel in inImage, inPixel
            Pixel inpixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // Compute inPixel's red + inPixel's green + inPixel's blue
            // divide the sum by 3 and call it average
            int average = (inpixel.getRed() + inpixel.getGreen() + inpixel.getBlue()) / 3;
            // set pixel's red to average
            pixel.setRed(average);
            // set pixel's green to average
            pixel.setGreen(average);
            // set pixel's blue to average
            pixel.setBlue(average);
        }   
        // outImage is the answer
        return outImage;
    }
        
    public void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
        String inputFileName = ir.getFileName();
        String grayFileName = "gray" +  inputFileName;
        gray.setFileName(grayFileName);
        gray.save();
        
    }
}
