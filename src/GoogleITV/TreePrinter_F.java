package GoogleITV;

import java.util.*;

public class TreePrinter_F {
	
	public static int spaceCount = 0;

	public static void printTree(Iterable<Relation> rs)
	 {
		ArrayList<Node> rootCheck = new ArrayList<Node>();
	       	HashMap<String, Node> cache = new HashMap<String, Node>();
	      	for(Relation curNode: rs )
	       	{
			Node parentNode = cache.get(curNode.parent);
			if(parentNode == null)
			{
				parentNode = new Node(curNode.parent);
				cache.put(curNode.parent, parentNode);
			}
			
			Node childNode = cache.get(curNode.child);
			if(childNode == null)
			{
				childNode = new Node(curNode.child);
	cache.put(curNode.child, childNode); 
			}
	childNode.Parent = parentNode;
			if(parentNode.next == null)
				parentNode.next = new ArrayList<Node>();
			parentNode.next.add(childNode);
			
			if(parentNode.Parent == null)
			{
				rootCheck.add(parentNode);
			}
	}

	Node root = null;
	for(Node node : rootCheck)
		{
	if(node.Parent == null)
			{
				root = node;
				break;
			}
	}
		PrintTree(root);
	}

	static	void PrintTree(Node node)
{
	if(node != null)
	{
		print(node.NodeName);
	        	if(node.next != null)
		{
			for(Node n : node.next)
			{
				spaceCount += 2;
				PrintTree(n);
				spaceCount -= 2;
			}
		}
	       
	}

}

static void print(String value)
{
	String space = "";
	for (int i = 0; i < spaceCount; i++)
		space += " ";
		System.out.println(space + value);
}


}
