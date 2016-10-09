package iteratorvscomposite;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TagParser {

	private Reader reader = null;

	private int peekc;
	private boolean pushedBack = false;
	private boolean forceLower = false;
	private boolean parseEntity = false;


	private int ttype = TT_NOTHING;

	
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

	
	private String sval;	// string of current token

	/**
	 * creates an HTMLTokenizer for a Reader input stream
	 */
	public TagParser(Reader r) {
		reader = r;
	}

	
	public TagParser(String url) throws FileNotFoundException,
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

	
	public boolean nextTextMatch(String phrase) throws IOException, IllegalArgumentException {
		if (phrase == null)
			throw new IllegalArgumentException("phrase is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TEXT)
				if ((sval).equals(phrase)) return true;
		}

		return false;
	}

	
	public String nextTextSubstring(String phrase) throws IOException, IllegalArgumentException {
		if (phrase == null)
			throw new IllegalArgumentException("phrase is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TEXT)
				if ((sval).indexOf(phrase) > -1) return sval;
		}

		return null;
	}


	public boolean nextTagMatch(String tag) throws IOException, IllegalArgumentException {
		if (tag == null)
			throw new IllegalArgumentException("tag is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TAG)
				if ((sval).equals(tag)) return true;
		}

		return false;
	}

	
	public String nexttagsListubstring(String tag) throws IOException, IllegalArgumentException {
		if (tag == null)
			throw new IllegalArgumentException("tag is null");

		while (nextToken() != TT_EOF) {
			if (ttype == TT_TAG)
				if ((sval).indexOf(tag) > -1) return sval;
		}

		return null;
	}

	
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
	

	
	
}







