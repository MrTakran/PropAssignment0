package prop.assignment0;



public class StatementsNode implements INode {

	private StatementsNode statement;
	private AssignmentNode assignment;
	
	public StatementsNode(Tokenizer t) throws ParserException {
		
		
		boolean buildStatements = true;
		
		try {
			assignment = new AssignmentNode(t);
			t.moveNext();
			statement = new StatementsNode(t);
		}
		catch(ParserException pe) {
			if(pe.getMessage().equals("No_Id")) {
				assignment = null;
				statement = null;
			}
			else {
				throw pe;
			}
		}		
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		if(assignment != null) {
			assignment.evaluate(args);
			statement.evaluate(args);
			
		}
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		TabInserter.tabber(builder, tabs, "StatementsNode");
		if(assignment != null) {
			assignment.buildString(builder, tabs + 1);
			statement.buildString(builder, tabs + 1);
		}

	}
	
	
}
