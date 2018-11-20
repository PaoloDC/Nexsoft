package esempioGianlucaLambda;

import java.util.List;

public class Album {
	private List<String> songs;
	private int anno;
	
	public Album(List<String> songs,int anno) {
		this.anno = anno;
		this.songs = songs;
	}
	
	public int getAnno() {
		return anno;
	}
	public List<String> getSongs() {
		return songs;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public void setSongs(List<String> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [songs=" + songs + ", anno=" + anno + "]";
	}	
}
