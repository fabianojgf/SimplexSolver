package simplex.main;

import simplex.model.Constraint;
import simplex.model.ConstraintType;
import simplex.model.Function;
import simplex.model.FunctionType;
import simplex.model.MathModel;
import simplex.model.MathModel;
import simplex.model.SimplexTableu;
import simplex.model.Variable;

public class Main {
	public static void main(String[] args) {
		Constraint c1 = new Constraint()
				.label("teste1")
				.addVariable(new Variable().value(1).label("x1"))
				.addVariable(new Variable().value(2).label("x2"))
				.addVariable(new Variable().value(3).label("x3"))
				.addVariable(new Variable().value(4).label("x4"))
				.addVariable(new Variable().value(5).label("x5"))
				.type(ConstraintType.LE)
				.value(10);
		Constraint c2 = new Constraint()
				.label("teste2")
				.addVariable(new Variable().value(11).label("x1"))
				.addVariable(new Variable().value(12).label("x2"))
				.addVariable(new Variable().value(13).label("x3"))
				.addVariable(new Variable().value(14).label("x4"))
				.addVariable(new Variable().value(15).label("x5"))
				.type(ConstraintType.LE)
				.value(10);
		Constraint c3 = new Constraint()
				.label("teste3")
				.addVariable(new Variable().value(21).label("x1"))
				.addVariable(new Variable().value(22).label("x2"))
				.addVariable(new Variable().value(23).label("x3"))
				.addVariable(new Variable().value(24).label("x4"))
				.addVariable(new Variable().value(25).label("x5"))
				.type(ConstraintType.LE)
				.value(10);
		
		Function f = new Function()
				.type(FunctionType.MAX)
				.addVariable(new Variable().value(1).label("x1"))
				.addVariable(new Variable().value(2).label("x2"))
				.addVariable(new Variable().value(3).label("x3"))
				.addVariable(new Variable().value(4).label("x4"))
				.addVariable(new Variable().value(5).label("x5"))
				.value(10);
		
		MathModel model = new MathModel()
				.function(f)
				.addConstraint(c1)
				.addConstraint(c2)
				.addConstraint(c3);
		
		
		System.out.println(model);
		
		System.out.println();
		System.out.println();
		
		SimplexTableu tableu = new SimplexTableu(model);
		System.out.println(tableu);
	}
}
