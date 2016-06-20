import java.awt.Graphics;
import java.io.File;
import java.awt.Graphics2D;
public class drawFiles
{
    static final int MAXSTRINGSIZE = 10;
    static final int FILEWIDTH = 100;//space drawing a file takes up
    static final int FILEHEIGHT = 100;

    public static void draw(Graphics g, int width, int yScroll, File[] contents)
    {
        final int leftMargin = width/20;//furthest left to start drawing an image at
        int x = leftMargin;//curentx and y to draw file gui at
        int y = 10;

        for(File f: contents)
        {
            drawIcon(g, f, x, y);
            drawName(g, f, x, y);
            x+= FILEWIDTH;
            if(x>width-FILEWIDTH)//runs over the borderof the jframe drawn after in case of really skinny error
            {
                x = leftMargin;
                y+= FILEHEIGHT;
            }
        }
    }
    
    public static void drawIcon(Graphics g, File f, int x, int y)
    {
        if(f.isDirectory())//draw folder
            g.drawRect(x+5,y+5,90,90);//TODO change this with a buffered image once icon folder works out
        else//draw text document icon
            g.drawOval(x+5,y+5,90,90);//TODO same as above
    }

    public static void drawName(Graphics g, File f, int x, int y)
    {
        final String name = f.getName();
        //g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); //This is sped up by placing mehtod in runProgram.paintComponent
        if(name.length()>MAXSTRINGSIZE)
            g.drawString(name.substring(0,MAXSTRINGSIZE-3)+"...",x,y+30);
        else
            g.drawString(name,x,y+30);
    }

}
