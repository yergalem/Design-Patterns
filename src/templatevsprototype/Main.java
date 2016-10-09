package templatevsprototype;

public class Main {

	public static void main(String[] args) {
		

		VerticalLetters vletters = new VerticalLetters();
        System.out.println("Letter A:");
		vletters.drawAlphabet();
		System.out.println("Letter B:");
		Asymmetric asym = new Asymmetric();
		asym.drawAlphabet();
		System.out.println("Letter C:");
		
		HorizontalLetters hletters = new HorizontalLetters();
		hletters.drawAlphabet();
	}
}