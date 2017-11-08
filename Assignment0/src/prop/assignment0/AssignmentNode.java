package prop.assignment0;

public class AssignmentNode implements INode {

	private Tokenizer t;
	private ExpressionNode expression;
	public AssignmentNode(Tokenizer t) {
		this.t = t;
		expression = new ExpressionNode(t);
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
	}

}
