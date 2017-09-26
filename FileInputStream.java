package network;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class MainNetwork {
	public static void generateCharacters(OutputStream out) throws IOException {
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerLine = 72;
		int start = firstPrintableCharacter;
		for (int numLine = 0; numLine < 100; numLine++) {
			for (int i = start; i < start + numberOfCharactersPerLine; i++) {
				out.write(((i - firstPrintableCharacter) % numberOfPrintableCharacters) + firstPrintableCharacter);
			}

			out.write('\r'); // carriage return
			out.write('\n'); // linefeed

			start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}

	public static void generateCharacters_Two(OutputStream out) throws IOException {

		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerLine = 72;
		int start = firstPrintableCharacter;
		byte[] line = new byte[numberOfCharactersPerLine + 2];

		for (int numLine = 0; numLine < 100; numLine++) {
			for (int i = start; i < start + numberOfCharactersPerLine; i++) {
				line[i - start] = (byte) ((i - firstPrintableCharacter) % numberOfPrintableCharacters
						+ firstPrintableCharacter);
			}

			line[72] = (byte) '\r'; // carriage return
			line[73] = (byte) '\n'; // line feed

			out.write(line);

			start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}

	public static void main(String[] args) {
		try (InputStream In = new FileInputStream("data.txt")) {
 
			int bytesRead = 0;
			int bytesToRead = 1024;
			byte[] input = new byte[bytesToRead];

			while (bytesRead < bytesToRead) {
				int result = In.read(input, bytesRead, bytesToRead - bytesRead);
				if (result == -1)
					break;
				bytesRead += result;
			}
			System.out.println("Read Input : " + Arrays.toString(input));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
