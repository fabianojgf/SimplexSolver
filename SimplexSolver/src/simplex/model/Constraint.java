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
public class Constraint {
	String label;
	List<Variable> variables;
	ConstraintType type;
	double value;
	
	public Constraint label(String label) {
		this.label = label;
		return this;
	}
	
	public Constraint type(ConstraintType type) {
		this.type = type;
		return this;
	}
	
	public Constraint value(double value) {
		this.value = value;
		return this;
	}
	
	public Constraint variables(List<Variable> variables) {
		if(this.variables == null)
			this.variables = new ArrayList<Variable>();
		this.variables.addAll(variables);
		return this;
	}
	
	public Constraint variables(Variable[] variablesArray) {
		if(this.variables == null)
			this.variables = new ArrayList<Variable>();
		for(Variable v : variablesArray)
			this.variables.add(v);
		return this;
	}
	
	public Constraint addVariable(Variable variable) {
		if(variables == null)
			variables = new ArrayList<Variable>();
		variables.add(variable);
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("[").append(label).append("]")
				.append("\t");
		
		for(int i = 0; i < variables.size(); i++) {
			builder.append((variables.get(i).value >= 0 ? variables.get(i).value : "(" + variables.get(i).value + ")"))
					.append(variables.get(i).label);
			if(i < variables.size() - 1)
				builder.append(" + ");
		}
		
		builder.append(" ")
			.append(type.toString())
			.append(" ")
			.append((value >= 0 ? value : "(" + value + ")"));
		
		return builder.toString();
	}
}