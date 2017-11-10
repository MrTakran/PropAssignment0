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
		
		addOrSub = t.current();
		if(addOrSub.token() == Token.ADD_OP || addOrSub.token() == Token.SUB_OP) {
			
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
		double value = (double)term.evaluate(args);
		if(hasAddOrSub) {
			double expValue = (double)expression.evaluate(args);
			if(addOrSub.token() == Token.ADD_OP) {
				value += expValue;
			}
			else {
				value -= expValue;
			}
		}
		
		return value;
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
