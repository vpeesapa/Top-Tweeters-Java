import java.util.*;
import java.io.*;

public class Parser {

	private int numColumns;
	private ArrayList<Tweeter> tweeters;

	public Parser() {

		numColumns = 0;
		tweeters = new ArrayList<Tweeter>();

	}

	private boolean checkDuplicates(String[] columns) {

		HashMap<String,Integer> map = new HashMap<String,Integer>();

		for(String column : columns) {

			Integer prevVal = map.get(column);
			if(prevVal != null) {
				return true;
			} else {
				map.put(column,1);
			}

		}

		return false;

	}

	private int findName(String[] columns) {

		int nameIndex = -1;

		for(int i = 0;i < columns.length;i++) {
			if(columns[i].equals("name")) {
				nameIndex = i;
			}
		}

		return nameIndex;

	}

	public int parseHeader(String line) {

		String[] columns = line.split("\\s*,\\s*",-1);

		if(checkDuplicates(columns)) {

			// If the header has any duplicated columns
			System.out.println("Invalid Input Format");
			System.exit(1);

		}

		numColumns = columns.length;

		return findName(columns);

	}

	public boolean checkValidity(String[] separatedInfo) {

		return numColumns == separatedInfo.length;

	}

	public int getTweeterIndex(String tweeterName) {

		int tweeterIndex = -1;

		for(int i = 0;i < tweeters.size();i++) {
			Tweeter tweeter = tweeters.get(i);

			if(tweeterName.equals(tweeter.getTweeterName())) {

				tweeterIndex = i;
				break;

			}
		}

		return tweeterIndex;

	}

	public ArrayList<Tweeter> parseRemaining(BufferedReader br,int nameIndex) {

		try {

			String tweeterInfo = br.readLine();
			while(tweeterInfo != null) {

				String[] separatedInfo = tweeterInfo.split("\\s*,\\s*",-1);

				if(!checkValidity(separatedInfo)) {
					
					// If there isn't sufficient information
					System.out.println("Invalid Input Format");
					System.exit(1);

				}

				int tweeterIndex = getTweeterIndex(separatedInfo[nameIndex]);

				if(tweeterIndex == -1) {

					// If the list doesn't contain the tweeter
					tweeters.add(new Tweeter(separatedInfo[nameIndex]));

				} else {

					// If the tweeter was already added to the list
					Tweeter tweeter = tweeters.get(tweeterIndex);
					tweeter.incrementNumTweets();
					tweeters.set(tweeterIndex,tweeter);

				}

				// Read the next line in the file
				tweeterInfo = br.readLine();

			}

		} catch(IOException e) {
			e.printStackTrace();
		}

		return tweeters;

	}

}