package muzika;

import java.util.LinkedList;


public class Muzika {

	private String autor;
	private String pesma;
	private String album;
	private int pozicijaNaMTVListi;
	
	public String getAutor() {
		if (autor != null) {
			return autor;
		} else {
			return "Greska, polje autor ne sme biti prazan string ili null";
		}
	}
	public void setAutor(String autor) throws Exception {
		if (autor != null) {
			this.autor = autor;
		} else {
			throw new Exception();
		}
		
	}
	
	public String getPesma() {
		if ( pesma != null) {
			return pesma;
		} else {
			return "Greska, polje autor ne sme biti prazan string ili null";
		}
	}
	public void setPesma(String pesma) throws Exception {
		if ( pesma != null) {
			this.pesma = pesma;
		} else {
			throw new Exception();
		}
	}
	public String getAlbum() {
		if ( album != null) {
			return album;
		} else {
			return "Greska, polje autor ne sme biti prazan string ili null";
		}
	}
	public void setAlbum(String album) throws Exception {
		if ( album != null) {
			this.album = album;
		} else {
			throw new Exception();
		}
	}
	public int getPozicijaNaMTVListi() {
		if ( pozicijaNaMTVListi > 0) {
			return pozicijaNaMTVListi;
		} else {
			return 0;
		}
	}
	public void setPozicijaNaMTVListi(int pozicijaNaMTVListi) {
		this.pozicijaNaMTVListi = pozicijaNaMTVListi;
	}
	
	public String toString() {
		return "Autor: " + autor +"\n\nPesma:" + pesma +  "\n\nAlbum:"
				+ album + "\n\nPozicija na MTV listi:" + pozicijaNaMTVListi;
	}
	 public boolean equals(Object o) {
		if (o instanceof Muzika) {
			Muzika m = (Muzika) (o);
			if (pesma.equals(m.getPesma())&& autor.equals(m.getAutor())
					&& album.equals(m.getAlbum())&& pozicijaNaMTVListi == m.getPozicijaNaMTVListi()) {
				return true;
			} return false;
		}
		System.out.println("Greska, unesite objekat klase Muzika");
		return false;
	}
	
}
