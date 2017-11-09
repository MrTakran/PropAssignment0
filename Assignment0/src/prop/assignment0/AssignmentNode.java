package prop.assignment0;

public class AssignmentNode implements INode {

	private ExpressionNode expression;
	private Lexeme id;
	private Lexeme assignOp;
	private Lexeme semiColon;
	
	public AssignmentNode(Tokenizer t) throws ParserException{
		id = t.current();
		if(id.token() != Token.IDENT) {
			throw new ParserException("No_Id");
		}
		t.moveNext();
		assignOp = t.current();
		if(assignOp.token() != Token.ASSIGN_OP) {
			throw new ParserException("Assign_Operator_Missing");
		}
		try {
			expression = new ExpressionNode(t);
		}
		catch(ParserException pe) {
			throw pe;
		}
		//t.moveNext();
		semiColon = t.current();
		if(semiColon.token() != Token.SEMICOLON) {
			System.out.println(semiColon.toString());
			throw new ParserException("No_Semicolon");
		}
		
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		TabInserter.tabber(builder, tabs, "AssignmentNode");
		
		TabInserter.tabber(builder, tabs + 1, id.toString());
		TabInserter.tabber(builder, tabs + 1, assignOp.toString());
		expression.buildString(builder, tabs + 1);
		TabInserter.tabber(builder, tabs + 1, semiColon.toString());
		
		
	}

}
