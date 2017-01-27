import java.io.File;
public class openFile
{
    String selectedPath= "";//the folder thats contents you are looking at
    File[] selectedFiles;//files in selected folder
    public openFile()
    {
        if(System.getProperty("os.name")=="Windows")
        {
            changePath("C:/");
        }
        else
        {
            changePath("/");
        }
    }

    public File[] getFiles()
    {
        return selectedFiles;
    }
    
    public String getPath()
    {
        return selectedPath;
    }
    
    public void backButtonClicked()
    {
     
        try{
        //handle spaces
        if(selectedPath.lastIndexOf(' ')>selectedPath.substring(0,selectedPath.length()-1).lastIndexOf("/"))
        {

        selectedPath = selectedPath.substring(0,selectedPath.lastIndexOf(" ",selectedPath.substring(0,selectedPath.length()-1).lastIndexOf("/"))); //get rid of all spaces between your last two /'s
        }
        selectedPath = selectedPath.substring(0,selectedPath.substring(0,selectedPath.length()-1).lastIndexOf("/")) + "/";     
        }catch(Exception e){};
        //this algorithm looks really complicated but it just removes everything between the last two '/'s and deletes one of the '/'s
    }

    public void changePath(String fileName)
    {
        selectedPath += fileName;
        selectedFiles = new File(selectedPath).listFiles();        
    }

}
