package prop.assignment0;

public class TermNode implements INode {

	private Tokenizer t;
	private FactorNode factor;
	public TermNode(Tokenizer t) {
		this.t = t;
		factor = new FactorNode(t);
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
	}

}
