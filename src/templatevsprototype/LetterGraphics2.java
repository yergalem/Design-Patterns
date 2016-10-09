package templatevsprototype;

abstract class MyTemplates {

	char[][] lettersMatrix = new char[10][20];

	enum Symmetry {
		VERTICAL, NONE, HORIZONTAL
	};

	public final void templateMethod() {
		getSymmetry();
		getPartialImage();
		reconstruct();
		printComplete();
	}

	abstract Symmetry getSymmetry();

	abstract char[][] getPartialImage();

	private void reconstruct() {
		Symmetry rplane = getSymmetry();
		char[][] p = getPartialImage();
		switch (rplane) {

		case VERTICAL:
			for (int i = 0; i < 14; i++)
				for (int j = 9, k = 0; j > 5; j--, k++)
					lettersMatrix[i][j] = p[i][k];

			break;

		case HORIZONTAL:
			for (int i = 0; i < 14; i++)
				for (int j = 9, k = 0; j > 5; j--, k++)
					lettersMatrix[i][j] = p[i][k];
			break;

		case NONE:
			for (int i = 8; i < 19; i++) // last one is all dashed as first
				for (int j = 9, k = 0; j > 5; j--, k++)
					lettersMatrix[i][j] = p[i][k];
			break;

		}
	};

	public void printComplete() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				char ch = lettersMatrix[i][j] != ' ' ? lettersMatrix[i][j] : '-';

				System.out.println(ch);
			}
			
			System.out.println();
		}
	}


//class VerticalLetterss extends MyTemplate {
//
//	char[][] bArray = new char[][]{
//	
//	          {'-','-','-','-','-'},
//	          {'-','-','-','-','+'},
//	          {'-','-','-','+','+'},
//	          {'-','-','+','+','-'},
//	          {'-','-','+','+','-'},
//	          {'-','+','+','-','-'},
//	          {'-','+','+','-','-'},
//	          {'-','+','+','-','-'},
//	          {'-','+','+','+','+'},
//	          {'-','+','+','-','-'},
//	          {'-','+','+','-','-'},
//	          {'-','+','+','-','-'},
//	          {'-','+','+','-','-'},
//	          {'-','+','+','-','-'} };
//
//	@Override
//	Symmetry getSymmetry() {
//		return Symmetry.VERTICAL;
//	}
//
//	@Override
//	char[][] getPartialImage() {
//		for (int i = 5; i < 18; i++) { // last one is all dashed as first		
//		  for (int j = 0; j < 5; j++) {
//			if( j == 1 || j == 2 
//			    ||( i == 9 && j!=0)  )
//			    bArray[i][j] = '+';
//		        bArray[i][j] = '-';		      
//		    
//		}
//		  
//	    for (int k = 1; k < 4; k++) { // last one is all dashed as first		
//		    for (int j = 0; j < 5; j++) {
//		    	
//		    }
//		   
//	    }
//	}
//
//}

//class HorizontallLetterss extends MyTemplate {
//
//	char[][] bArray = new char[14][9];
//
//	@Override
//	Symmetry getSymmetry() {
//		return Symmetry.HORIZONTAL;
//	}
//
//	@Override
//	char[][] getPartialImage() {
//
//		return null;
//	}
//
//}
//
//class Asymmetrics extends MyTemplate {
//
//	// HardCoded to B
//	char[][] bArray = new char[8][9];
//
//	@Override
//	Symmetry getSymmetry() {
//		return Symmetry.NONE;
//
//	}
//
//	@Override
//	char[][] getPartialImage() {
//
//		return null;
//	}

}
