package GoogleITV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TreePrinter {
	public static void printTree(Iterable<Relation> rs) {
		// your code
		if(rs== null) return;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		HashSet<String> childrenSet = new HashSet<String>();
		
		Iterator iter = rs.iterator();
		while (iter.hasNext()) {
			// get the relation
			Relation val = (Relation) iter.next();
			ArrayList<String> children = map.get(val.parent);
			if (children == null) {
				children = new ArrayList<String>();

			}
			children.add(val.child);
			map.put(val.parent, children);
			childrenSet.add(val.child);
		}
		String root = "";
		Iterator mapIter = map.keySet().iterator();
		while (mapIter.hasNext()) {
			String key = (String) mapIter.next();
			if (!childrenSet.contains(key))// recheck
			{
				root = key;
				break;
			}
		}
		if(root == "") return;
		// find the root, print the child
		System.out.println(root);
		print_r(root, map, 1);

	}

	public static void print_r(String root,
			HashMap<String, ArrayList<String>> map, int level) {
		ArrayList<String> iChildren = map.get(root);
		if (iChildren != null) {
			for (int i = 0; i < iChildren.size(); i++) {

				System.out.println(getSpaces(level) + iChildren.get(i));
				print_r(iChildren.get(i), map, level + 1);
			}

		}

	}

	public static String getSpaces(int val) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < val; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

}
