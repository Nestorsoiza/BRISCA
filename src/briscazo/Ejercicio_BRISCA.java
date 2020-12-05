package briscazo;

public class Ejercicio_BRISCA {

	public static void main(String[] args) {
		Baraja b = new Baraja();
		System.out.println("Hay " + b.cartasDisponible() + " cartas disponibles");
		b.siguienteCarta();
		b.darCartas(5);
		
		System.out.println("Hay " + b.cartasDisponible() + " cartas disponibles");
		System.out.println("Cartas sacadas de momento");
		b.cartasMonton();
		b.barajar();
		Carta[] cartas = b.darCartas(5);
		
		System.out.println("Cartas sacadas despues de barajar ");
		for (int i = 0; i < cartas.length; i++) {
			System.out.println(cartas[i]);
		}
	
	
	
	}

}
