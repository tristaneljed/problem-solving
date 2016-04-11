package round1B2010;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileFixIt {
	
	private FileNode fileSystem;
	
	public FileFixIt() {
		this.fileSystem = new FileNode("/");
	}
	
	class FileNode {
		String name;
		Map<String, FileNode> child = new HashMap<>();
		
		public FileNode(String name) {
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("resource/FileFixIts-large.in"));
		PrintWriter pw = new PrintWriter("resource/FileFixIts-large.out");
		
		int t = s.nextInt();
		
		for(int caseNumber=1; caseNumber<=t; caseNumber++) {
			int n = s.nextInt();
			int m = s.nextInt();
			FileFixIt fileFixIt = new FileFixIt();
			
			for(int i=0; i<n; i++) {
				String existingPath = s.next();
				fileFixIt.updateExistingPath(existingPath);
			}
			
			int result = 0;
			for (int i=0; i<m; i++) {
				String toBeCreatedPath = s.next();
				result += fileFixIt.numberOfNewDirectoriesCreated(toBeCreatedPath);
			}
			String output = "Case #" + caseNumber + ": " + result;
			System.out.println(output);
			pw.println(output);
		}
		pw.close();
		s.close();
	}
	
	public void updateExistingPath(String path) {
		String[] directories = path.substring(1).split("/");
		FileNode pointer = fileSystem;
		
		for(String directory:directories) {
			if(pointer.child.keySet().contains(directory)) {
				pointer = pointer.child.get(directory);
			} else {
				FileNode newDirectory = new FileNode(directory);
				pointer.child.put(directory, newDirectory);
				pointer = newDirectory;
			}
		}
	}
	
	public int numberOfNewDirectoriesCreated(String toBeCreatedPath) {
		String[] directories = toBeCreatedPath.substring(1).split("/");
		FileNode pointer = fileSystem;
		int numberOfNewDirectories = 0;
		
		for(String directory:directories) {
			if(pointer.child.keySet().contains(directory)) {
				pointer = pointer.child.get(directory);
			} else {
				FileNode newDirectory = new FileNode(directory);
				pointer.child.put(directory, newDirectory);
				numberOfNewDirectories++;
				pointer = newDirectory;
			}
		}
		return numberOfNewDirectories;
	}

}
