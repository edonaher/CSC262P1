//method to split arraylist found here https://stackoverflow.com/questions/2895342/java-how-can-i-split-an-arraylist-in-multiple-small-arraylists
package edu.smith.cs.csc262.coopsh.apps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//so I'll know how many total lines there are
//so I will need to get the offset from total-desired # to total

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class Tail extends Task {
	int lineCount;
	//arraylist of inputlines to be sorted
	ArrayList<String> inputLines = new ArrayList<String>();
	public Tail(ShellEnvironment env, String[] args) {
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
		
		// only sort and print when we've seen the whole file!
		if (line.isEndOfFile()) {
			int splitIndex = lineCount-numLines;
			//split arraylist so we only keep last n lines
			List<String> tail = inputLines.subList(splitIndex+1, lineCount);
			//loop through tail to print it
			for(String str : tail){
				this.println(str);
			}
			this.closeOutput();
			this.exit(0);
			return;
		}
		lineCount++;
		// Otherwise, increment add this line to the array of strings!
		inputLines.add(line.get());
	}
	
}