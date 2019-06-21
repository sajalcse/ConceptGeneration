package com.relation.utility;

public class Utility {
	public static void PrintArray(boolean[][] a) {
		int x = a.length;
		int y = a[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(a[i][j] + "\t");
			}

			System.out.println("\n");
		}
	}

}
