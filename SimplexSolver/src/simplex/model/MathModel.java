package simplex.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@SuppressWarnings("unused")
public class MathModel {
	Function function;
	List<Constraint> constraints;
	
	public MathModel function(Function function) {
		this.function = function;
		return this;
	}
	
	public MathModel constraints(Constraint[] constraints) {
		for(Constraint c : constraints) {
			this.constraints.add(c);
		}
		return this;
	}
	
	public MathModel addConstraint(Constraint constraint) {
		if(this.constraints == null)
			this.constraints = new ArrayList<Constraint>();
		this.constraints.add(constraint);
		return this;
	}
	
	public int getNumVariables() {
		return function.variables.size();
	}
	
	public int getNumConstraints() {
		return constraints.size();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append(function)
				.append("\n")
				.append("ST");
		for(int i = 0; i < constraints.size(); i++) {
			builder.append("\n")
				.append(constraints.get(i));
		}
		return builder.toString();
	}
}
