package iteratorvscomposite;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class HTMLTokenizer2 {

	private Reader reader = null;

	private int peekc;
	private boolean pushedBack = false;
	private boolean forceLower = false;
	private boolean parseEntity = false;

	/**
	 * After a call to the <code>nextToken</code> method, the field ttpye
	 * contains the type of the token just read. Its value is one of the following:
	 * <ul>
	 * <li><code>TT_EOF</code> indicates that the end of the input stream
	 *     has been reached.
	 * <li><code>TT_TAG</code> indicates that the token is an HTML tag.
	 * <li><code>TT_ENTITY</code> indicates that the token is an HTML entity.
	 * <li><code>TT_TEXT</code> indicates that the token is text 
between HTML tagsList.
	 * </ul>
	 *
	 */

	private int ttype = TT_NOTHING;

	/**
	 * A constant indicating that the end of the stream has been read. In the case of
	 * an open-ended tag or open-ended entity (because of invalid HTML), this
	 * constant will be returned.
	 */
	public static final int TT_EOF = -1;
	/**
	 * A constant indicating that an HTML tag has been read.
	 */
	public static final int TT_TAG = -2;
	/**
	 * A constant indicating that an HTML entity has been read.
	 */
	public static final int TT_ENTITY = -3;
	/**
	 * A constant indicating that raw text has been read.
	 */
	public static final int TT_TEXT = -4;

	private static final int TT_NOTHING = -6;

	/**
	 * This field contains a string giving the characters of the current
	 * token. When the current token is an HTML tag, this field contains
	 * the contents of the tag (without the angle brackets.)
	 * <p>
	 * Likewise, if the current token is an entity, this field contains
	 * the text of the entity between the &amp; and ; characters.
	 * <p>
	 * All leading and trailing whitespace will be removed from the string.
	 */
	private String sval;	// string of current token

	/**
	 * creates an HTMLTokenizer for a Reader input stream
	 */
	public HTMLTokenizer2(Reader r) {
		reader = r;
	}

	/**
	 * creates an HTMLTokenizer for a file with a given url.  If the url string
	 * doesn't start with "http://", then the string is considered as a local file name.
	 */
	public HTMLTokenizer2(String url) throws FileNotFoundException,
											MalformedURLException,
											IOException {

		if (url == null)
			throw new MalformedURLException("url string is null");

		if (url.indexOf("http://") != 0) { //open local file
			FileReader fr = new FileReader(url);
			reader = fr;
		}
		else { // fetch file at url
			URL u = new URL(url);
			BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
			reader = br;
		}
	}

	/**
	 * entityMode(false) indicates that html entities should be treated as normal text.  The default is false.
	 */
	public void entityMode(boolean flag) {
		parseEntity = flag;
	}

	/**
	 * lowerCaseMode(true) indicates that all tokens should be returned as lower-case.
	 * The default is false.
	 */
	public void lowerCaseMode(boolean flag) {
		forceLower = flag;
	}

	/** Read the next character */
	private int read() throws IOException {
		return reader.read();
	}

	/**
	 * If the type is TT_TEXT, TT_TAG, or TT_ENTITY, the corresponding text will be returned.
	 * Otherwise, null will be returned. For type TT_TEXT, the text returned will be the
	 * text between tagsList and entities (or including entities if entityMode is false).
	 * For TT_TAG, the text between the opening and closing brackets will be returned.
	 * For TT_ENTITY, the text between the opening ampersand and the closing
	 * semi-colon will be returned.
	 */
	public String getToken() {
		if ((ttype == TT_NOTHING) || (ttype == TT_EOF))
     		return null;
     	return sval;
	}

	/**
	 * nextToken() returns the type of the token read.  To get the string of the token, use
	 * getToken().
	 */
	public int nextToken() throws IOException {
		if (pushedBack) {
			pushedBack = false;
			return ttype;
		}

		char buf[] = new char[20];
		int i = 0;

		int c, stop1 = -1, stop2 = -1;

		if (ttype == TT_NOTHING)
			c = read();
		else c = peekc;

		sval = null;

		if (c < 0)
			return ttype = TT_EOF;

		while (c <= ' ') { // ignore whitespace b/w tokens
			c = read();
			if (c < 0)	// check for EOF
				return ttype = TT_EOF;
		}

		if (c == '<') {
			ttype = TT_TAG;
			stop1 = '>';
		}
		else if ((parseEntity) && (c == '&')) {
			ttype = TT_ENTITY;
			stop1 = ';';
		}
		else {
			ttype = TT_TEXT;
			buf[i++] = (char) c;
			stop1 = '<';
			if (parseEntity) stop2 = '&';
		}

		c = read();	// move past previous c
		while ((c > 0) && (c != stop1) && (c != stop2)) {
			if ((c == '\n') || (c == '\r')) { // skip new lines
				c = read();
				continue;
			}

			if (i >= buf.length) {
				char nb[] = new char[buf.length * 2];
				System.arraycopy(buf, 0, nb, 0, buf.length);
				buf = nb;
			}

			buf[i++] = (char) c;
			c = read();
		}

		if ((c < 0) && (ttype != TT_TEXT)) return ttype = TT_EOF;
	    sval = String.copyValueOf(buf, 0, i);
	    sval.trim();
	    if (forceLower)
			sval = sval.toLowerCase();
		if (ttype == TT_TEXT) peekc = c;
		else peekc = read();

	    return ttype;
	}

	/**
	 * nextTextToken repeatedly calls nextToken() until EOF is reached or a text type
	 * token is found.  If the token is found, the text is returned.  Otherwise,
	 * null is returned.
	 */
	public String nextTextToken() throws IOException {
		while (nextToken() != TT_EOF) {
			if (ttype == TT_TEXT)
				return sval;
		}

		return null;
	}

	/**
	 * nextTagToken repeatedly calls nextToken() until EOF is reached or a tag type
	 * token is found.  If the token is found, the text of the tag is returned.  Otherwise,
	 * null is returned.
	 */
	public String nextTagToken() throws IOException {
		while (nextToken() != TT_EOF) {
			if (ttype == TT_TAG)
				 return sval;
		}

		return null;
	}

	/**
	 * nextEntityToken repeatedly calls nextToken() until EOF is reached or an entity type
	 * token is found.  If the token is found, the text of the entity is returned.  Otherwise,
	 * null is returned.
	 */
	public String nextEntityToken() throws  IllegalStateException, 
											IOException {
		if (!parseEntity)
			throw new IllegalStateException("parseEntity is false");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TAG)
				return sval;
		}

		return null;
	}

	/**
	 * nextTextMatch repeatedly calls nextToken() until EOF is reached or a an exact match
	 * is found between the specified phrase and a type TT_TEXT token.  Use the method lowerCaseMode()
	 * to set the case sensitivity.  The method returns a boolean value indicating whether a match
	 * was found.
	 */
	public boolean nextTextMatch(String phrase) throws IOException, IllegalArgumentException {
		if (phrase == null)
			throw new IllegalArgumentException("phrase is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TEXT)
				if ((sval).equals(phrase)) return true;
		}

		return false;
	}

	/**
	 * nextTextSubstring repeatedly calls nextToken() until EOF is reached or the specified phrase
	 * is found in the html text.  Use the method lowerCaseMode() to set the case sensitivity.
	 * The method returns the entire String token in which it was found.  For example, nextTextSubstring("auction")
	 * could return the string, "The auction began on Monday, July 5, 2000".  If the phrase is not found,
	 * null is returned.
	 */
	public String nextTextSubstring(String phrase) throws IOException, IllegalArgumentException {
		if (phrase == null)
			throw new IllegalArgumentException("phrase is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TEXT)
				if ((sval).indexOf(phrase) > -1) return sval;
		}

		return null;
	}

	/**
	 * nextTagMatch repeatedly calls nextToken() until EOF is reached or a an exact match
	 * is found between the specified tag and a type TT_TAG token.  Use the method lowerCaseMode()
	 * to set the case sensitivity.  The method returns a boolean value indicating whether a match
	 * was found.
	 */
	public boolean nextTagMatch(String tag) throws IOException, IllegalArgumentException {
		if (tag == null)
			throw new IllegalArgumentException("tag is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TAG)
				if ((sval).equals(tag)) return true;
		}

		return false;
	}

	/**
	 * nexttagsListubstring repeatedly calls nextToken() until EOF is reached or the specified tag
	 * is found as a substring of an html tag.  Use the method lowerCaseMode() to set the case sensitivity.
	 * The method returns the entire text of the tag in which it was found or null if it isn't found.
	 */
	public String nexttagsListubstring(String tag) throws IOException, IllegalArgumentException {
		if (tag == null)
			throw new IllegalArgumentException("tag is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TAG)
				if ((sval).indexOf(tag) > -1) return sval;
		}

		return null;
	}

	/**
	 * nextEntityMatch repeatedly calls nextToken() until EOF is reached or a an exact match
	 * is found between the specified entity and a type TT_ENTITY token.  Use the method lowerCaseMode()
	 * to set the case sensitivity.  The method returns a boolean value indicating whether a match
	 * was found.
	 */
	public boolean nextEntityMatch(String entity) throws IOException, IllegalArgumentException, IllegalStateException {
		if (!parseEntity)
			throw new IllegalStateException("parseEntity is false");

		if (entity == null)
			throw new IllegalArgumentException("entity is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_ENTITY)
				if ((sval).equals(entity)) return true;
		}

		return false;
	}

	/**
	 * nextEntitySubstring repeatedly calls nextToken() until EOF is reached or the specified entity
	 * is found as a substring of an html entity.  Use the method lowerCaseMode() to set the case sensitivity.
	 * The method returns the entire text of the entity in which it was found or null if it isn't found.
	 */
	public String nextEntitySubstring(String entity) throws IOException, IllegalArgumentException, IllegalStateException {
		if (!parseEntity)
			throw new IllegalStateException("parseEntity is false");

		if (entity == null)
			throw new IllegalArgumentException("entity is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_ENTITY)
				if ((sval).indexOf(entity) > -1) return sval;
		}

		return null;
	}

	/**
	 * The pushBack() method allows you to 'unread' the last token so
	 * that the next call to nextToken() will return the same value
	 */
	public void pushBack() {
		if (ttype != TT_NOTHING)
			pushedBack = true;
	}

	/**
	 * The method toString() returns a string representation of the current token.
	 */
	public String toString() {
		String ret = new String();
		switch (ttype) {
			case TT_EOF:
				ret = "EOF";
				break;
			case TT_TAG:
				ret = "TAG[" + sval + "]";
				break;
			case TT_ENTITY:
				ret = "ENTITY[" + sval + "]";
				break;
			case TT_TEXT:
				ret = "TEXT[" + sval + "]";
				break;
			case TT_NOTHING:
				ret = "NOTHING";
				break;
		}
		return ret;
	}
	
	public static void main(String[] args)  {
		
		try {
			FileReader fr = new FileReader("input.txt");
			
			String tag;
			HTMLTokenizer2 tkn = new HTMLTokenizer2(fr);
			
			List<String> tagsList = new ArrayList<>();
			while( (tag = tkn.nextTagToken()) != null ){
//				String closing = tkn.nextTagToken();
//				if( tag.equals(  closing.substring(1, closing.length())) )
//			      System.out.println(tag +"\n");	
				tagsList.add(tag);
			}
			
		 Stack<String> stack = new Stack();
		 Stack<Component> stack2 = new Stack();
		  
		 Iterator<String> itr =  tagsList.iterator();
		 String tempTag;
		 Leaf lfNode;
		 Composite compositeNode;
		 while(itr.hasNext()) {
			 String node = itr.next();
			 if( node.contains("</") && !stack.isEmpty() ) {
				 tempTag = stack.pop();
				 //lfNode = new Leaf("12",tempTag);
				 compositeNode = new Composite(tempTag);
				 if(!stack2.isEmpty() ){
					 Component component = stack2.pop();
					 compositeNode.addNode(component);
					 stack2.push(compositeNode);
				 }
			 } else {
				 stack.push(node);
			 }
			 
			 
		 }
			
			
			buildTree( tagsList.get(0), tagsList, new Composite(tagsList.get(0)));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		}
	}
	
	static void buildTree( String elt , List<String> list, Component tree ) {
		 Leaf lf = null;
		 if( list.size() == 0 )
			 return;
		 //if( elt )
		 String maybeclosing = list.get(0);
//		 if( elt.equals( maybeclosing.substring(1, maybeclosing.length())) )
//			 lf = new Leaf(elt);
//		 else
//		 tree.addNode(lf);
		 
		 String tag = list.get(1);
		 list.remove(0);
		 buildTree(  tag, list, tree );
		 
	}
	
}







