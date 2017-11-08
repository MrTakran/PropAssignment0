package prop.assignment0;

public class StatementsNode implements INode {

	
	private AssignmentNode assignment;
	public StatementsNode(Tokenizer t) throws ParserException {
		assignment = new AssignmentNode(t);
		
		
		
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
	}

}
