package prop.assignment0;

public class ExpressionNode implements INode {
	
	private TermNode term;
	private ExpressionNode expression;
	private Lexeme addOrSub;
	private boolean hasAddOrSub = true;
	
	public ExpressionNode(Tokenizer t) throws ParserException {
		try {
			term = new TermNode(t);
		}
		catch(ParserException pe) {
			throw pe;
		}
		//t.moveNext();
		addOrSub = t.current();
		if(addOrSub.token() == Token.ADD_OP || addOrSub.token() == Token.SUB_OP) {
			//t.moveNext();
			try {
				expression = new ExpressionNode(t);
			}
			catch(ParserException pe) {
				throw pe;
			}
		}
		else {
			hasAddOrSub = false;
		}
		
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		TabInserter.tabber(builder, tabs, "ExpressionNode");
		term.buildString(builder, tabs + 1);
		if(hasAddOrSub) {
			TabInserter.tabber(builder, tabs + 1, addOrSub.toString());
			expression.buildString(builder, tabs + 1);
		}
		
	}

}
