package fiuba.algo3.ejemplos.modelo;

public class Vector {

	@Override
	public int hashCode() {
		final int prime = 31;
		float result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return (int)result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	private float x;
	private float y;
	
	public Vector(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getY() {
		return y;
	}

	public float getX() {
		return x;
	}
	
	public Vector invertir(){
		return new Vector(this.x * -1, this.y * -1);
	}
	
	public Vector por(int escalar){
		return new Vector(this.x * escalar, this.y * escalar);
	}
	
	public Vector mas(Vector otroVector){
		return new Vector(this.x + otroVector.x, this.y + otroVector.y);
	}
	
	
}
