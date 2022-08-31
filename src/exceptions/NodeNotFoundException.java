package exceptions;

public class NodeNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NodeNotFoundException() {
        super("Element not found");
    }
}
