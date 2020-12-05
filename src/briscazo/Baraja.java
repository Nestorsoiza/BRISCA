package briscazo;

public class Baraja {
	private Carta cartas[];
	private int posSiguienteCarta;
	
	public static final int NUM_CARTAS = 40;
	
	public Baraja() {
		this.cartas = new Carta[NUM_CARTAS];
		this.posSiguienteCarta = 0;
		crearBaraja();
		barajar();
	}

	
	private void crearBaraja() {
		String[] palos = Carta.PALOS;
		for (int i = 0; i < palos.length; i++) {
			for (int j = 0; j < Carta.LIMITE_CARTA_PALO; j++) {
				if (!(j == 7 || j == 8)) {
					if (j >= 9) {
						cartas[((i * (Carta.LIMITE_CARTA_PALO - 2)) + (j - 2))] 
								= new Carta(j + 1, palos[i]);
					}else {
						cartas[((i * (Carta.LIMITE_CARTA_PALO - 2)) + (j))] 
								= new Carta(j + 1, palos[i]);
					}
				}
			}
		}
	}
	
	public void barajar() {
		int posAleatoria = 0;
		Carta c;
		for (int i = 0; i < cartas.length; i++) {//recorro las cartas
			posAleatoria = Metodos.generaNumeroEnteroAleatorio(0, NUM_CARTAS -1);
			//intercambio
			c = cartas[i];
			cartas[i] = cartas[posAleatoria];
			cartas[posAleatoria] = c;
		}
		this.posSiguienteCarta = 0;//vuelve al inicio
	}

	public Carta siguienteCarta() {
		Carta c = null;
		if (posSiguienteCarta == NUM_CARTAS) {
			System.out.println("Ya no hay más cartas, baraja de nuevo");
		} else {
			c = cartas[posSiguienteCarta++];
		}
		return c;
		
	}
	public Carta[] darCartas(int numCartas) {
		if (numCartas > NUM_CARTAS) {
			System.out.println("No se pueden dar más cartas de las que hay");
		} else if (cartasDisponible() < numCartas) {
			System.out.println("No hay suficientes cartas que mostrar");
		}else {
			Carta[]cartasDar = new Carta[numCartas];
			//recorro el array que acabo de crear para rellenarlo
			for (int i = 0; i < cartasDar.length; i++) {
				cartasDar[i] = siguienteCarta();
			}
			return cartasDar;
		}
			return null;
		}
	public int cartasDisponible() {
		return NUM_CARTAS - posSiguienteCarta;
	}
	public void cartasMonton() {
		if (cartasDisponible() == NUM_CARTAS) {
			System.out.println("No se ha sacado ninguna carta");
		} else {
			//recorro desde 0 a la posSiguienteCarta
			for (int i = 0; i < posSiguienteCarta; i++) {
				System.out.println(cartas[i]);
			}
		}
	}
	public void mostrarBaraja() {
		if (cartasDisponible() == 0) {
			System.out.println("No hay cartas que mostrar");
		} else {
			for (int i = posSiguienteCarta; i < cartas.length; i++) {
				System.out.println(cartas[i]);
			}
		}
	}
}
