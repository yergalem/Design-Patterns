package iteratorvscomposite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * renderTree() constructs the tree from the parsed nodes. HTMLTokenizer parses
 * the input HTML file. Uses two stacks to build the DOM tree
 * 
 * @author Yergalem
 *
 */
public class HTMLComposition {

	public static void main(String[] args) {

		try {

			renderTree();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
	}

	public static void renderTree() throws IOException {

		FileReader fr = new FileReader("input.txt");

		String tag;
		TagParser tkn = new TagParser(fr);

		List<String> tagsList = new ArrayList<>();
		while ((tag = tkn.nextTagToken()) != null) {

			tagsList.add(tag);
		}
		System.out.println("Tag List");
		System.out.println(tagsList.toString());

		System.out.println("---------------------------------");

		Stack<String> stack = new Stack(); // Collects Opening Tags
		Stack<Component> stack2 = new Stack(); // Holds

		Iterator<String> itr = tagsList.iterator();
		String tempTag = null;
		Leaf lfNode;
		Component compositeNode = null;
		Component tree = new Composite("My Tree");
		String prev = "";

		while (itr.hasNext()) {
			String node = itr.next();

			if (node.contains("/") && !stack.isEmpty()) {
				tempTag = stack.pop();
				if (!prev.contains("/")) // Checks if successor is closing tag.
											// If so, it's composite otherwise
											// it's Leaf
					compositeNode = new Leaf("12", tempTag);
				else
					compositeNode = new Composite(tempTag);
				if (!stack2.isEmpty()) {
					Component component = stack2.pop();

					component.addNode(compositeNode);
					stack2.push(component);
					// component.print();
				} else
					stack2.push(compositeNode);

			} else {
				stack.push(node);
			}

			prev = node;

		}
		System.out.println("---------------------------------");
		System.out.println("Rendered Tree");
		stack2.pop().print();
		//print(tree.displayNodes());
		// tree.displayNode( compositeNode.displayNodes() );

	}

	
	public static void print( Collection<Component> c){

	// Collection<Component> lst = displayNodes();
	Iterator<Component> itr =  c.iterator();

	if(c.isEmpty())return;

	while(itr.hasNext())
	{
		Component tag = itr.next();
		if (tag instanceof Leaf) {
			System.out.println(tag);
			c.remove(tag);
		}
		else
		 print(c);
		//tag.print();
	}

}

}
