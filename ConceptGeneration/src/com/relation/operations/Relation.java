package com.relation.operations;

public class Relation {
	private int row;
	private int column;
	private boolean matrix[][];

	public Relation(int row, int column) {
		this.setRow(row);
		this.setColumn(column);
		setMatrix(new boolean[this.row][this.column]);
	}

	public Relation() {
		this.row = 0;
		this.column = 0;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(boolean matrix[][]) {
		this.matrix = matrix;
	}

	public Relation Union(Relation r1) {
		if ((this.getRow() != r1.getRow())
				&& (this.getColumn() != r1.getColumn())) {
			System.out.println("Matrix are incompatiable");
			return null;
		} else {
			Relation resultRelation = new Relation(r1.getRow(), r1.getColumn());
			boolean resultMatrix[][] = null;
			resultMatrix = resultRelation.getMatrix();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					resultMatrix[i][j] = (this.getMatrix()[i][j])
							|| (r1.getMatrix()[i][j]);
				}
			}
			resultRelation.setMatrix(resultMatrix);
			return resultRelation;
		}

	}

	public Relation Intersection(Relation r1) {
		if ((this.getRow() != r1.getRow())
				&& (this.getColumn() != r1.getColumn())) {
			System.out.println("Matrix are incompatiable");
			return null;
		} else {
			Relation resultRelation = new Relation(r1.getRow(), r1.getColumn());
			boolean resultMatrix[][] = null;
			resultMatrix = resultRelation.getMatrix();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					resultMatrix[i][j] = this.getMatrix()[i][j]
							&& r1.getMatrix()[i][j];
				}
			}
			resultRelation.setMatrix(resultMatrix);
			return resultRelation;
		}
	}

	public Relation Composition(Relation r1) {
		boolean resultMatrix[][] = null;

		if (this.getColumn() != r1.getRow()) {
			System.out.println("A:Rows: " + this.getColumn()
					+ " did not match B:Columns " + r1.getRow() + ".");
			return null;
		} else {
			Relation resultRelation = new Relation(this.getRow(),
					r1.getColumn());
			resultMatrix = resultRelation.getMatrix();

			for (int v = 0; v < this.getColumn(); v++) {
				for (int i = 0; i < this.getRow(); i++) {
					for (int j = 0; j < r1.getColumn(); j++) {
						resultMatrix[i][j] = resultMatrix[i][j]
								|| (this.getMatrix()[i][v] && r1.getMatrix()[v][j]);
					}
				}

			}
			resultRelation.setMatrix(resultMatrix);
			return resultRelation;
		}
	}

	public boolean Implication(boolean p, boolean q) {
		return !p || q;
	}

	public Relation LeftResidue(Relation r1) {
		Relation resultRelation = new Relation(this.getColumn(), r1.getColumn());
		int m = this.getRow();
		for (int i = 0; i < resultRelation.getRow(); i++) {
			for (int j = 0; j < resultRelation.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = true;
				for (int n = 0; n < m; n++) {
					resultRelation.getMatrix()[i][j] = resultRelation
							.getMatrix()[i][j]
							&& Implication(this.getMatrix()[n][i],
									r1.getMatrix()[n][j]);
				}
			}
		}
		return resultRelation;
	}

	public Relation RightResidue(Relation r1) {
		Relation resultRelation = new Relation(this.getRow(), r1.getRow());
		int m = r1.getColumn();
		for (int i = 0; i < resultRelation.getRow(); i++) {
			for (int j = 0; j < resultRelation.getColumn(); j++) {
				resultRelation.getMatrix()[i][j] = true;
				for (int n = 0; n < m; n++) {
					resultRelation.getMatrix()[i][j] = resultRelation
							.getMatrix()[i][j]
							&& Implication(r1.getMatrix()[j][n],
									this.getMatrix()[i][n]);
				}
			}
		}
		return resultRelation;
	}

	public static Relation Epsilon(int m) {
		int row = m;
		int column = (int) Math.pow(2, row);
		Relation resultRelation = new Relation(row, column);
		for (int c = 0; c < column; c++) {
			int n = c;
			int r = row - 1;
			while (n > 0) {
				resultRelation.getMatrix()[r][c] = n % 2 == 1;
				n = n / 2;
				r--;
			}

		}
		return resultRelation;
	}

	public Relation SymetricQuotient(Relation r1) {
		return this.LeftResidue(r1).Intersection(
				this.Transpose().RightResidue(r1.Transpose()));
	}

	public Relation GenerateConcepts() {
		return this.RightResidue(Epsilon(this.getRow()).LeftResidue(this))
				.SymetricQuotient(Epsilon(this.getRow()))
				.Intersection(IdentityRelation(this.getRow()));
	}

	public static Relation IdentityRelation(int m) {
		int n = (int) Math.pow(2, m);
		boolean[][] a = new boolean[n][n];
		for (int i = 0; i < n; i++)
			a[i][i] = true;
		Relation resultRelation = new Relation(n, n);
		resultRelation.setMatrix(a);
		return resultRelation;
	}

	public Relation Transpose() {
		Relation r2 = new Relation(this.getColumn(), this.getRow());
		for (int i = 0; i < this.getRow(); i++)
			for (int j = 0; j < this.getColumn(); j++)
				r2.getMatrix()[j][i] = this.getMatrix()[i][j];
		return r2;
	}

}
