package simplex.model;

public class Variable {
	double value;
	String label;
	
	public Variable label(String label) {
		this.label = label;
		return this;
	}
	
	public Variable value(double value) {
		this.value = value;
		return this;
	}
}
