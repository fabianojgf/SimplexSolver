package simplex.model;

import java.util.HashMap;

public class SimplexTableu {
	FunctionType objectiveType;
	double[] objective;
	
	double[][] matrix;
	ConstraintType[] constTypes;
	double[] b;
	
	String[] constLabels;
	String[] varLabels;
	HashMap<String, Integer> varLabelsHash;
	
	public SimplexTableu(MathModel mathModel) {
		//Objective
		
		objectiveType = mathModel.function.type;
		
		objective = new double[mathModel.function.variables.size()];
		varLabels = new String[mathModel.function.variables.size()];
		varLabelsHash = new HashMap<String, Integer>();
		
		for(int j = 0; j < mathModel.function.variables.size(); j++) {
			objective[j] = mathModel.function.variables.get(j).value;
			varLabels[j] = mathModel.function.variables.get(j).label;
			varLabelsHash.put(mathModel.function.variables.get(j).label, j);
		}
		
		//Constraints
		
		matrix = new double[mathModel.constraints.size()][mathModel.function.variables.size()];
		constLabels = new String[mathModel.constraints.size()];
		constTypes = new ConstraintType[mathModel.constraints.size()];
		b = new double[mathModel.constraints.size()];
		
		for(int i = 0; i < mathModel.constraints.size(); i++) {
			Constraint c = mathModel.constraints.get(i);
			for(int k = 0; k < c.variables.size(); k++) {
				Integer j = varLabelsHash.get(c.variables.get(k).label);
				matrix[i][j] = c.variables.get(k).value;
			}
			constLabels[i] = c.label;
			constTypes[i] = c.type;
			b[i] = c.value;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(objectiveType).append(" ");
		for(int j = 0; j < objective.length; j++) {
			builder.append(objective[j]).append(" ");
		}
		
		builder.append("\n");
		builder.append("ST");
		builder.append("\n");
		
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < objective.length; j++) {
				builder.append(matrix[i][j]).append(" ");
			}
			builder.append(constTypes[i]).append(" ");
			builder.append(b[i]);
			builder.append("\n");
		}
		
		return builder.toString();
	}
}
