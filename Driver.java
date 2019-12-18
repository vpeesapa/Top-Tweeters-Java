import java.util.*;
import java.io.*;

public class Driver {

	public static void checkArgs(String[] args) {

		if(args.length != 1) {
			// The program needs to have at least one argument
			System.out.println("Invalid Input Format");
			System.exit(1);
		}

	}

	public static void printTopTen(ArrayList<Tweeter> tweeters) {

		int numToPrint = 0;
		if(tweeters.size() > 10) {
			numToPrint = 10;
		} else {
			numToPrint = tweeters.size();
		}

		System.out.println("The top " + numToPrint + " tweeters are as follows: ");
		for(int i = 0;i < numToPrint;i++) {
			
			Tweeter tweeter = tweeters.get(i);
			System.out.println(tweeter.getTweeterName() + ": " + tweeter.getNumTweets());
		
		}

	}

	public static void readFile(String fileName) {

		Parser parser =  new Parser();

		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String firstLine = br.readLine();

			int nameIndex = parser.parseHeader(firstLine);

			if(nameIndex == -1) {
				// If the CSV File doesn't have a column called name
				System.out.println("Invalid Input Format");
				System.exit(1);
			}

			ArrayList<Tweeter> tweeters = parser.parseRemaining(br,nameIndex);

			// Sorting the array list based on the number of tweets of each tweeter
			Collections.sort(tweeters,new SortByNumTweets());

			printTopTen(tweeters);

			br.close();

		} catch(IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		checkArgs(args);

		readFile(args[0]);

	}

}