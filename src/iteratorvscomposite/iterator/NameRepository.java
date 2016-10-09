package iteratorvscomposite.iterator;

import java.util.Arrays;

import javax.xml.ws.Response;

interface Aggregate {
	public Iterator getIterator();
}

interface Iterator {
	public boolean hasNext();

	public Object next();
}
/**
 * Multidimentional NameRepository with custom iterator. The iterator iterates row level.
 * 
 * @author Yergalem
 *
 */

public class NameRepository implements Aggregate {
	private String[][] names = { { "Sam", "Smith" }, { "Robert", "-" }, { "James", "Gosling" } };

	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator {
		int index;
        
		
		@Override
		public boolean hasNext() {

			if (index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
            String[] str;
			if (this.hasNext()) {
				str = names[index];
				String[] nonRemoved = new String[ names[index].length ];
				for (int i = 0, j=0; i < str.length; i++,j++) {
					if( str[i].equals("-") )  // Removed Item Indicator up on call of remove operation
						continue;
					nonRemoved[j] = str[i];
				}
				
				index++;
				return nonRemoved;
			}
			return null;
		}
	}

	public static void main(String[] args) {

		NameRepository repository = new NameRepository();

		Iterator itr = repository.getIterator();

		while (itr.hasNext()) {
			System.out.println( Arrays.toString(( String[]) itr.next() ));
		}

	}

}