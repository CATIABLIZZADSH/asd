package network;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

	public static void generateCharacters_Two(OutputStream out) throws IOException 
	{
		
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerLine = 72;
		int start = firstPrintableCharacter;
		byte[] line = new byte[numberOfCharactersPerLine + 2];
		
		for (int numLine = 0; numLine < 100; numLine++) {
			for (int i = start; i < start + numberOfCharactersPerLine; i++) {
				line[i - start] = (byte) ((i - firstPrintableCharacter)
					% numberOfPrintableCharacters + firstPrintableCharacter); 
			}

			line[72] = (byte) '\r'; // carriage return
			line[73] = (byte) '\n'; // line feed
			
			out.write(line);
			
			start = ((start + 1) - firstPrintableCharacter)
			% numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}
	
	public static void main(String[] args) {
		try(OutputStream out = new FileOutputStream("data.txt")) {
				generateCharacters(out);
		
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
