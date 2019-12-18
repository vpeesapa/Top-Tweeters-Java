import java.util.*;

public class Tweeter {

	private String tweeterName;
	private int numTweets;

	public Tweeter(String tweeterName) {

		this.tweeterName = tweeterName;
		this.numTweets = 1;

	}

	public String getTweeterName() {
		return tweeterName;
	}

	public int getNumTweets() {
		return numTweets;
	}

	public void incrementNumTweets() {
		numTweets += 1;
	}

}