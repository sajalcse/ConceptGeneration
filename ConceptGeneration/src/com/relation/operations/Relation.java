package com.relation.operations;

import java.util.ArrayList;

import com.relation.lattice.Lattice;
import com.relation.lattice.ThreeElementLattice;
import com.relation.utility.Utility;

public class Relation implements IRelationOperation, IFormalConceptOperation {

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
	private ArrayList<String> attribute;
	private ArrayList<String> object;

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
		Relation.setLattice(lattice);
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

	public ArrayList<String> getAttribute() {
		return attribute;
	}

	public void setAttribute(ArrayList<String> attribute) {
		this.attribute = attribute;
	}

	public ArrayList<String> getObject() {
		return object;
	}

	public void setObject(ArrayList<String> object) {
		this.object = object;
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
	@Override
	public Relation union(Relation relation) {
		if ((this.getRow() != relation.getRow())
				&& (this.getColumn() != relation.getColumn())) {
			System.err
					.println("Union Operation is not possible because number of column is different!");
			return null;
		} else {
			Relation resultRelation = new Relation(relation.getRow(),
					relation.getColumn(), getLattice());
			int resultMatrix[][] = null;
			resultMatrix = resultRelation.getMatrix();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					resultMatrix[i][j] = getLattice().Join(
							this.getMatrix()[i][j], relation.getMatrix()[i][j]);
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
	public Relation intersection(Relation relation) {
		if ((this.getRow() != relation.getRow())
				&& (this.getColumn() != relation.getColumn())) {
			System.err
					.println("Intersection Operation is not possible because number of column is different!");
			return null;
		} else {
			Relation resultRelation = new Relation(relation.getRow(),
					relation.getColumn(), getLattice());
			int resultMatrix[][] = null;
			resultMatrix = resultRelation.getMatrix();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					resultMatrix[i][j] = getLattice().Meet(
							this.getMatrix()[i][j], relation.getMatrix()[i][j]);
				}
			}
			resultRelation.setMatrix(resultMatrix);
			System.out.println("---Intersection Start----");
			Utility.PrintArray(resultRelation.getMatrix());
			return resultRelation;
		}
	}

	public Relation implication(Relation relation) {
		if ((this.getRow() != relation.getRow())
				&& (this.getColumn() != relation.getColumn())) {
			System.err
					.println("Intersection Operation is not possible because number of column is different!");
			return null;
		} else {
			Relation resultRelation = new Relation(relation.getRow(),
					relation.getColumn(), getLattice());
			int resultMatrix[][] = null;
			resultMatrix = resultRelation.getMatrix();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					resultMatrix[i][j] = getLattice().Implication(
							this.getMatrix()[i][j], relation.getMatrix()[i][j]);
				}
			}
			resultRelation.setMatrix(resultMatrix);
			System.out.println("---Implication Start----");
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
	public Relation composition(Relation relation) {
		int resultMatrix[][] = null;

		System.out.println("Composition:---" + getLattice());
		if (this.getColumn() != relation.getRow()) {
			System.err
					.println("First Relation column should be equal to the second relation row!");
			return null;
		} else {
			Relation resultRelation = new Relation(this.getRow(),
					relation.getColumn(), getLattice());
			resultMatrix = resultRelation.getMatrix();

			for (int v = 0; v < this.getColumn(); v++) {
				for (int i = 0; i < this.getRow(); i++) {
					for (int j = 0; j < relation.getColumn(); j++) {
						
						/*System.out.println(this.getMatrix()[i][v]+","+relation.getMatrix()[v][j]+"="+getLattice().Meet(this.getMatrix()[i][v],
						relation.getMatrix()[v][j]));
						*/
						System.out.println(resultMatrix[i][j]+","+
								getLattice().Meet(this.getMatrix()[i][v],
										relation.getMatrix()[v][j])+"="+getLattice().Join(
								resultMatrix[i][j],
								getLattice().Meet(this.getMatrix()[i][v],
										relation.getMatrix()[v][j])));
						
						resultMatrix[i][j] = getLattice().Join(
								resultMatrix[i][j],
								getLattice().Meet(this.getMatrix()[i][v],
										relation.getMatrix()[v][j]));
						
						
						//System.out.println(resultMatrix[i][j]);
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
	public Relation rightResidue(Relation relation) {

		Relation resultRelation = new Relation(this.getColumn(),
				relation.getColumn(), getLattice());
		int row = this.getRow();
		for (int i = 0; i < resultRelation.getRow(); i++) {
			for (int j = 0; j < resultRelation.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = getLattice().GetOne();
				for (int n = 0; n < row; n++) {
					resultRelation.getMatrix()[i][j] = getLattice().Meet(
							resultRelation.getMatrix()[i][j],
							getLattice().Implication(this.getMatrix()[n][i],
									relation.getMatrix()[n][j]));
				}
			}
		}
		System.out.println("---Right Start----");
		Utility.PrintArray(resultRelation.getMatrix());
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
	public Relation leftResidue(Relation relation) {
		Relation resultRelation = new Relation(this.getRow(),
				relation.getRow(), getLattice());
		int column = relation.getColumn();
		for (int i = 0; i < resultRelation.getRow(); i++) {
			for (int j = 0; j < resultRelation.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = getLattice().GetOne();
				for (int n = 0; n < column; n++) {
					resultRelation.getMatrix()[i][j] = getLattice().Meet(
							resultRelation.getMatrix()[i][j],
							getLattice().Implication(
									relation.getMatrix()[j][n],
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
	public static Relation epsilon(int element) {
		ArrayList<String> list = new ArrayList<>();
		int row = element;
		int column = (int) Math.pow(getLattice().getNoOfElements(), row);
		Relation resultRelation = new Relation(row, column, getLattice());

		for (int c = 0; c < column; c++) {
			String singlePair = "";

			int n = c;
			int r = row - 1;
			while (n > 0) {
				int value = n % getLattice().getNoOfElements();
				singlePair = singlePair + "," + "(" + r + "," + value + ")";
				resultRelation.getMatrix()[r][c] = value;
				n = n / getLattice().getNoOfElements();
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

	public static Relation epsilon(int element, ArrayList<String> attribute) {
		ArrayList<String> list = new ArrayList<>();

		int row = element;
		int column = (int) Math.pow(getLattice().getNoOfElements(), row);
		Relation resultRelation = new Relation(row, column, getLattice());
		System.out.println(getLattice().getNoOfElements());
		for (int c = 0; c < column; c++) {
			String singlePair = "";

			int n = c;
			int r = row - 1;
			while (n > 0) {
				int value = n % getLattice().getNoOfElements();

				if (getLattice().getNoOfElements() == 2) {

					if (value > 0)
						singlePair = attribute.get(r) + "," + singlePair;
				} else {
					if (value > 01)
						singlePair = singlePair + "," + value + "/"
								+ attribute.get(r);
				}

				resultRelation.getMatrix()[r][c] = value;
				n = n / getLattice().getNoOfElements();
				r--;
			}
			list.add(singlePair);

		}
		System.out.println("---Epsilon Start----");
		Utility.PrintArray(resultRelation.getMatrix());

		for (String data : list) {
			if (!data.equals(""))
				System.out.println("{" + data.substring(0, data.length() - 1)
						+ "}");
			else
				System.out.println("{}");
		}
		return resultRelation;
	}
	
	public static ArrayList<String> subSetList( ArrayList<String> attribute) {
		ArrayList<String> list = new ArrayList<>();

		int row = attribute.size();
		int column = (int) Math.pow(getLattice().getNoOfElements(), row);
		for (int c = 0; c < column; c++) {
			String singlePair = "";

			int n = c;
			int r = row - 1;
			while (n > 0) {
				int value = n % getLattice().getNoOfElements();

				if (getLattice().getNoOfElements() == 2) {

					if (value > 0)
						singlePair = attribute.get(r) + "," + singlePair;
				} else {
					if (value > 01)
						singlePair = singlePair + "," + value + "/"
								+ attribute.get(r);
				}
				n = n / getLattice().getNoOfElements();
				r--;
			}
			list.add(singlePair);

		}
		ArrayList<String> subset = new ArrayList<String>();
		for (String data : list) {
			if (!data.equals("")){
				subset.add("{" + data.substring(0, data.length() - 1)
						+ "}");
			System.out.println("{" + data.substring(0, data.length() - 1)
						+ "}");}
				
			else
				subset.add("{}");
		}
		return subset;
	}
	
	public static ArrayList<String> generateObjectAttributePair(ArrayList<String> obj,ArrayList<String> att)
	{
		ArrayList<String> objectSubset = subSetList(obj);
		ArrayList<String> attributeSubset = subSetList(att);
		for (String singleObj : objectSubset) {
			for(String singleAtt : attributeSubset)
			{
				System.out.println("( "+singleObj+","+singleAtt+" )");
			}
		}
		return null;
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
	public Relation symetricQuotient(Relation relation) {

		Relation right = this.rightResidue(relation);
		System.out.println("--SQ Right--");
		Utility.PrintArray(right.getMatrix());
		System.out.println("--SQ Right End--");
		Relation left = this.transpose().leftResidue(relation.transpose());
		System.out.println("--SQ Left--");
		Utility.PrintArray(left.getMatrix());
		System.out.println("--SQ Left End--");
		return right.intersection(left);
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
	public static Relation identity(int size) {
		int dimension = size;
		int[][] matrix = new int[dimension][dimension];
		for (int i = 0; i < dimension; i++)
			matrix[i][i] = getLattice().GetOne();
		Relation resultRelation = new Relation(dimension, dimension,
				getLattice());
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
	public Relation transpose() {
		Relation r2 = new Relation(this.getColumn(), this.getRow(),
				getLattice());
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
	public static Relation pi(int m, int n) {
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
		Relation resultRelation = new Relation(row, column, getLattice());
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
	public static Relation rho(int m, int n) {
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
		Relation resultRelation = new Relation(row, column, getLattice());
		resultRelation.setMatrix(matrix);
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}

	/**
	 * This function takes relation as a input. If the relation entry getter
	 * than 0 then this makes the entry 1 otherwise keep the same.
	 * 
	 * @return modified matrix with 1 and 0 only
	 */
	public Relation up() {
		Relation resultRelation = new Relation(this.getRow(), this.getColumn(),
				getLattice());
		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = this.getMatrix()[i][j] != 0 ? 1
						: 0;
			}
		}
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}

	/**
	 * This function takes relation as a input. If the relation entry equal to 1
	 * then this makes the entry 1 otherwise keep the same.
	 * 
	 * @return modified matrix with 1 and 0 only
	 */
	public Relation down() {
		Relation resultRelation = new Relation(this.getRow(), this.getColumn(),
				getLattice());
		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = this.getMatrix()[i][j] != 1 ? 0
						: 1;
			}
		}
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}

	public Relation getEquivalence() {
		Relation r = this.removeZero();
		System.out.println("--tst--");
		Utility.PrintArray(r.getMatrix());
		return r;
	}

	private Relation removeZero() {
		// TODO Auto-generated method stub
		boolean isZero = true;
		ArrayList<Integer> nonZeroRow = new ArrayList<>();
		for (int i = 0; i < this.getRow(); i++) {
			for (int j = 0; j < this.getColumn(); j++) {
				if (this.getMatrix()[i][j] > 0) {
					isZero = false;
					break;
				}
			}
			if (!isZero) {
				nonZeroRow.add(i);
				isZero = true;
			}
		}

		int[][] newMatrix = new int[nonZeroRow.size()][this.getColumn()];

		for (int i = 0; i < nonZeroRow.size(); i++) {
			int row = nonZeroRow.get(i);
			for (int col = 0; col < this.getColumn(); col++) {
				newMatrix[i][col] = this.getMatrix()[row][col];
			}
		}

		Relation r = new Relation(nonZeroRow.size(), this.getColumn(),
				getLattice());
		r.setMatrix(newMatrix);
		return r;
	}

	
	
	public Relation Not()
	{
		
		int[][] matrix = new int[this.getRow()][this.getColumn()];
		Relation resultRelation = new Relation(this.getRow(),this.getColumn(),
				getLattice());
		for(int i=0;i<this.getRow();i++)
			for(int j=0;j<this.getColumn();j++)
				matrix[i][j] = this.getMatrix()[i][j] == 1 ? 0 : 1;
		resultRelation.setMatrix(matrix);
		System.out.println("---Not Start----");
		Utility.PrintArray(resultRelation.getMatrix());
		return resultRelation;
	}
	
	
	// ------------------------------------***************************-----------------------------------------
									// Relational Operations End Here
	// ------------------------------------***************************-----------------------------------------

	/**
	 * This method derives all concepts from a relational data set.
	 * 
	 * @return it returns all concepts in the form of matrix where true
	 *         represent concept.
	 */
	private Relation generateConcepts() {

		Relation epsilon = epsilon(this.getRow());
		System.out.println("----epsilonss----");
		Utility.PrintArray(epsilon.getMatrix());

		Relation epsilonRightRelation = epsilon.rightResidue(this);
		System.out.println("----epsilonRightRelation----");
		Utility.PrintArray(epsilonRightRelation.getMatrix());

		Relation RelationLeftepsilonRightRelation = this
				.leftResidue(epsilonRightRelation);
		System.out.println("----RelationLeftepsilonRightRelation----");
		Utility.PrintArray(RelationLeftepsilonRightRelation.getMatrix());

		// ------------------------------------this changes for the proof of
		// alternative formula---------------------
		/*
		 * Relation symRelation = RelationLeftepsilonRightRelation
		 * .SymetricQuotient(epsilon).Down();
		 */
		// ------------------------------------end------------------------------------------------------------------
		Relation symRelation = RelationLeftepsilonRightRelation
				.symetricQuotient(epsilon);
		System.out.println("----symRelation----");
		Utility.PrintArray(symRelation.getMatrix());

		Relation identity = identity(symRelation.getRow());
		System.out.println("----identityyyy----");
		Utility.PrintArray(identity.getMatrix());

		Relation finalmat = symRelation.intersection(identity);
		System.out.println("----finalmat----");
		Utility.PrintArray(finalmat.getMatrix());
		System.out.println("----");
		return finalmat;

	}

	public Relation generateExtentConcepts() {
		return this.generateConcepts();
	}

	public Relation generateIntentConcepts() {
		return this.transpose().generateConcepts();
	}

	public Relation generateAllConcepts() {
		int m = (int) Math.pow(getLattice().getNoOfElements(), this.getRow());

		int n = (int) Math
				.pow(getLattice().getNoOfElements(), this.getColumn());

		System.out.println(getLattice());
		Relation r1 = this
				.transpose()
				.leftResidue(Relation.epsilon(this.getRow()).transpose())
				.composition(Relation.pi(m, n).transpose())
				.symetricQuotient(
						Relation.epsilon(this.getColumn()).composition(
								Relation.rho(m, n).transpose()));

		Relation r2 = Relation
				.epsilon(this.getRow())
				.composition(Relation.pi(m, n).transpose())
				.symetricQuotient(
						this.leftResidue(
								Relation.epsilon(this.getColumn()).transpose())
								.composition(Relation.rho(m, n).transpose()));

		Relation r3 = r1.intersection(r2).intersection(
				Relation.identity(r1.getRow()));

		return r3;

	}

	public Relation generateConceptsV2Modified() {

		Relation r1 = this.transpose()
				.leftResidue(Relation.epsilon(this.getRow()).transpose())
				.symetricQuotient(Relation.epsilon(this.getColumn()));

		Relation r2 = Relation.epsilon(this.getRow())
				.symetricQuotient(
						this.leftResidue(Relation.epsilon(this.getColumn())
								.transpose()));

		Relation r3 = r1.intersection(r2);
		return r3;

	}

	public Relation generateConceptsV2Own() {

		Relation r1 = epsilon(this.getRow()).rightResidue(this).transpose()
				.symetricQuotient(epsilon(this.getColumn()));
		Relation r = this.transpose();
		Relation r2 = epsilon(r.getRow()).rightResidue(r).transpose()
				.symetricQuotient(epsilon(r.getColumn())).transpose();
		Relation x = r1.intersection(r2);

		return x;

	}

	public Relation generateConceptsV3() {
		int m = (int) Math.pow(getLattice().getNoOfElements(), this.getRow());

		int n = (int) Math
				.pow(getLattice().getNoOfElements(), this.getColumn());

		return Relation
				.pi(m, n)
				.composition(
						Relation.epsilon(this.getRow()).symetricQuotient(
								Relation.epsilon(this.getRow())))
				.composition(this.generateExtentConcepts())
				.composition(this.getAttributeSet())
				.composition(
						Relation.epsilon(this.getColumn()).symetricQuotient(
								Relation.epsilon(this.getColumn())))
				.composition(Relation.rho(m, n).transpose())
				.intersection(Relation.identity(m * n));
	}

	public Relation generateConceptsV3Modified() {

		return Relation
				.epsilon(this.getRow())
				.symetricQuotient(Relation.epsilon(this.getRow()))
				.composition(this.generateExtentConcepts())
				.composition(this.getAttributeSet())
				.composition(
						Relation.epsilon(this.getColumn()).symetricQuotient(
								Relation.epsilon(this.getColumn())));

	}

	public Relation generateFullConcept() {
		int m = (int) Math.pow(getLattice().getNoOfElements(), this.getRow());

		int n = (int) Math
				.pow(getLattice().getNoOfElements(), this.getColumn());

		return pi(m, n)
				.composition(this.getObjectPrime())
				.composition(Relation.rho(m, n).transpose())
				.intersection(
						rho(m, n).composition(this.getAttributePrime())
								.composition(Relation.pi(m, n).transpose()))
				.intersection(identity(m * n));

	}
	public Relation generateObjectConcept() {
		Relation r = this.getObjectPrime().composition(this.getAttributePrime());
		return r.intersection(identity(r.getRow()));

	}
	public Relation generateAttributeConcept() {
		Relation r = this.getAttributePrime().composition(this.getObjectPrime());
		return r.intersection(identity(r.getRow()));

	}

	public Relation generateImplicationsDegree() {
		int element = (int) Math.pow(getLattice().getNoOfElements(),
				this.getColumn());
		Relation e = this.generateIntentConcepts().up().getEquivalence();
		Relation q = Relation
				.pi(element, element)
				.composition(
						Relation.epsilon(this.getColumn()).rightResidue(
								Relation.epsilon(this.getColumn())))
				.composition(e.transpose());
		Relation r = Relation
				.rho(element, element)
				.composition(
						Relation.epsilon(this.getColumn()).rightResidue(
								Relation.epsilon(this.getColumn())))
				.composition(e.transpose());
		Relation s = q.implication(r).composition(e)
				.composition(this.generateIntentConcepts())
				.composition(e.transpose());
		Relation relL = new Relation(1, e.getRow(), new ThreeElementLattice());
		int[][] L = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		relL.setMatrix(L);
		Relation ss = s.leftResidue(relL);
		return ss;
	}

	public Relation generateImplicationsDegree(Relation a1, Relation b1) {
		Relation a = a1.attributeToPowerset().down();
		Relation b = b1.attributeToPowerset().down();
		Relation e = this.generateIntentConcepts().up().getEquivalence();
		Relation q = a.composition(
				Relation.epsilon(this.getColumn()).rightResidue(
						Relation.epsilon(this.getColumn()))).composition(
				e.transpose());
		Relation r = b.composition(
				Relation.epsilon(this.getColumn()).rightResidue(
						Relation.epsilon(this.getColumn()))).composition(
				e.transpose());
		Relation s = q.implication(r).composition(e)
				.composition(this.generateIntentConcepts())
				.composition(e.transpose());
		Relation relL = new Relation(1, e.getRow(), new ThreeElementLattice());
		int[][] L = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		relL.setMatrix(L);
		Relation ss = s.leftResidue(relL);
		return ss;
	}

	public Relation generateImplicationsDegreeV2(Relation a, Relation b) {
		Relation A = a;// .AttributeToPowerset();
		Relation B = b;// .AttributeToPowerset();
		Relation rr = B.composition(epsilon(3).rightResidue(epsilon(3)))
				.composition(A.composition(this.getPrimePrime()).transpose());
		return rr;

	}

	public Relation generateImplicationsDegreeV2() {

		Relation rr = pi(27, 27).composition(
				epsilon(3).rightResidue(epsilon(3))).composition(
				rho(27, 27).composition(this.getPrimePrime()).transpose());
		System.out.println("---" + rr.getColumn() + "---" + rr.getRow());
		return rr;

	}

	
	public static Relation e(int m)
	{
		return epsilon(m).rightResidue(epsilon(m));
	}
	
	
	
	
	
	
	public Relation getPrimePrime() {

		Relation epsilon = epsilon(this.getRow());
		System.out.println("----epsilonss----");
		Utility.PrintArray(epsilon.getMatrix());

		Relation epsilonRightRelation = epsilon.rightResidue(this);
		System.out.println("----epsilonRightRelation----");
		Utility.PrintArray(epsilonRightRelation.getMatrix());

		Relation RelationLeftepsilonRightRelation = this
				.leftResidue(epsilonRightRelation);
		System.out.println("----RelationLeftepsilonRightRelation----");
		Utility.PrintArray(RelationLeftepsilonRightRelation.getMatrix());

		Relation symRelation = RelationLeftepsilonRightRelation
				.symetricQuotient(epsilon);
		System.out.println("----symRelation----");
		Utility.PrintArray(symRelation.getMatrix());

		return symRelation;

	}

	public Relation attributeToPowerset() {

		return this.transpose().symetricQuotient(epsilon(this.getRow()));

	}

	public Relation getAttributeSet() {

		return epsilon(this.getRow()).rightResidue(this).transpose()
				.symetricQuotient(epsilon(this.getColumn())).down();

	}

	public Relation getObjectPrime() {
		return this.transpose().leftResidue(epsilon(this.getRow()).transpose())
				.symetricQuotient(epsilon(this.getColumn())).down();
	}

	public Relation getAttributePrime() {
		return this.transpose().getPrime();
		// return
		// this.LeftResidue(Epsilon(this.getColumn()).Transpose()).SymetricQuotient(Epsilon(this.getRow())).Down();
	}

	public Relation getPrime() {
		return this.transpose().leftResidue(epsilon(this.getRow()).transpose())
				.symetricQuotient(epsilon(this.getColumn()));
	}

	public static Lattice getLattice() {
		return lattice;
	}

	public static void setLattice(Lattice lattice) {
		Relation.lattice = lattice;
	}

}
