package patternRemover;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileTextRemover {

	public static File affectedFiles;
	public static boolean writeOutput = false;
	public static String fileType = ".ts";
	public static int changedFileCount = 0;
	public static boolean promptBeforeChange = true;
	public static String[] textToReplace = {"ABCD"};
	public static String replacedText = "";
	public static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void fileTraverser(File dir) {
		//If it is file.
		if (dir.isFile()) {
			String fileName = dir.getName();
			if (fileName.endsWith(fileType)) {
				removeText(dir);
			}
		} else if (dir.isDirectory()) {
			//If it is Directory
			File[] directoryListing = dir.listFiles();
			  if (directoryListing != null) {
			    for (File child : directoryListing) {
			      fileTraverser(child);
			    }
			  }
		}
	}
	
	public static void removeText(File file) {
		if (file.canWrite()) {
			try {
				Boolean changeFile = false;
				Scanner fileReader = new Scanner(file);
				String totalStr = "";
				Boolean textFound = false;
				while (fileReader.hasNextLine()) {
				    String line = fileReader.nextLine();
				    for (String text: textToReplace) {
				    	if (line.contains(text)) {
				    		//If prompting from user is needed to replace text
				    		if (promptBeforeChange) {
				    			System.out.println(line + "\n Will be replaced by" + line.replace(text, replacedText) +
				    					"\n Are you sure? Y/N");
				    			String userInput = new String();
				    			try {
				    				userInput = consoleReader.readLine();
				    				if (userInput.equalsIgnoreCase("y")) {
				    					changeFile = true;
				    				} else {
				    					changeFile = false;
				    				}
				    			} catch (IOException e) {
				    				e.printStackTrace();
				    			}
				    		}
				    		if (!promptBeforeChange || (promptBeforeChange && changeFile)) {
						        line = line.replace(text, replacedText);
						        textFound = true;
				    		}
					    }
				    }
				    totalStr = totalStr + "\n" + line;
				}
				fileReader.close();
				//Write to output file
				if (textFound) {
					FileWriter fw = new FileWriter(file);
				    fw.write(totalStr);
				    fw.close();
				    changedFileCount += 1;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//If output is needed write to output file
		if (writeOutput) {
			try
			{
			    FileWriter fw = new FileWriter(affectedFiles, true); //the true will append the new data
			    fw.write(file.getName() + " \n"); //appends the string to the file
			    fw.close();
			} catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter Directory Path:-");
		String directoryPath = new String();
		try {
			directoryPath = consoleReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Create and Set Output file
		affectedFiles = new File(directoryPath + "\\affectedFiles.txt");
		try {
			if (affectedFiles.exists()) {
				affectedFiles.delete();
			}
			if (affectedFiles.createNewFile()) {
				writeOutput = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Traverse Directory
		File dir = new File(directoryPath);
		fileTraverser(dir);
		try {
			consoleReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Files Affected: " + changedFileCount);
	}

}
