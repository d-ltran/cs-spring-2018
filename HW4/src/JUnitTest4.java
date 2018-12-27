import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class JUnitTest4 {
	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
	private Song s5;
	private Song s6;
	private ArrayList<Playable> playlist;
	private PlayList plist;
	private PlayList qlist;
	private PlayList rlist;

	@Before
	public void setUp() throws Exception {
		s1=new Song("Chopin", "Nocturne", 4 , 30 );
		s2=new Song("Maroon 5", "Sunday Morning", 3, 30);
		s3=new Song(s1);
		s4=new Song("Chopin", "Nocturne", 4 , 30 );
		s5=new Song("Jeung", "If It Is You", 2, 50);
		s6=new Song("Mariah Carey", "Emotions", 3, 50);
		playlist= new ArrayList<Playable>();
		plist= new PlayList("Classical Music");
		qlist= new PlayList("R&B");
		rlist= new PlayList("Classical Music");

	}
	//For Song Methods
	@Test
	public void testEqualsSongwhennotequal() {

		assertFalse(s1.equals(s2));
	}
	@Test
	public void testEqualsSongduplicate() {
		assertTrue(s1.equals(s4));
	}
	@Test
	public void testSongString() {
		assertEquals("{Song: title = Nocturne artist = Chopin}", s1.toString());
	}
	@Test
	public void testSongString2() {
		assertEquals("{Song: title = Sunday Morning artist = Maroon 5}", s2.toString());
	}
	@Test
	public void testCompareSongsSame() {
		assertEquals(0, s1.compareTo(s3));
	}
	@Test
	public void testCompareSongsDiff() {
		assertTrue(s1.compareTo(s2)<0);
	}

	//	For PlayList Methods
	@Test
	public void testaddSongWhenAlreadyadded() {
		assertTrue(plist.addSong(s1));
	}
	@Test
	public void testaddSong() {
		assertTrue(plist.addSong(s2));
	}
	@Test
	public void testtoStringPlayListSong() {
		plist.addSong(s1);
		assertEquals("Classical Music: \n{Song: title = Nocturne artist = Chopin}",plist.toString());
	}
	@Test
	public void testtoStringPlayListMultipleSongs() {
		qlist.addSong(s1);
		plist.addSong(s2);
		plist.addPlayList(qlist);
		assertEquals("Classical Music: \n" + "{Song: title = Sunday Morning artist = Maroon 5}\n" + "R&B: \n" + "{Song: title = Nocturne artist = Chopin}", plist.toString());


	}
	@Test
	public void testclear() {
		playlist.add(s1);playlist.add(s2);
		plist.setPlayableList(playlist);
		assertEquals(true , plist.clear());
	}
	@Test
	public void testclearWhenNoElements() {
		assertEquals(false , plist.clear());
	}
	@Test
	public void testRemovePlayable() {
		playlist.add(s1); playlist.add(s2);
		plist.setPlayableList(playlist);
		assertEquals(s1, plist.removePlayable(0));

	}
	@Test
	public void testRemove2(){
		playlist.add(s1); playlist.add(s2);
		plist.setPlayableList(playlist);
		assertEquals(s2, plist.removePlayable(1));
	}
	@Test
	public void testRemovePlayable_p(){
		playlist.add(s1); playlist.add(s2);
		plist.setPlayableList(playlist);
		assertEquals(s2, plist.removePlayable(s2));

	}
	@Test
	public void testRemovePlayableMultiple(){
		playlist.add(s1); playlist.add(s2);playlist.add(s4);
		plist.setPlayableList(playlist);
		assertEquals(s4, plist.removePlayable(s4));		
	}
	@Test
	public void testRemovePlayablewhenPlaylist() {
		plist.addSong(s1);
		qlist.addPlayList(plist);
		assertEquals(plist, qlist.removePlayable(plist));
	}
	@Test
	public void addPlaylistWhenNotThere() {
		assertTrue(plist.addPlayList(plist));
		assertTrue(plist.getPlayableList().contains(plist));
	}
	@Test
	public void addPlaylistWhenAlreadyHaveOne() {
		plist.addPlayList(rlist);
		assertFalse(plist.addPlayList(rlist));
		//	rlist same name as plist
	}
	@Test
	public void testSortByPlaylistName(){
		plist.addSong(s1);plist.addSong(s2);
		qlist.addSong(s5);qlist.addSong(s6);
		plist.addPlayList(qlist);
		plist.sortByName();
		assertEquals(s1, plist.getPlayableList().get(0));
	}
	@Test
	public void testSortSongName(){
		plist.addSong(s1);plist.addSong(s2);
		plist.addSong(s5);plist.addSong(s6);
		plist.sortByName();
		assertEquals(s6, plist.getPlayableList().get(0));
	}
	@Test
	public void testSortByTime() {
		plist.addSong(s1);plist.addSong(s2);
		plist.sortByTime();
		assertEquals(s2, plist.getPlayable(0));
	}
	@Test
	public void testSortByTimeWithSameTime() {
		plist.addSong(s1);plist.addSong(s2);plist.addSong(s4);
		plist.sortByTime();
		assertEquals(s2, plist.getPlayable(0));
	}
	@Test
	public void testgetTimeSeconds() {
		plist.addSong(s1);plist.addSong(s5);
		assertEquals(440, plist.getPlayTimeSeconds());
	}
	@Test
	public void testgetTimeSecondsWithPlaylist() {
		qlist.addSong(s1);qlist.addSong(s5);
		plist.addPlayList(qlist);
		assertEquals(440, plist.getPlayTimeSeconds());
	}
	@Test
	public void testgetTimeSecondsWithBothPlaylistSong() {
		plist.addSong(s1);qlist.addSong(s5);
		plist.addPlayList(qlist);
		assertEquals(440, plist.getPlayTimeSeconds());
	}
	@Test
	public void testgetNumberofSongsinonePlaylist() {
		plist.addSong(s1);plist.addSong(s2);
		assertEquals(2, plist.numberOfSongs());
	}
	@Test
	public void testgetNumberSongsinMorethanOnePlayList() {
		plist.addSong(s1);qlist.addSong(s2);
		plist.addPlayList(qlist);
		assertEquals(2, plist.numberOfSongs());
	}
	@Test
	public void testgetNumberSongswithMultipleSonginmorethanOnePlaylist() {
		plist.addSong(s1);plist.addSong(s3);plist.addSong(s4);qlist.addSong(s2);
		qlist.addPlayList(plist);
		assertEquals(4, qlist.numberOfSongs());
	}
	@Test
	public void testloadSong() {
		assertEquals(true,plist.loadSongs("listText"));		
	}
	@Test
	public void testloadSongwhenFake() {
		assertFalse(plist.loadSongs("fake.txt"));
	}

}