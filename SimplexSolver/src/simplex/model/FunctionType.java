package simplex.model;

public enum FunctionType {
	MAX("MAX"), MIN("MIN");
	
	private String symbol;
	
	FunctionType(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
}
