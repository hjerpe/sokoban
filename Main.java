/*
 * Main
 * 
 * Version 0.1
 * 
 * 
 * Gnerall conventions:
 * - All class constants desricptiveName
 * - All input parameters pDesricptiveName
 * - All local variables lDescriptiveName
 * - "GameState" is used equivalent to "Node"; one GameState is expanded, has parent and successors... 
 * 
 */

import java.io.*;

public class Main {

	/**
	 * @param args
	 * 
	 */
	
	
	public static void main(String[] args) throws IOException {

		 final Client client = new Client();
		 final Map map = client.getMapFromFile();
		 Solver solver = new Solver(map);

		 System.out.println(solver.solutionPath());
		
	} // main
} // End Main