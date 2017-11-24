package os.jr.hooks;

import os.jr.hooks.model.GameClass;
import os.jr.hooks.model.GameField;

public class Node extends GameClass {
	public final String NODE_UID = "Node_UID";
	public final String NODE_PREV = "Node_Prev";
	public final String NODE_NEXT = "Node_Next";
	
	public Node() {
		super("gt");
		String node = "gt";
		this.fields.put("Node_UID", new GameField("cc", node));
		this.fields.put("Node_Prev", new GameField("cc", node));
		this.fields.put("Node_Next", new GameField("cc", node));
	}

	
}