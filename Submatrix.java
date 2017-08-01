# Submatrix
public class MaxSquareSubMatrix1 {

	public void subMatrix(int[][] arrA, int row, int cols) {
		int[][] sub = new int[row][cols];
	
		for (int i = 0; i < cols; i++) {
			sub[0][i] = arrA[0][i];
		}
	
		for (int i = 0; i < row; i++) {
			sub[i][0] = arrA[i][0];
		}


		for (int i = 1; i < row; i++) {
			for (int j = 1; j < cols; j++) {
				if (arrA[i][j] == 1) {
					sub[i][j] = Math.min(sub[i - 1][j - 1],
							Math.min(sub[i][j - 1], sub[i - 1][j])) + 1;
				} else {
					sub[i][j] = 0;
				}
			}
		}

		int Size = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				if (sub[i][j] > Size) {
					Size = sub[i][j];
				}
			}
		}
		System.out.println("Maximum size square sub-matrix with all 1s: " + Size);
	}
	public static void main(String[] args) {
		int[][] arrA = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
		MaxSquareSubMatrix i = new MaxSquareSubMatrix();
		i.subMatrix(arrA, 5, 6);
	}
}
