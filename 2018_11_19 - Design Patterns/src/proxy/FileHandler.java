package proxy;

public abstract class FileHandler {
	protected String fileName;

	public FileHandler(String fName) {
		fileName = fName;
	}

	public String getFileName() {
		return fileName;
	}

	public abstract String getContent();

	public abstract String getLine(int requestedLine);

}
