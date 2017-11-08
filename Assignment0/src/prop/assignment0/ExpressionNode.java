package prop.assignment0;

public class ExpressionNode implements INode {
	
	private Tokenizer t;
	private TermNode term;
	public ExpressionNode(Tokenizer t) {
		this.t = t;
		term = new TermNode(t);
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
	}

}
