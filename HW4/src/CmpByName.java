import java.util.Comparator;

public class CmpByName implements Comparator<Playable>{
	@Override
	public int compare(Playable s1, Playable s2) {
		return s1.getName().compareTo(s2.getName());
	}
}
