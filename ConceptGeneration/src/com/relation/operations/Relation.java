package com.relation.operations;

import java.util.ArrayList;

import com.relation.lattice.Lattice;
import com.relation.utility.Utility;

public class Relation {

	/**
	 * This is the number of row in the relation.
	 */
	private int row;
	/**
	 * This is the number of column in the relation.
	 */
	private int column;
	/**
	 * This two dimensional array represents the relation.
	 */
	private int matrix[][];
	/**
	 * This field represents the type of lattice.
	 */
	private static Lattice lattice;

	/**
	 * This is the default constructor.
	 */
	public Relation() {
		this.row = 0;
		this.column = 0;
	}

	/**
	 * This is the constructor which takes initial parameter to define the
	 * relation.
	 * 
	 * @param row
	 *            the number of row in relation
	 * @param column
	 *            the number of column in relation
	 * @param lattice
	 *            the type of lattice.
	 */
	public Relation(int row, int column, Lattice lattice) {
		this.row = row;
		this.column = column;
		this.lattice = lattice;
		setMatrix(new int[row][column]);
	}

	/**
	 * This method accesses the private field in row.
	 * 
	 * @return the row number.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * This method sets the row in the relation.
	 * 
	 * @param row
	 *            the row number.
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * This method accesses the private field in column.
	 * 
	 * @return the column number.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * This method sets the column in the relation.
	 * 
	 * @param column
	 *            the column number.
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * This methods accesses the private field in matrix.
	 * 
	 * @return the attached matrix with a relation.
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * This method sets the matrix in the relation.
	 * 
	 * @param matrix
	 *            the matrix to attach with the relation.
	 */
	public void setMatrix(int matrix[][]) {
		this.matrix = matrix;
	}

	/**
	 * This method determines the union of two relations with same dimension.
	 * Every element of one relation is compared with the corresponding element
	 * from the other relation and if one of them is true then it writes true in
	 * the output relation.
	 * 
	 * @param relation
	 *            is one of the input relation for union method. The other input
	 *            relation accessed using this operator in java.
	 * @return union of two relation.
	 */
	public Relation Union(Relation relation) {
		if ((this.getRow() != relation.getRow())
				&& (this.getColumn() != relation.getColumn())) {
			System.err
					.println("Union Operation is not possible because number of column is different!");
			return null;
		} else {
			Relation resultRelation = new Relation(relation.getRow(),
					relation.getColumn(), lattice);
			int resultMatrix[][] = null;
			resultMatrix = resultRelation.getMatrix();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					resultMatrix[i][j] = lattice.Join(this.getMatrix()[i][j],
							relation.getMatrix()[i][j]);
				}
			}
			resultRelation.setMatrix(resultMatrix);
			System.out.println("---Union Start----");
			Utility.PrintArray(resultRelation.getMatrix());
			return resultRelation;
		}

	}

	/**
	 * This method determines the intersection of two relation with same
	 * dimension. Every element of one relation is compared with the
	 * corresponding element from the other relation and if both of them is true
	 * then it writes true in the output relation.
	 * 
	 * @param relation
	 *            is one of the input relation for union method. The other input
	 *            relation accessed using this operator in java.
	 * @return intersection of two relation
	 */
	public Relation Intersection(Relation relation) {
		if ((this.getRow() != relation.getRow())
				&& (this.getColumn() != relation.getColumn())) {
			System.err
					.println("Intersection Operation is not possible because number of column is different!");
			return null;
		} else {
			Relation resultRelation = new Relation(relation.getRow(),
					relation.getColumn(), lattice);
			int resultMatrix[][] = null;
			resultMatrix = resultRelation.getMatrix();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					resultMatrix[i][j] = lattice.Meet(this.getMatrix()[i][j],
							relation.getMatrix()[i][j]);
				}
			}
			resultRelation.setMatrix(resultMatrix);
			System.out.println("---Intersection Start----");
			Utility.PrintArray(resultRelation.getMatrix());
			return resultRelation;
		}
	}

	/**
	 * This method calculates the relative multiplication of two relation. The
	 * (x,z) element would be true in the resulting relation if and only if
	 * there exists one element y such that (x,y) is true in the first relation
	 * and (y,z) is true in the other relation.
	 * 
	 * @param relation
	 *            one of the input relation for union method. The other input
	 *            relation accessed using this operator in java.
	 * @return the composition of two relation.
	 */
	public Relation Composition(Relation relation) {
		int resultMatrix[][] = null;

		if (this.getColumn() != relation.getRow()) {
			System.err
					.println("First Relation column should be equal to the second relation row!");
			return null;
		} else {
			Relation resultRelation = new Relation(this.getRow(),
					relation.getColumn(), lattice);
			resultMatrix = resultRelation.getMatrix();

			for (int v = 0; v < this.getColumn(); v++) {
				for (int i = 0; i < this.getRow(); i++) {
					for (int j = 0; j < relation.getColumn(); j++) {
						resultMatrix[i][j] = lattice.Join(
								resultMatrix[i][j],
								lattice.Meet(this.getMatrix()[i][v],
										relation.getMatrix()[v][j]));
					}
				}

			}
			resultRelation.setMatrix(resultMatrix);
			System.out.println("---Composition Start----");
			Utility.PrintArray(resultRelation.getMatrix());
			return resultRelation;
		}
	}

	/**
	 * This method calculates the left residual of two relation R and S (R\S)
	 * which is the greatest of all relation X with (R.X) is the subset of S.
	 * 
	 * @param relation
	 *            one of the input relation for union method. The other input
	 *            relation accessed using this operator in java.
	 * @return the left residue of two relation.
	 */
	public Relation RightResidue(Relation relation) {

		Relation resultRelation = new Relation(this.getColumn(),
				relation.getColumn(), lattice);
		int row = this.getRow();
		for (int i = 0; i < resultRelation.getRow(); i++) {
			for (int j = 0; j < resultRelation.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = lattice.GetOne();
				for (int n = 0; n < row; n++) {
					resultRelation.getMatrix()[i][j] = lattice.Meet(
							resultRelation.getMatrix()[i][j], lattice
									.Implication(this.getMatrix()[n][i],
											relation.getMatrix()[n][j]));
				}
			}
		}
		System.out.println("---Right Start----");
		Utility.PrintArray(resultRelation.getMatrix());
		// System.out.println("---End Left Start----");
		return resultRelation;
	}

	/**
	 * This method calculates the right residual of two relation R and S (R/S)
	 * which is the greatest of all relation X with (X.R) is the subset of S.
	 * 
	 * @param relation
	 *            one of the input relation for union method. The other input
	 *            relation accessed using this operator in java.
	 * @return right residue of two relation.
	 */
	public Relation LeftResidue(Relation relation) {
		Relation resultRelation = new Relation(this.getRow(),
				relation.getRow(), lattice);
		int column = relation.getColumn();
		for (int i = 0; i < resultRelation.getRow(); i++) {
			for (int j = 0; j < resultRelation.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = lattice.GetOne();
				for (int n = 0; n < column; n++) {
					resultRelation.getMatrix()[i][j] = lattice.Meet(
							resultRelation.getMatrix()[i][j], lattice
									.Implication(relation.getMatrix()[j][n],
											this.getMatrix()[i][n]));
				}
			}
		}
		System.out.println("---Left Start----");
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}

	/**
	 * This method creates an entry for each subset. For example, there are a
	 * total of 8 subsets for 3 elements.Then this method creates a relation
	 * with dimension 8 by 3 where row represents each of the subset and column
	 * represents each object. Empty subset contain 0 for every column while
	 * subset with one element contain 1 in the column which represents the
	 * element in the subset.
	 * 
	 * @param element
	 *            no of elements in the set.
	 * @return the epsilon relation for the input.
	 */
	public static Relation Epsilon(int element) {
		// lattice.setNoOfElements(3);
		ArrayList<String> list = new ArrayList<>();

		int row = element;
		int column = (int) Math.pow(lattice.getNoOfElements(), row);

		Relation resultRelation = new Relation(row, column, lattice);
		for (int c = 0; c < column; c++) {
			String singlePair = "";

			int n = c;
			int r = row - 1;
			while (n > 0) {
				int value = n % lattice.getNoOfElements();
				singlePair = singlePair + "," + "(" + r + "," + value + ")";
				resultRelation.getMatrix()[r][c] = value;
				n = n / lattice.getNoOfElements();
				r--;
			}
			list.add(singlePair);

		}
		System.out.println("---Epsilon Start----");
		Utility.PrintArray(resultRelation.getMatrix());

		for (String data : list) {
			System.out.println(data);
		}
		return resultRelation;
	}

	/**
	 * This method calculates the intersection of left residue and right residue
	 * to two relation R and S. Let define R:X-Y and S:X-Z. Then the symmetric
	 * quotient relates an element y from Y to an element z from Z when y and z
	 * have the same set of inverse image with respect to R and S respectively.
	 * 
	 * @param relation
	 *            one of the input relation for union method. The other input
	 *            relation accessed using this operator in java.
	 * @return symmetric quotient of two relation.
	 */
	public Relation SymetricQuotient(Relation relation) {

		Relation right = this.RightResidue(relation);
		System.out.println("--SQ Right--");
		Utility.PrintArray(right.getMatrix());
		System.out.println("--SQ Right End--");
		Relation left = this.Transpose().LeftResidue(relation.Transpose());
		System.out.println("--SQ Left--");
		Utility.PrintArray(left.getMatrix());
		System.out.println("--SQ Left End--");
		return right.Intersection(left);
	}

	/**
	 * This method derives all concepts from a relational data set.
	 * 
	 * @return it returns all concepts in the form of matrix where true
	 *         represent concept.
	 */
	public Relation GenerateConcepts() {

		Relation epsilon = Epsilon(this.getRow());
		System.out.println("----epsilonss----");
		Utility.PrintArray(epsilon.getMatrix());

		Relation epsilonRightRelation = epsilon.RightResidue(this);
		System.out.println("----epsilonRightRelation----");
		Utility.PrintArray(epsilonRightRelation.getMatrix());

		Relation RelationLeftepsilonRightRelation = this
				.LeftResidue(epsilonRightRelation);
		System.out.println("----RelationLeftepsilonRightRelation----");
		Utility.PrintArray(RelationLeftepsilonRightRelation.getMatrix());

		Relation symRelation = RelationLeftepsilonRightRelation
				.SymetricQuotient(epsilon).Down();
		System.out.println("----symRelation----");
		Utility.PrintArray(symRelation.getMatrix());

		Relation identity = IdentityRelation(symRelation.getRow());
		System.out.println("----identityyyy----");
		Utility.PrintArray(identity.getMatrix());

		Relation finalmat = symRelation.Intersection(identity);
		System.out.println("----finalmat----");
		Utility.PrintArray(finalmat.getMatrix());
		System.out.println("----");
		return finalmat;

		/*
		 * return this.RightResidue(Epsilon(this.getRow()).LeftResidue(this))
		 * .SymetricQuotient(Epsilon(this.getRow()))
		 * .Intersection(IdentityRelation(this.getRow()));
		 */
	}

	public Relation GetAttributeSet() {
		// return this.RightResidue(Epsilon(this.getRow())).SymetricQuotient(
		// Epsilon(this.getColumn())).Down();
		return Epsilon(this.getRow()).RightResidue(this).Transpose()
				.SymetricQuotient(Epsilon(this.getColumn())).Down();
		// return this.RightResidue(Epsilon(this.getRow())).Transpose();
	}

	public Relation GenerateConceptsV2() {
		int m = (int) Math.pow(lattice.getNoOfElements(), this.getRow());
		int n = (int) Math.pow(lattice.getNoOfElements(), this.getColumn());

		Relation r1 = this
				.Transpose()
				.LeftResidue(Relation.Epsilon(this.getRow()).Transpose())
				.Composition(Relation.Pi(m, n).Transpose())
				.SymetricQuotient(
						Relation.Epsilon(this.getColumn()).Composition(
								Relation.Rho(m, n).Transpose()));

		Relation r2 = Relation
				.Epsilon(this.getRow())
				.Composition(Relation.Pi(m, n).Transpose())
				.SymetricQuotient(
						this.LeftResidue(
								Relation.Epsilon(this.getColumn()).Transpose())
								.Composition(Relation.Rho(m, n).Transpose()));

		Relation r3 = r1.Intersection(r2).Intersection(
				Relation.IdentityRelation(r1.getRow()));

		return r3;

	}

	/**
	 * This static method returns an identity relation i.e. a square relation
	 * with ones on the main diagonal and zero elsewhere.
	 * 
	 * @param size
	 *            the dimension of matrix. This size is set as the row and
	 *            column of the identity relation.
	 * @return the identity relation with specified dimension.
	 */
	public static Relation IdentityRelation(int size) {
		int dimension = size;
		int[][] matrix = new int[dimension][dimension];
		for (int i = 0; i < dimension; i++)
			matrix[i][i] = lattice.GetOne();
		Relation resultRelation = new Relation(dimension, dimension, lattice);
		resultRelation.setMatrix(matrix);
		System.out.println("---Identity Start----");
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}

	/**
	 * This method flips the relation, that is it switches the row and column by
	 * producing another relation.
	 * 
	 * @return it returns transposed relation
	 */
	public Relation Transpose() {
		Relation r2 = new Relation(this.getColumn(), this.getRow(), lattice);
		for (int i = 0; i < this.getRow(); i++)
			for (int j = 0; j < this.getColumn(); j++)
				r2.getMatrix()[j][i] = this.getMatrix()[i][j];
		Utility.PrintArray(r2.getMatrix());
		return r2;
	}

	/**
	 * This method create a relation with 1 and 0. The relation dimension
	 * depends on the input parameters. For example, if m and n two parameters
	 * in the function then relation consist of (m) rows and (m+n) columns. The
	 * result relation contains 1 for those indexes where row and column
	 * represents same element from m and 0 elsewhere.
	 * 
	 * @param m
	 *            the first parameter.
	 * @param n
	 *            the second parameter.
	 * @return the iota relation consist of 1 and 0.
	 */
	public static Relation Iota(int m, int n) {
		int row = m;
		int column = m + n;
		int[][] matrix = new int[row][column];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				if (r == c)
					matrix[r][c] = 1;
			}
		}
		Relation resultRelation = new Relation();
		resultRelation.setMatrix(matrix);
		return resultRelation;
	}

	/**
	 * This method create a relation with 1 and 0. The relation dimension
	 * depends on the input parameters. For example, if m and n two parameters
	 * in the function then relation consist of (n) rows and (m+n) columns. The
	 * result relation contains 1 for those indexes where row and column
	 * represents same element from n and 0 elsewhere.
	 * 
	 * @param m
	 *            the first parameter.
	 * @param n
	 *            the second parameter.
	 * @return the kappa relation consist of 1 and 0.
	 */
	public static Relation Kappa(int m, int n) {
		int row = n;
		int column = m + n;
		int[][] matrix = new int[row][column];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				if (c == r + n - 1)
					matrix[r][c] = 1;
			}
		}
		Relation resultRelation = new Relation();
		resultRelation.setMatrix(matrix);
		return resultRelation;
	}

	/**
	 * This method create a relation with 1 and 0. The relation dimension
	 * depends on the input parameters. For example, if m and n two parameters
	 * in the function then relation consist of (m*n) rows and (m) columns. The
	 * result relation contains 1 for those indexes which represents the row
	 * element and 0 elsewhere.
	 * 
	 * @param m
	 *            the first parameter.
	 * @param n
	 *            the second parameter.
	 * @return the pi relation consist of 1 and 0.
	 */
	public static Relation Pi(int m, int n) {
		int row = m * n;
		int column = m;
		int[][] matrix = new int[row][column];

		int column_count = 0;
		int row_count = -1;
		for (int r = 0; r < row; r++) {
			row_count++;
			for (int c = 0; c < column; c++) {
				if (c == column_count)
					matrix[r][column_count] = 1;
			}
			if (row_count == n - 1) {
				column_count++;
				row_count = -1;
			}
		}
		Relation resultRelation = new Relation(row, column, lattice);
		resultRelation.setMatrix(matrix);
		Utility.PrintArray(matrix);
		return resultRelation;
	}

	/**
	 * This method create a relation with 1 and 0. The relation dimension
	 * depends on the input parameters. For example, if m and n two parameters
	 * in the function then relation consist of (m*n) rows and (n) columns. The
	 * result relation contains 1 for those indexes which represents the row
	 * element and 0 elsewhere.
	 * 
	 * @param m
	 *            the first parameter.
	 * @param n
	 *            the second parameter.
	 * @return the rho relation consist of 1 and 0.
	 */
	public static Relation Rho(int m, int n) {
		int row = m * n;
		int column = n;
		int[][] matrix = new int[row][column];

		int column_count = 0;
		int row_count = -1;
		for (int r = 0; r < row; r++) {
			row_count++;
			for (int c = 0; c < column; c++) {
				if (c == column_count)
					matrix[r][c] = 1;
			}
			if (row_count == n - 1) {
				row_count = -1;
				column_count = 0;
			} else {
				column_count++;
			}

		}
		Relation resultRelation = new Relation(row, column, lattice);
		resultRelation.setMatrix(matrix);
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}

	/**
	 * This function takes relation as a input. If the relation entry getter than 0 then this makes 
	 * the entry 1 otherwise keep the same.
	 * @return modified matrix with 1 and 0 only
	 */
	public Relation Up() {
		Relation resultRelation = new Relation(this.getRow(), this.getColumn(),
				lattice);
		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = this.getMatrix()[i][j] != 0 ? 1
						: 0;
			}
		}
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}

	public Relation Down() {
		Relation resultRelation = new Relation(this.getRow(), this.getColumn(),
				lattice);
		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = this.getMatrix()[i][j] != 1 ? 0
						: 1;
			}
		}
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}

}
