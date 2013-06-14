public class Test {
	public static void main(String[] args) {
		KnuthMorrisPratt k = new KnuthMorrisPratt();
		String text = "Lorei ipsum dolor sit amet";
		String pattern = "ipsum";
		
		int first_occur_position = k.kmp(text, pattern);
		System.out.println("The text '" + pattern + "' is first found on the " 
                                   + first_occur_position + " position.");
	}
}