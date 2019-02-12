//code to remove brackets and commas : https://stackoverflow.com/questions/4389480/print-array-without-brackets-and-commas
package edu.smith.cs.csc262.coopsh.apps;

import java.util.ArrayList;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class Head extends Task {
	//arraylist of inputlines to be printed
	ArrayList<String> inputLines = new ArrayList<String>();
	//lineCount
	int lineCount;
	public Head(ShellEnvironment env, String[] args) {
		super(env, args);
	}

	@Override
	protected void update() {
		int numLines = Integer.parseInt(args[0]);
		InputLine line = this.input.poll();
		if (line == null) {
			// still waiting for more...
			return;
		}
		
		// we now have all our lines!
		if (lineCount==numLines) {
			//loop through list to print it
			for(String str : inputLines){
				this.println(str);
			}
			this.closeOutput();
			this.exit(0);
			return;
		}
		
		// Otherwise, add line to lineCount and increment this count!
		inputLines.add(line.get());
		lineCount++;
	}
	
}
