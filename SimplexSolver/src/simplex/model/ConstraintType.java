package simplex.model;

public enum ConstraintType {
	LT("<"), LE("<="), EQ("="), GE(">="), GT(">");
	
	private String symbol;
	
	ConstraintType(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
}
