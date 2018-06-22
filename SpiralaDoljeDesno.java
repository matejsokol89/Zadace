
public class SpiralaDoljeDesno {
	public static void main(String[] args) {
		int prviBroj = 5;
		int[][] spirala = new int[prviBroj][prviBroj];

		int vrijednost = 1;
		int minStupac = 0;
		int minRed = 0;
		int maxStupac = prviBroj - 1;
		int maxRed = prviBroj-1;

		kraj:
		while (vrijednost <= prviBroj * prviBroj) {
			
			for (int i = maxStupac; i >= minStupac; i--) {
				spirala[maxRed][i] = vrijednost;
				vrijednost++;
				if (vrijednost > prviBroj * prviBroj) {
					break kraj;
				}
				
			}
			for (int i = maxRed -1 ; i >= minRed; i--) {
				spirala[i][minStupac] = vrijednost;
				vrijednost++;
				if (vrijednost > prviBroj * prviBroj) {
					break kraj;
				}
			}
			for (int i = minStupac +1; i <= maxStupac; i++) {
				spirala[minRed][i] = vrijednost;
				vrijednost++;
				if (vrijednost > prviBroj * prviBroj) {
					break kraj;
				}
			}
			for (int i = minRed + 1; i < maxRed ; i++) {
				spirala[i][maxStupac] = vrijednost;
				vrijednost++;
				if (vrijednost > prviBroj * prviBroj) {
					break kraj;
				}
			}
			maxRed--;
			maxStupac--;
			minRed++;
			minStupac++;
		}
		for (int i = 0; i < prviBroj; i++) {
			for (int j = 0; j < prviBroj; j++) {
				System.out.print(spirala[i][j] + "\t");
			}
			System.out.println();

		}

	}
}
