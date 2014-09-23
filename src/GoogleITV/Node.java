package GoogleITV;

import java.util.ArrayList;

public class Node {
	public String NodeName;
	public Node Parent;
	     	public ArrayList<Node> next;
	      	public Node(String nodeName) 
	{
	Parent = null;
		next = null;
		NodeName = nodeName;
	}


}
