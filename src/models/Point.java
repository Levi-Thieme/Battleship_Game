package models;

public class Point {
	private int X;
	private int Y;
	
	public Point(int x, int y){
		this.X = x;
		this.Y = y;
	}
	
	@Override
	public String toString(){
		return "X: " + X + "  Y: " + Y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

}
