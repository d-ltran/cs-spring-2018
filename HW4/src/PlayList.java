import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlayList implements Playable{

	private String name; // contains the name of the playlist

	private ArrayList<Playable> playableList; // ArrayList of Playable elements that make up the playlist



	//	X          Methods that modify the list should return a boolean: return true if they successfully change the list, otherwise, they return false.  Note that a PlayList can contain other PlayLists!

	//  X          Methods that return a Playable element return null if they fail to find the song in question. 

	//  X          Add Getters / Setters for name and playableList  X

	//  X          Add a toString() method that returns the name of the playlist followed by its contents (by calling toString() on each item it contains).  You should only have one name/title per line   X 

	//  X          Add the following two constructors (remember to initialize ALL fields in each of the constructors - regardless of the number of parameters!)

	public PlayList() {
		// empty playlist named "Untitled"
		this.name="Untitled";
		playableList= new ArrayList<Playable>();
	}

	public PlayList(String newName) {
		// empty playlist
		this.name=newName;
		playableList= new ArrayList<Playable>();

	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	public boolean loadSongs(String fileName) {
		// loads songs from file, more on this below
		String title="";
		String artist="";
		int min=0;	
		int sec=0;
		int remainder=0;
		String[] nums=new String[2];
		File playfile = new File(fileName);
		Scanner readfile;
		try {
			readfile = new Scanner(playfile);
			while(readfile.hasNext()) {
				title= readfile.nextLine().trim();
				artist= readfile.nextLine().trim();
				nums=readfile.nextLine().trim().split(":");
				readfile.nextLine();
				min=Integer.parseInt(nums[0]);
				sec=Integer.parseInt(nums[1]);
				if (sec>60) {
					remainder=sec/60;
					sec=sec%60;
				}
				min+=remainder;
				this.addSong(new Song(artist,title,min,sec));
			}
			readfile.close();
			return true;
		}catch(FileNotFoundException e){
			return false;
		}
	}

	public boolean clear() {
		// removes all playable elements in the playlist
		if (this.playableList.size()>0) {
			this.playableList.clear();
			return true;
		}

		return false;
	}

	public boolean addSong(Song s) {
		// adds Song s to the end of the play list
		return this.playableList.add(s);
	}

	public Playable removePlayable(int index) {
		// removes Playable element at index from the list and returns it
		Playable x=this.playableList.get(index);
		this.playableList.remove(index);
		return x;

	}

	public Playable removePlayable(Playable p) {
		// removes every occurrence of Playable p from the list and returns p
		for (int i =0; i<this.playableList.size();i++) {
			if(this.playableList.get(i).equals(p)) {
				this.playableList.remove(playableList.get(i));
			}
		}
		return p;

	}

	public Playable getPlayable(int index) {
		// returns the Playable element at the appropriate index
		if(this.playableList.size()>index && index>=0) {
		return playableList.get(index);
		}
		return null;
	}
	public String toString() {
		String s="";
		for (int i=0; i<this.playableList.size();i++) {
			s+="\n"+playableList.get(i).toString();
		}
		return this.name+": "+s;
	}


	public boolean addPlayList(PlayList p1) {
		//adds the PlayList that is being passed to the end of the playableList and returns true unless the playableList already contains a playlist with the same name, in this case, do not add the playlist and return false.  Playlists are uniquely identified by name, so your program should not allow there to be two playlists with the same name.
		for (int i =0; i < this.playableList.size(); i++) {
			if(this.playableList.get(i).getName().equals(p1.getName())) {
				return false;
			}
		}

		this.playableList.add(p1);
		return true;

	}

	public void play() {
		// plays the playlist by calling play() on each item in the playlist in order
		for (int i =0; i<this.playableList.size();i++) {
			this.playableList.get(i).play();
		}
	}

	public void sortByName() {
		Collections.sort(this.playableList, new CmpByName());
	}
	public void sortByTime() {
		Collections.sort(this.playableList, new CmpByTime());
	}
	@Override
	public int getPlayTimeSeconds() {
		// TODO Auto-generated method stub
		int seconds=0;
		for (int i =0; i<this.playableList.size();i++) {
			if (this.playableList.get(i) instanceof Song) {
				seconds+=this.playableList.get(i).getPlayTimeSeconds();
			}
			else if(this.playableList.get(i) instanceof PlayList) {
				seconds+=this.playableList.get(i).getPlayTimeSeconds();
			}
		}

		return seconds;
	}

	@Override
	public int numberOfSongs() {
		// TODO Auto-generated method stub
		int snum=0;
		for (int i=0; i<this.playableList.size();i++){
			if(this.playableList.get(i) instanceof Song) {
				snum+= this.playableList.get(i).numberOfSongs();
			}
			else if(this.playableList.get(i) instanceof PlayList) {
				snum+=this.playableList.get(i).numberOfSongs();
			}
		}
		return snum;
	}



}