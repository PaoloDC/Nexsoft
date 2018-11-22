package proxy;

import java.util.HashMap;

public class ProxyFileHandler extends FileHandler {
	private RealFileHandler realHandler;
	private String lineText;
	private HashMap<Integer, String> mappaRighe;

	public ProxyFileHandler(String fName) {
		super(fName);
		System.out.println("(creating a proxy cache)");
		mappaRighe = new HashMap<>();
	}

	public String getContent() {
		if (realHandler == null)
			realHandler = new RealFileHandler(fileName);
		return realHandler.getContent();
	}

	public String getLine(int requestedLine) {
		if(mappaRighe.containsKey(requestedLine)) {
			System.out.println("(accessing from proxy cache)");
			return mappaRighe.get(requestedLine);
		} else {
			if (realHandler == null)
				realHandler = new RealFileHandler(fileName);
			lineText = realHandler.getLine(requestedLine);
			mappaRighe.put(requestedLine, lineText);
		}
		return lineText;
	}
}
