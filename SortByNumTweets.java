import java.util.*;

public class SortByNumTweets implements Comparator<Tweeter> {

	@Override
	public int compare(Tweeter a,Tweeter b) {

		return b.getNumTweets() - a.getNumTweets();

	}

}