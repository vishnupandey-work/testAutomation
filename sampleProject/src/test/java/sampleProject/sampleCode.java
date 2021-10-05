package sampleProject;

public class sampleCode {

	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rows = 15;
		int columns = 10;
		int[][] Matrix = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Matrix[i][j] = getRandomNumber(0, rows * columns);
				System.out.print(Matrix[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.println("Distance matrix");
		for (int k = 0; k < rows; k++) {
			for (int i = 0; i < rows; i++) {
				double distance = 0.0;
				if (i == k) {
					continue;
				} else {
					for (int j = 0; j < columns; j++) {
						distance = distance + Math.pow(Matrix[i][j] - Matrix[k][j], 2);
					}
				}
				double DistanceActual = Math.sqrt(distance);
				System.out.println("Distance from Row" + k + " to Row " + i + " is :" + DistanceActual);
			}
		}

	}
}
