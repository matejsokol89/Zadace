package edunova.svjetsko;

public class Okrsaj {
	private Timovi domacin;
	private Timovi gost;
	private int golDomacin;
	private int golGost;
	private String postigoGol;

	
	public String getPostigoGol() {
		return postigoGol;
	}

	public void setPostigoGol(String postigoGol) {
		this.postigoGol = postigoGol;
	}

	public Okrsaj(Timovi gost, Timovi domacin) {
		this.domacin=domacin;
		this.gost=gost;
	}
	
	public void print(){
		System.out.println(domacin.getNaziv() + " - " + gost.getNaziv() + " (" + getGolDomacin() + ":" + getGolGost() + ")");	
	}
	@Override
	public String toString() {
		return domacin.getNaziv() + " - " + gost.getNaziv() + " (" + getGolDomacin() + ":" + getGolGost() + ")";
	}
	
	public void printGolgeter() {
		System.out.println(postigoGol);
		
	}
	public Timovi getDomacin() {
		return domacin;
	}
	public void setDomacin(Timovi domacin) {
		this.domacin = domacin;
	}
	public Timovi getGost() {
		return gost;
	}
	public void setGost(Timovi gost) {
		this.gost = gost;
	}
	public int getGolDomacin() {
		return golDomacin;
	}
	public void setGolDomacin(int golDomacin) {
		this.golDomacin = golDomacin;
	}
	public int getGolGost() {
		return golGost;
	}
	public void setGolGost(int golGost) {
		this.golGost = golGost;
	}

	

}
