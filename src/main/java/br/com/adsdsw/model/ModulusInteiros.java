package br.com.adsdsw.model;

/**
* Esta classe contempla a lógica e tratamento 
* para calculos de módulo (ou resto da divisão) de inteiros.
*
* @author  Colab001
* @version 1.0
* @since   05/08/2023
*/

public class ModulusInteiros {
	private int n1;
	private int n2;
	
	public ModulusInteiros() {}
	
	public ModulusInteiros(int n1, int n2) {
		this.setN1(n1);
		this.setN2(n2);
	}
	
	public ModulusInteiros(String n1, String n2) throws Exception {
		try {
			this.setN1(Integer.parseInt(n1));
			this.setN2(Integer.parseInt(n2));
		} catch (Exception e) {
			throw new Exception("Numeros invalidos");
		}
	}
	
	public Double modulusInteiros() throws Exception {
		if (this.getN2() == 0) {
			throw new Exception("Impossivel calcular");
		}
		
		return (double) ((double) Math.floorMod(this.getN1(), this.getN2()));
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
