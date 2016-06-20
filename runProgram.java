import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;
public class runProgram extends JComponent
{
    final private int DIRECTORYBOXHEIGHT = 80;//the thinckness of the directory box on the bottom
    final private int BACKBUTTONWIDTH = 80;// the width of the back button on the bottom right
    final private int FONTSIZE = 20;
    final private int TAB = 5;
    private static int width;
    private static int height;
    private openFile current = new openFile();
    public runProgram()
    {
        addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    checkBackClicked(e.getX(),e.getY());
                    current.changePath(clickBoxes.fileClicked(width, 0 , current.getFiles(),e.getX(),e.getY() ));
                }
            });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        runProgram start = new runProgram();
        frame.add(start);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true)
        {
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e)
            {
                System.out.println("thread sleep error");
            }
            width = frame.getWidth();
            height = frame.getHeight();
            frame.repaint();
        }
    }

    public void paintComponent(Graphics g)
    {
        final Font THEFONT = new Font("TimesRoman", Font.PLAIN, FONTSIZE);
        g.setFont(THEFONT);// sets the font and size
        
        if(current.getFiles()!=null){
            drawFiles.draw(g, width, 0, current.getFiles());//draws eachindividual file and name
        }
        drawDirectory(g);//draws box with directory on the bottom  
        drawBackButton(g);//draws back button
    }
    
    public void drawDirectory(Graphics g)
    {   //this method draws the box and directory and the bottom
        final Color GREY = new Color(160,160,160);
        g.setColor(GREY);
        g.fillRect(0,height-DIRECTORYBOXHEIGHT,width,DIRECTORYBOXHEIGHT);
        g.setColor(Color.BLUE);
        g.drawString(current.getPath(),TAB,height-DIRECTORYBOXHEIGHT + FONTSIZE + TAB);
    }
    
    public void drawBackButton(Graphics g)
    {
        final String buttonText = "BACK";
        g.setColor(Color.RED);
        g.fillRect(width-BACKBUTTONWIDTH,height-DIRECTORYBOXHEIGHT,BACKBUTTONWIDTH,DIRECTORYBOXHEIGHT);
        g.setColor(Color.BLACK);
        g.drawString(buttonText,width-BACKBUTTONWIDTH,height-DIRECTORYBOXHEIGHT + FONTSIZE + TAB);
    }
    
    public void checkBackClicked(int x, int y)
    {
        if(new Rectangle(width-BACKBUTTONWIDTH,height-DIRECTORYBOXHEIGHT,BACKBUTTONWIDTH,DIRECTORYBOXHEIGHT).contains(x,y))
        {
            current.backButtonClicked();
        }
    }
}
