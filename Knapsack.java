import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int instances = scan.nextInt();
		while (instances-- > 0) {
			// Retrieve data
			int numItems = scan.nextInt();
			int capacity = scan.nextInt();
			int[][] array = new int[numItems + 1][capacity + 1];
			// array initialization
			for (int j = 0; j < numItems + 1; ++j) {
				array[j][0] = 0;
			}
			for (int j = 0; j < capacity + 1; ++j) {
				array[0][j] = 0;
			}
			// update the array
			for (int i = 1; i < numItems + 1; ++i) {
				int weight = scan.nextInt();
				int value = scan.nextInt();
				for (int w = 1; w < capacity + 1; ++w) {
					// Bellman Equation
					if (weight > w) {
						array[i][w] = Math.max(array[i - 1][w], 0);
					} else {
						array[i][w] = Math.max(array[i - 1][w], array[i - 1][w - weight] + value);
					}
				}
			}
			System.out.println(array[numItems][capacity]);
		}
		scan.close();
	}

}
