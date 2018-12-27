import java.util.Comparator;
public class CmpByTime implements Comparator<Playable>{

	
	

	
	public int compare(Playable p1, Playable p2) {
		return Integer.compare(p1.getPlayTimeSeconds(),p2.getPlayTimeSeconds());
	}
	

	
}
