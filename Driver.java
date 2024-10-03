
public class Driver {

	public static void main(String[] args) {
		String targetFile = "FindThis.txt";
		String path = "C:\\Users\\shafa\\Desktop";
		FindFile findFile = new FindFile(path, targetFile, 10);
		
		try {
			findFile.directorySearch(path, targetFile);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			System.exit(0);
		}
		
		System.out.println("There were " + findFile.getCount() + " files found");
	}

}
