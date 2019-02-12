package edu.smith.cs.csc262.coopsh.apps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.*;
import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;
public class RegexGrep extends Task {
	
	//arraylist of inputlines to be sorted
	String selection = "";
	Pattern p;
	
	public RegexGrep(ShellEnvironment env, String[] args) {
		super(env, args);
		System.out.println("arglen:" + args.length);
		System.out.println("arg1" + args[0]);
		for(int i=0; i < args.length; i++){
			System.out.println("i: " + i);
			System.out.println("args" + args[i]);
			selection += (args[i]+" ");
		}
		System.out.println("Selction: " + selection);
		selection = selection.trim();
		//this.println("selection " + selection);
		p = Pattern.compile(selection);
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

		if(p.matcher(line.get()).find()){
			this.println(line.get());
		}
	}
}