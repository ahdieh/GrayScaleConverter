
/**
 * Invert an image.
 * 
 * @author (Ahdieh) 
 * @version (Feb 16, 2019)
 */
import edu.duke.*;
import java.io.File; 

public class BatchInversions {
    // start with the image we wanted to invert
    public ImageResource makeInversion(ImageResource img){
        // create a blank image as outImage the same size of img
        ImageResource outImage = new ImageResource(img.getWidth(), img.getHeight());
        // for each pixel in outImage
        for (Pixel pixel: outImage.pixels()){
            // get the corresponding pixel in img
            Pixel inPixel = img.getPixel(pixel.getX(), pixel.getY());
            // compute the RGB for each pixel in outImage
            int invertedRed = 255 - inPixel.getRed();
            int invertedGreen = 255 - inPixel.getGreen();
            int invertedBlue = 255 - inPixel.getBlue();            
            // set the RGB for each pixel in outImage
            pixel.setRed(invertedRed);
            pixel.setGreen(invertedGreen);
            pixel.setBlue(invertedBlue);            
        }
        return outImage;
    }
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            ImageResource image = new ImageResource(f);            
            ImageResource invertedImage = makeInversion(image);            
            String fileName = image.getFileName();
            String newFileName = "inverted-" + fileName;
            invertedImage.setFileName(newFileName);
            invertedImage.draw();
            invertedImage.save();
        }
    }
}
