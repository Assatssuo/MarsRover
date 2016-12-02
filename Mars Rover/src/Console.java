import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int comando = 1;
		List<Rover> Rovers = new ArrayList();
		int vetorX;
		int vetorY;

		System.out.println("Infome o tamanho do vetor x do plateau:");
		vetorX = scan.nextInt();
		System.out.println("Infome o tamanho do vetor y do plateau:");
		vetorY = scan.nextInt();

		Plateau plateau = new Plateau(vetorX, vetorY);

		while (comando != 0) {
			System.out.println("Infome o numero da ação a ser executada:");
			System.out.println("0-Sair");
			System.out.println("1-Adicionar Rover");
			System.out.println("2-Dar comandos ao ultimo Rover adicionado");
			comando = scan.nextInt();

			switch (comando) {
			case 0:
				for (int i = 0; i < vetorX; i++) {
					for (int j = 0; j < vetorY; j++) {
						if (Rovers.contains(plateau.getGrid()[i][j])) {
							System.out.println(i + " " + j + " " + plateau.getGrid()[i][j].getDirection());
						}
					}
				}
				break;
			case 1:
				int x;
				int y;
				char d;
				System.out.println(
						"Informe a posição do Rover no vetor x considerando que os vetores vao de 0 à tamanho do vetor - 1");
				x = scan.nextInt();
				System.out.println(
						"Informe a posição do Rover no vetor y considerando que os vetores vao de 0 à tamanho do vetor - 1");
				y = scan.nextInt();
				System.out.println("Informe a direção que o rover está virando");
				d = scan.next().charAt(0);
				//System.out.println(d);
				Rovers.add(plateau.addRover(x, y, d));

				break;
			case 2:
				String comandos;
				System.out.println("Informe os comandos a serem adicionados");
				comandos = scan.next();
				Rover atual = new Rover('Q');
				for (int i = 0; i < vetorX; i++) {
					for (int j = 0; j < vetorY; j++) {
						if (Rovers.get(Rovers.size() - 1).equals(plateau.getGrid()[i][j])) {
							atual = plateau.getGrid()[i][j];
						}
					}
				}
				if (atual.getDirection() != 'q') {
					atual.command(comandos, plateau);
				}
				break;
			}
		}
	}
}
