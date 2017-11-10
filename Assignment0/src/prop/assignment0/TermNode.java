package prop.assignment0;

import java.util.ArrayList;

public class TermNode implements INode {

	private FactorNode factor;
	private Lexeme multOrDiv;
	private TermNode term;
	private boolean hasMultOrDiv = true;
	
	public TermNode(Tokenizer t) throws ParserException {
		try {
			factor = new FactorNode(t);
		}
		catch(ParserException pe) {
			throw pe;
		}
		t.moveNext();
		multOrDiv = t.current();
		if(multOrDiv.token() == Token.MULT_OP || multOrDiv.token() == Token.DIV_OP) {
			
			try {
				term = new TermNode(t);
			}
			catch(ParserException pe){
				throw pe;
			}
			
		}
		else {
			hasMultOrDiv = false;
		}
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		double value = (double)factor.evaluate(args);
		
		if(hasMultOrDiv) {
			if(args.length == 1) {
				ArrayList<Lexeme> calcList = new ArrayList<Lexeme>();
				calcList.add(multOrDiv);
				term.evaluate(new Object[] {args[0], calcList});
				for (int i = 0; i < calcList.size(); i++)
				{
					Token operator = calcList.get(i).token();
					i++;
					if (operator == Token.MULT_OP)
					{
						value *= (double)calcList.get(i).value();
					}
					else
					{
						value /= (double)calcList.get(i).value();
					}
				}
				return value;
			}
			else {
				ArrayList<Lexeme> calcList = (ArrayList<Lexeme>)args[1];
				calcList.add(new Lexeme(value, Token.INT_LIT));
				calcList.add(multOrDiv);
				term.evaluate(args);
				return null;
			}
		}
		if (args.length == 1)
		{
			return value;
		}
		else
		{
			ArrayList<Lexeme> calcList = (ArrayList<Lexeme>)args[1];
			calcList.add(new Lexeme(value, Token.INT_LIT));
			return null;
		}
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		TabInserter.tabber(builder, tabs, "TermNode");
		factor.buildString(builder, tabs + 1);
		if(hasMultOrDiv) {
			TabInserter.tabber(builder, tabs + 1, multOrDiv.toString());
			term.buildString(builder, tabs + 1);
		}
	}

}
