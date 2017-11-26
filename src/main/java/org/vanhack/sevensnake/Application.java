package org.vanhack.sevensnake;

import java.io.File;
import java.util.NoSuchElementException;

import org.vanhack.sevensnake.model.Graph;
import org.vanhack.sevensnake.model.SnakeMatch;
import org.vanhack.sevensnake.seeker.SnakeMatchSeeker;

public class Application {

	public static void main(String[] args) {
		if(args.length != 1){
			System.err.println("ERROR - expected only one argument with csv path");
			System.exit(-1);
		}
		try {
			SnakeMatch match = new SnakeMatchSeeker( new Graph( new File(args[0] ) ) ).findMatch();
			System.out.println(match);
		} catch(NoSuchElementException e){
			System.err.println("FAIL");
		} 
	}
}
