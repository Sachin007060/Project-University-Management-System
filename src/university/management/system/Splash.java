
package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        
        //for dispaling image in the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
//        for any componet adding in the frame we use
         
        t = new Thread(this);
        t.start();
        // for the prompt
        setVisible(true);
       

//        //setting the location  in the center of a prompt
//        setLocation(310,50);
//        //for increasing the size
//        setSize(1000, 700);
            int x= 1;
          for(int i=2; i<=600; i+=4, x+=1){
                setLocation(600-(i/2),350-(i/2));
                setSize(i+3*x, i+x/2);
                
                try{
                    Thread.sleep(8);
                }catch(Exception e){}
         }
    }
    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);
            
            //Next frame
            new Login();
        }catch(Exception e){
            
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
