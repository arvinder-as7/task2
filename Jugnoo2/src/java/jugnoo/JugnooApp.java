/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugnoo;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 *
 * @author gurleen
 */
public class JugnooApp {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
    JugnooApp obj=new JugnooApp();
    String str=obj.getQoute();
    obj.getImage(str);
    String accessToken="EAACEdEose0cBAHSmjrVbQRluqtm5hX9Lbxtj3vjIjc3KIFsUfkMROgpHeohCJI2jEUPUN4TodPMc2C5DjwLscEWXgOtEiVrTugr4UJ4oh7bRZA73a4z1MR1jvXzgEKoM1FTVfVfoZCuBAMk0rzxVjzrx1E5ZCcZA7Qoa6uXHOjI8UDXTwMX3XYaDmxjdg1MZD";
    FacebookClient fbClient= new DefaultFacebookClient(accessToken);
    FileInputStream fi=new FileInputStream(new File("quote.png"));
    FacebookType response=fbClient.publish("me/photos", FacebookType.class, BinaryAttachment.with("quote.png", fi),Parameter.with("message", "testing"));
    System.out.println("fb.com/"+response.getId());
    }
    void getImage(String text)
    {
        /*
           Because font metrics is based on a graphics context, we need to create
           a small, temporary image so we can ascertain the width and height
           of the final image
         */
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();
        try {
            ImageIO.write(img, "png", new File("quote.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String getQoute()
    {
    FileInputStream fis = null;
        BufferedReader reader = null;
                  Vector<String> myVector=new Vector<String>();
                        int n=0;
        try {
            fis = new FileInputStream("C:\\Users\\gurleen\\Documents\\NetBeansProjects\\Jugnoo2\\src\\java\\jugnoo\\favQoute.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
          
           // System.out.println("Reading File line by line using BufferedReader");
            String line = reader.readLine();
            while(line != null){
                myVector.add(line);
                line = reader.readLine();
            }           
          Random rand = new Random();
            n = rand.nextInt(myVector.size());
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
          
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
              
            }

            }
            return myVector.elementAt(n);
    }
}
