package br.com.adsdsw.model;

public class SubtraiInteiros {
	private int n1;
	private int n2;
	
	public SubtraiInteiros() {}
	
	public SubtraiInteiros(int n1, int n2) {
		this.setN1(n1);
		this.setN2(n2);
	}
	
	public SubtraiInteiros(String n1, String n2) {
		this.setN1(Integer.parseInt(n1));
		this.setN2(Integer.parseInt(n2));
	}
	
	public Double subtraiInteiros() {
		return (double) ((double) this.getN1() - this.getN2());
	}
	
	public int getN1() {
		return n1;
	}
	
	public int getN2() {
		return n2;
	}
	
	public void setN1(int n1) {
		this.n1 = n1;
	}
	
	public void setN2(int n2) {
		this.n2 = n2;
	}

}
