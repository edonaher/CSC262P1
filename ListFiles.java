//method uses code from https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
package edu.smith.cs.csc262.coopsh.apps;

import java.io.File;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class ListFiles extends Task {
	
	File workingDir;

	public ListFiles(ShellEnvironment env, String[] args) {
		super(env, args);
		this.workingDir = env.currentDirectory;
	}

	@Override
	protected void update() {
		this.println(workingDir.getAbsolutePath());
		
		File folder = new File(workingDir.getAbsolutePath());
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  //I know a normal shell doesnt do this but I think its fun that it specifies if it is a file or directory!
		    this.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    this.println("Directory " + listOfFiles[i].getName());
		  }
		}
		this.closeOutput();
		this.exit(0);
	}

}
