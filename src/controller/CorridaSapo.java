package controller;

public class CorridaSapo {
	
	 final static int num_sapo = 5;
	final static int distancia = 100;
	
	public static void main(String[]args) {
		for (int i = 1; i <= num_sapo; i++) {
      new SapoCorrendoThread ("sapo_" + i, distancia).start();
		}
	}

} 

class SapoCorrendoThread extends Thread {
	
	String nome;
	int distancia = 0;
	int distanciaT;
	int pulo =0;
	int pulos = 0;
	static int colocacao = 0;
	final static int puloM = 50;
	
	public SapoCorrendoThread (String nome, int distanciaT) {
		super(nome);
		this.distanciaT = distanciaT;
		this.nome = nome;
	}
	
	public void SapoImprime () {
		System.out.println(" O " + nome + " pulou " + pulo + " cm \t e ja percorreu " +
	                         distancia + " cm");
	}
	
	public void SapoPulando() {
		pulos++;
		pulo = (int) (Math.random()* puloM);
		distancia += pulo;
		if (distancia > distanciaT) {
			distancia = distanciaT;
		}
		
		
	}
	
	public void SapoDescansando() {
		 Thread.yield();
		
 }
	
	public void ColocacaoSapo () {
		colocacao++;
	System.out.println(nome + " foi o " + colocacao + "º colocado com" +
		                pulos + " pulos");
	
	}
	
	public void run() {
		while (distancia < distanciaT) {
			SapoPulando();
			SapoImprime();
			SapoDescansando();
			try {
				sleep (100);	
				}catch (InterruptedException e) {}
				
					try {
					sleep (1000);
				}catch (InterruptedException e) {}
			
			
		}
		ColocacaoSapo();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}