import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author mark
 *
 */
public class JSedUtils {
	
	// a simplistic regex for parsing a single line of well formed CSV with two columns
	private static final String CSV_REGEXP = "\"(.*)\",\"(.*)\"";

	private static final Pattern CSV_PATTERN = Pattern.compile(CSV_REGEXP);
	
	
	public static String[] parseCSV(String csv) {

	    Matcher m = CSV_PATTERN.matcher(csv);

	    String[] result = new String[2];
	    if(m.find()) {
	    	result[0] = m.group(1);
	    	result[1] = m.group(2);
	    	return result;
	    } else {
	    	// panic!
	    	throw new RuntimeException("Could not parse the following CSV: " +csv);
	    }
	
	}
	
	
	public static String readFile(String fileName) throws Exception {
		return readFile(new File(fileName));
	}
	
	public static String readFile(File file) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = null;
		StringBuffer fileContents = new StringBuffer();
		
		while( (line = reader.readLine()) != null ) {
			fileContents.append(line);
			fileContents.append(System.getProperty("line.separator"));
		}
		
		reader.close();
		return fileContents.toString();
	}
	
	public static void writeFile(File file, String data) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(data);
		writer.close();
	}
	
	public static String performReplace(String input, String search, String replace) {
		Pattern pattern = Pattern.compile(search, Pattern.MULTILINE+Pattern.DOTALL+Pattern.COMMENTS);
		Matcher matcher = pattern.matcher(input);
		return matcher.replaceAll(replace);
	}
	
	public static void main(String[] args) throws Exception {
		
		if(args.length != 2 && args.length != 3) {
			System.out.println("Usage: java JSed input-file search replace");		
			System.out.println("or     java JSed input-file expression-file");		
			return;
		}

				
		String inputFile = args[0];
		
		if(args.length == 3) {
			String search = args[1];
			String replace = args[2];
			System.out.println(performReplace(readFile(inputFile), search, replace));
		} else if (args.length == 2) {
			String expressionFile = args[1];
			String expressionsStr = readFile(expressionFile);
			String[] expressions = expressionsStr.split(System.getProperty("line.separator"));
			
			String data = readFile(inputFile);
			
			for (int i = 0; i < expressions.length; i++) {
				String anExpression = expressions[i];
				String[] anExpressionSplit = anExpression.split(" ");
				String search = anExpressionSplit[0];
				String replace = anExpressionSplit[1];
				data = performReplace(data, search, replace);
			}
			
			System.out.println(data);
			
		}

	}

}
