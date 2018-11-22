package proxy;

import java.io.FileInputStream;

public class RealFileHandler extends FileHandler {
	private byte[] content;

	public RealFileHandler(String fName) {
		super(fName);
		System.out.println("(creating a real handler with file content)");
		FileInputStream file;
		try {
			file = new FileInputStream(fName);
			int numBytes = file.available();
			content = new byte[numBytes];
			file.read(content);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getContent() {
		return new String(content);
	}

	public String getLine(int requestedLine) {
		System.out.println("(accessing from real handler)");
		int numBytes = content.length;
		int currentLine = 1;
		int startingPos = -1;
		int lineLength = 0;
		for (int i = 0; i < numBytes; i++) {
			if ((currentLine == requestedLine) && (content[i] != 0x0A)) {
				if (startingPos == -1)
					startingPos = i;
				lineLength++;
			}
			if (content[i] == 0x0D)
				currentLine++;
		}
		String lineText = "";
		if (startingPos != -1)
			lineText = new String(content, startingPos, lineLength - 1);
		return "\"" + lineText + "\"";
	}
}