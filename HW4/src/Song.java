public class Song implements Comparable<Song>, Playable{
	private String artist; // the artist performing the song
	private String title; // the title of the song
	private int minutes; // number of min in length
	private int seconds; // number of seconds of the song (always less than 60)
	// Add Getters / Setters for all fields

	// Add the following three constructors (remember to initialize ALL fields in each of the constructors - regardless of the number of parameters!)

	public Song(String artist, String title) {
		this.artist=artist;
		this.title=title;
		this.minutes=0;
		this.seconds=0;
	}
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist=artist;
		this.title=title;
		this.minutes=minutes;
		this.seconds=seconds;
	}
	public Song(Song s) {
		this.artist= s.getArtist();
		this.title=s.getTitle();
		this.minutes=s.getMinutes();
		this.seconds=s.getSeconds();
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public boolean equals(Object o) {
		// two songs are equal if all four fields are equal
		if (o instanceof Song) {
			Song s= (Song) o;
			if (this.artist.equals(s.getArtist())&&this.title.equals(s.getTitle())&&this.minutes==s.getMinutes()&&this.seconds==s.getSeconds()) {
				return true;
			}

		}
		return false;

	}
	public String toString() { // Use this code for toString EXACTLY

		return "{Song: title = " + title + " artist = " + artist + "}";

	}
	public void play() { // Use this code for play EXACTLY

		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);

	}
	

	@Override
	public int compareTo(Song arg0) {
		// TODO Auto-generated method stub
		if (this.artist.equals(arg0.getArtist())) {
			
				return this.title.compareTo(arg0.getTitle());
			
		}
		
			return this.artist.compareTo(arg0.getArtist());

	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.title;
	}
	@Override
	public int getPlayTimeSeconds() {
		// TODO Auto-generated method stub
		return 60*this.minutes+this.seconds;
	}
	@Override
	public int numberOfSongs() {
		// TODO Auto-generated method stub
		return 1;
	}

}
