package facade;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {
	public static final boolean SECURE_MODE_ON = true;
	public static final boolean SECURE_MODE_OFF = false;
	private BufferedReader br;
	private boolean secureMode;

	public ConsoleReader() {
		this(SECURE_MODE_ON);
		System.out.println(secureMode);
	}

	public ConsoleReader(boolean secMod) {
		br = new BufferedReader(new InputStreamReader(System.in));
		secureMode = secMod;
	}

	public String readString() {
		try {
			return br.readLine();
		} catch (Exception e) {
			if (secureMode)
				throw new ConsoleReaderException(e);
			return "";
		}
	}

	public Integer readInteger() {
		Integer theInteger = null;
		try {
			theInteger = new Integer(br.readLine());
		} catch (Exception e) {
			if (secureMode)
				throw new ConsoleReaderException(e);
			theInteger = new Integer(0);
		}
		return theInteger;
	}

	public Double readDouble() {
		Double theDouble = null;
		try {
			theDouble = new Double(br.readLine());
		} catch (Exception e) {
			if (secureMode)
				throw new ConsoleReaderException(e);
			theDouble = new Double(0);
		}
		return theDouble;
	}

}
