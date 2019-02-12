package edu.smith.cs.csc262.coopsh.apps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class SimpleGrep extends Task {
	//arraylist of inputlines to be sorted
	String selection = "";
	public SimpleGrep(ShellEnvironment env, String[] args) {
		super(env, args);
		for(int i=0; i < args.length; i++){
			//this.println(args[i]);
			selection += (args[i]+" ");
		}
		selection = selection.trim();
	}

	@Override
	protected void update() {
		InputLine line = this.input.poll();
		//turn the args into a string
		
		if (line == null) {
			// still waiting for more...
			return;
		}
		
		// end when we've seen the whole file!
		if (line.isEndOfFile()) {
			this.closeOutput();
			this.exit(0);
			return;
		}


		if(line.get().contains(selection) ){
			this.println(line.get());
		}
		
	}
	
}