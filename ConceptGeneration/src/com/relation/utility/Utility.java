package com.relation.utility;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 
 * @author sajal
 *
 */
public class Utility {
	/**
	 * This method prints a two dimensional array in the form of row and column
	 * @param data is the input array to print.
	 */
	public static void PrintArray(int[][] data) {
		int row = data.length;
		int column = data[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	

	public static void Write(int[][] data) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			
			
			int row = data.length;
			int column = data[0].length;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					writer.print(String.valueOf(data[i][j])+" ");
				}
				writer.println();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


