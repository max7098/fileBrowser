import java.awt.Rectangle;
import java.io.File;
/**
 * returns file clicke on if one is clicked on
 */
public class clickBoxes
{
    static final int FILEWIDTH = 100;//space drawing a file takes up
    static final int FILEHEIGHT = 100;
    public static String fileClicked(int width, int yScroll, File[] listed,int xClicked,int yClicked)
    {

        final int leftMargin = width/20;//furthest left to start drawing an image at

        int x = leftMargin;//curentx and y to draw file gui at
        int y = 10;

        for(File f: listed)
        {
           
            if(f.isDirectory()&&new Rectangle(x,y,FILEWIDTH,FILEHEIGHT).contains(xClicked, yClicked))//if is a folder and was clicked on
            {
                return f.getName() + "/";

            }

            x+= FILEWIDTH;
            if(x>width-FILEWIDTH)
            {
                x = leftMargin;
                y+= FILEHEIGHT;
            }
        }
        return"";
    }
}
