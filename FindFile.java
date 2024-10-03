import java.io.File;

public class FindFile {
	//instance variables
    private int MAX_NUMBER_OF_FILES_TO_FIND;
    private int count = 0;
    private String[] fileList;

    /**
     * constructor
     * @param name
     * @param x
     * @param MAX_NUMBER_OF_FILES_TO_FIND
     */
    FindFile(String name, String x, int MAX_NUMBER_OF_FILES_TO_FIND) {
    	this.MAX_NUMBER_OF_FILES_TO_FIND = MAX_NUMBER_OF_FILES_TO_FIND;
        fileList = new String[MAX_NUMBER_OF_FILES_TO_FIND];
        directorySearch(name, x);
    }

    /**
     * method that searches the directory
     * @param name
     * @param x
     */
    public void directorySearch(String name, String x) {

        File file = new File(name);
        File[] list = file.listFiles();
        
        if (!(file.isDirectory()))
            throw new IllegalArgumentException("Invalid Directory");
        if (list == null)
            return;

        for (File f : list) {
            if (f.isDirectory()) {
                directorySearch(f.getAbsolutePath(), x);
            } else {
                if (f.getName().equals(x) && count < MAX_NUMBER_OF_FILES_TO_FIND) {
                    fileList[count] = f.getPath();
                    count++;
                }
                else if(f.getName().equals(x) && count >= MAX_NUMBER_OF_FILES_TO_FIND)
                    throw new IllegalArgumentException("Count has exceeded max allowed number");
            }
        }
    }

    /**
     * gets the current count of target files
     * @return count
     */
    public int getCount() {
        return this.count;
    }

    /**
     * checks if String[] has a path 
     * @return
     */
    public String[] getFiles() {
        if (count != 0)
            return this.fileList;
        else
        throw new NullPointerException("There are no files that have this filename");
    }

    /**
     * prints out the String[]
     */
    public void printArray() {
        String[] array = new String[0];
        
        if(getFiles() != null)
         array = new String[getFiles().length];
        
        for(int i = 0; i < array.length; i++){
            array[i] = getFiles()[i];
        }
        
        for(String path : array){
            if(path != null)
            System.out.println("path: " + path);
        }
    }
}
