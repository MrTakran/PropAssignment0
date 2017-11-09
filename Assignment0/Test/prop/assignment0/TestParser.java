package prop.assignment0;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import  org.junit.Test;

public class TestParser {

	@Test
	public void testParser() {
		
		Parser p = new Parser();
		try {
			p.open("C:\\Users\\Sebastian\\Documents\\GitHub\\PropAssignment0\\PropAssignment0\\Assignment0\\src\\program2.txt");
			BlockNode block = (BlockNode)p.parse();
			StringBuilder sb = new StringBuilder();
			block.buildString(sb, 0);
			BufferedWriter writer = null;
			try
			{
			    writer = new BufferedWriter( new FileWriter("A_Nice_ParseTree.txt"));
			    writer.write(sb.toString());

			}
			catch ( IOException e)
			{
			}
			finally
			{
			    try
			    {
			        if ( writer != null)
			        writer.close( );
			    }
			    catch ( IOException e)
			    {
			    }
			}
			//System.out.print(sb.toString());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
