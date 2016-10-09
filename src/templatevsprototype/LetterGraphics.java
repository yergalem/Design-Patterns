package templatevsprototype;

/**
 * Provides the template method by which sub classes expose their implementation
 * so that AAlphabetGraphics class calls corresponding methods a template method
 * for every concrete classes. Subclasses inform their symmetry and the abstract
 * class reconstructs and completes the partial image based on symmetry.
 * 
 * Besides, it provides default printing of result.
 * 
 * @author Yergalem
 *
 */
abstract class AAlphabetGraphics {

	char[][] lettersMatrix = new char[20][10];

	enum Symmetry {
		VERTICAL, NONE, HORIZONTAL
	};

	public final void drawAlphabet() {
		getSymmetry();
		getPartialImage();
		reconstruct();
		printComplete();
	}

	abstract Symmetry getSymmetry();

	abstract char[][] getPartialImage();

	private void reconstruct() {
		Symmetry rplane = getSymmetry();
		char[][] partial = getPartialImage();

		switch (rplane) {

		case VERTICAL:
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 5; j++)
					lettersMatrix[i][j] = partial[i][j];

			}
			for (int i = 0; i < 14; i++) {
				for (int j = 9, k = 0; j > 4; j--, k++)
					lettersMatrix[i][j] = partial[i][k];

			}
			break;

		case HORIZONTAL:
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 9; j++)
					lettersMatrix[i][j] = partial[i][j];

			}
			for (int i = 1; i < 8; i++) {
				for (int j = 0; j < 9; j++)
					lettersMatrix[20 - i - 7][j] = partial[i][j];

			}

			break;
		case NONE:
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 9; j++)
					lettersMatrix[i][j] = partial[i][j];

			}
			break;

		}
	}

	public void printComplete() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				char ch = lettersMatrix[i][j] != '\u0000' ? lettersMatrix[i][j] : '-';

				System.out.print(ch);
			}

			System.out.println();
		}
	}

}

class VerticalLetters extends AAlphabetGraphics {

	char[][] vArray = new char[][] {

			{ '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '+' }, { '-', '-', '-', '+', '+' },
			{ '-', '-', '+', '+', '-' }, { '-', '-', '+', '+', '-' }, { '-', '+', '+', '-', '-' },
			{ '-', '+', '+', '-', '-' }, { '-', '+', '+', '-', '-' }, { '-', '+', '+', '+', '+' },
			{ '-', '+', '+', '-', '-' }, { '-', '+', '+', '-', '-' }, { '-', '+', '+', '-', '-' },
			{ '-', '+', '+', '-', '-' }, { '-', '+', '+', '-', '-' } };

	@Override
	Symmetry getSymmetry() {
		return Symmetry.VERTICAL;
	}

	@Override
	char[][] getPartialImage() {
		return vArray;
	}

}

class HorizontalLetters extends AAlphabetGraphics {

	char[][] hArray = new char[][] { { '-', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '+', '+', '+', '+', '-', '-' }, { '-', '-', '+', '+', '-', '-', '+', '+', '-' },
			{ '-', '+', '+', '-', '-', '-', '-', '+', '+' }, { '-', '+', '+', '-', '-', '-', '-', '-', '-' },
			{ '-', '+', '+', '-', '-', '-', '-', '-', '-' }, { '-', '+', '+', '-', '-', '-', '-', '-', '-' },
			{ '-', '+', '+', '-', '-', '-', '-', '-', '-' } };

	@Override
	Symmetry getSymmetry() {
		return Symmetry.HORIZONTAL;
	}

	@Override
	char[][] getPartialImage() {

		return hArray;
	}

}

class Asymmetric extends AAlphabetGraphics {

	// HardCoded to B
	char[][] aArray = new char[][] { { '-', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '+', '+', '+', '+', '+', '-', '-', '-' }, { '-', '+', '+', '-', '-', '+', '+', '-', '-' },
			{ '-', '+', '+', '-', '-', '-', '+', '+', '-' }, { '-', '+', '+', '-', '-', '-', '+', '+', '-' },
			{ '-', '+', '+', '-', '-', '-', '+', '+', '-' }, { '-', '+', '+', '-', '-', '+', '+', '-', '-' },
			{ '-', '+', '+', '+', '+', '+', '+', '-', '-' }, { '-', '+', '+', '-', '-', '-', '+', '+', '-' },
			{ '-', '+', '+', '-', '-', '-', '-', '+', '+' }, { '-', '+', '+', '-', '-', '-', '-', '+', '+' },
			{ '-', '+', '+', '-', '-', '-', '-', '+', '+' }, { '-', '+', '+', '-', '-', '-', '+', '+', '-' },
			{ '-', '+', '+', '+', '+', '+', '+', '-', '-' } };

	@Override
	Symmetry getSymmetry() {
		return Symmetry.NONE;

	}

	@Override
	char[][] getPartialImage() {

		return aArray;
	}

}
