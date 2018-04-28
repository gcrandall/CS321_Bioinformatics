/**
 * Class that represents a key within a BTree. Has data and a frequency.
 * @author gabrielcrandall
 *
 */
public class TreeKey implements Comparable<TreeKey> {
	
	private long data;
	private int frequency;
	
	/****************************************
	 * Constructors
	****************************************/
	
	/**
	 * Constructor. Creates key with given data/key.
	 * @param data
	 * @param frequency
	 */
	public TreeKey(long data, int freq) {
		this.data = data;
		this.frequency = freq;
	}
	
	/**
	 * Constructor. Creates key with given data and frequency of 1.
	 * @param data
	 */
	public TreeKey(long data) {
		this(data, 1);
	}
	
	/****************************************
	 * Getters/Setters
	****************************************/
	
	/**
	 * Returns data.
	 * @return data
	 */
	public long getData() {
		return data;
	}
	
	/**
	 * Returns frequency.
	 * @return frequency
	 */
	public int getFrequency() {
		return frequency;
	}
	
	/**
	 * Increases frequency by one.
	 */
	public void incrementFrequency() {
		this.frequency++;
	}
	
	/****************************************
	 * Overridden methods
	****************************************/
	
	@Override
	public int compareTo(TreeKey other) {
		int result;
		
		if (data == other.data) {
			result = 0;
		} else if (data > other.data) {
			result = 1;
		} else {
			result = -1;
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("key: " + data + " | frequency: " + frequency);
		return result.toString();
	}
	
}
