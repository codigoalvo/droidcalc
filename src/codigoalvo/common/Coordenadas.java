package codigoalvo.common;

import java.io.Serializable;

public class Coordenadas implements Serializable {

	private static final long serialVersionUID = 8433781257356352504L;
	private double x;
	private double y;

	public Coordenadas(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
}
