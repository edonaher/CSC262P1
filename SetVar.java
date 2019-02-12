package edu.smith.cs.csc262.coopsh.apps;

import java.io.File;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

public class SetVar extends Task {
	
	File workingDir;
	String value="";
	public SetVar(ShellEnvironment env, String[] args) {
		super(env, args);
		this.workingDir = env.currentDirectory;
		//creates value from args (first arg is key)
		for(int i=1; i<args.length; i++){
			value+=args[i];
		}
	}

	@Override
	protected void update() {
		this.println("value : " + value);
		env.setVariable(args[0], value);
		this.closeOutput();
		this.exit(0);
	}

}
