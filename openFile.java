import java.io.File;
public class openFile
{
    String selectedPath= "";//the folder thats contents you are looking at
    File[] selectedFiles;//files in selected folder
    public openFile()
    {
        changePath("C:/");
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
        selectedPath = selectedPath.substring(0,selectedPath.substring(0,selectedPath.length()-1).lastIndexOf("/")) + "/";     
        //this algorithm looks really complicated but it just removes everything between the last two '/'s and deletes one of the '/'s
    }

    public void changePath(String fileName)
    {
        selectedPath += fileName;
        selectedFiles = new File(selectedPath).listFiles();        
    }

}
