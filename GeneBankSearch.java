/**
 * Driver class.
 * @author gabrielcrandall
 */
public class GeneBankSearch {
	
	private static boolean cache = false;
	private static String bTree;
	private static String query;
	private static int cacheSize = 0;
	private static int debug = 0;
	
	public static void main(String[] args) {
		
		//Checks for valid number of arguments
		if (args.length < 3 || args.length > 5) {
			printUsage();
		}
		
		//Checks whether or not to use cache
		if (args[0].equals("1")) {
			cache = true;
			if (args.length >= 4) {
				cacheSize = Integer.parseInt(args[3]);
			}
		} else if (!args[0].equals("0")) {
			printUsage();
		}
		
		//File names
		bTree = args[1];
		query = args[2];
		
		//Debug level
		if (args.length == 5) {
			debug = Integer.parseInt(args[4]);
		}
		
		
		
		
		String degreeString = "";
		String sequenceString = "";
		
		//Find degree of BTree file
		for (int i = bTree.length()-1; i >= 0; i--) {
			char current = bTree.charAt(i);
			if (current != '.') {
				degreeString += current;
			} else {
				break;
			}
		}
		
		degreeString = reverseString(degreeString);
		
		//Find sequence length
		for (int i = bTree.length() - degreeString.length() - 2; i >= 0; i--) {
			char current = bTree.charAt(i);
			if (current != '.') {
				sequenceString += current;
			} else {
				break;
			}
		}
		
		sequenceString = reverseString(sequenceString);
		
		int degree = Integer.parseInt(degreeString);
		int sequence = Integer.parseInt(sequenceString);
		
	}
	
	/****************************************
	 * Utility methods
	****************************************/
	
	/**
	 * Reverses a string using StringBuilder.
	 * @param input
	 * @return reversed string
	 */
	private static String reverseString(String input) {
		StringBuilder builder = new StringBuilder(input);
		return builder.reverse().toString();
	}
	
	/**
	 * Utility method. Prints usage statement and ends program.
	 */
	private static void printUsage() {
		String usageStatement = "Usage: java GeneBankSearch <0/1(no/with Cache)> <btree file> <query file> [<cache size>] [<debug level>]";
		System.err.println(usageStatement);
		System.exit(1);
	}
	
}
