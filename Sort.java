//idea to use collections.sort from https://stackoverflow.com/questions/16252269/how-to-sort-an-arraylist
package edu.smith.cs.csc262.coopsh.apps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class Sort extends Task {
	//arraylist of inputlines to be sorted
	ArrayList<String> inputLines = new ArrayList<String>();
	public Sort(ShellEnvironment env, String[] args) {
		super(env, args);
	}

	@Override
	protected void update() {
		InputLine line = this.input.poll();
		if (line == null) {
			// still waiting for more...
			return;
		}
		
		// only sort and print when we've seen the whole file!
		if (line.isEndOfFile()) {
			//sort inputlines
			Collections.sort(inputLines);
			//loop through tail to print it
			for(String str : inputLines){
				this.println(str);
			}
			this.closeOutput();
			this.exit(0);
			return;
		}
		
		// Otherwise, increment add this line to the array of strings!
		inputLines.add(line.get());
	}
	
}