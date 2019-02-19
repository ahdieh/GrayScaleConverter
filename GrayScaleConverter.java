
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFileChooser;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GrayScaleConverter {
    public void makeGray(){        
        // create BufferImage and file
        BufferedImage img = null;
        File f = null;
        // read image
        try{
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(null);
            f = new File(chooser.getSelectedFile().getName());
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }
        // get image width and height
        int width = img.getWidth();
        int height = img.getHeight();               
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                // get the pixel of each x,y 
                int p = img.getRGB(x,y);
                // get the transparency(alpha)(a) that is the first byte (p>>24)
                int a = (p>>24)&0xff;
                // get the Red(r) that is the second byte (p>>16)
                int r = (p>>16)&0xff;
                // get the Green(g) that is the third byte (p>>8)
                int g = (p>>8)&0xff;
                // get the Blue(r) that is the forth byte (p)
                int b = p&0xff;
                // in gray scale red and green and blue are the same
                int avg = (r+g+b)/3;
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                img.setRGB(x, y, p);
            }
        }
        // write image
        try{
            
          f = new File("Output.jpg");
          ImageIO.write(img, "jpg", f);
          JFrame frame = new JFrame();
          ImageIcon icon = new ImageIcon("Output.jpg");
          JLabel label = new JLabel(icon);
          frame.add(label);
          //frame.setDefaultCloseOperation
          //       (JFrame.EXIT_ON_CLOSE);
          //frame.pack();
          frame.setVisible(true);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

