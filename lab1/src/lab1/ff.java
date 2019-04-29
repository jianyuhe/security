package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ff {
	public static void main(String[] args) throws IOException {

		String inputFileName = "resource.txt";
		String outputFileName = "Q1.txt";
		String vigenereInput = "vigenere.txt";
		
		// HashMap for storing letter and its count
		HashMap<Character, Integer> letterCount = new HashMap<>();
		LinkedHashMap<Character, Integer> sortedCount = new LinkedHashMap<>();
		
		
		File file = new File(inputFileName);
		
		// Letters in string
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
				
		// Check if file exist
		if (!file.exists()) {
			System.out.println("File doesn't exist");
			return;
		}
		
		// InputStream for reading in file
		FileInputStream iStream = new FileInputStream(file);
		// Character of next char read
		char c;
		// When is not the EOF
		while(iStream.available() > 0) {
			// Read the next char
			c = (char)iStream.read();
			sb.append(c);
			// If is an alphabet
			if (letters.indexOf(c) >= 0) {
				// If already in map then increment counter
				if (letterCount.containsKey(c)) {
					int count = letterCount.get(c) + 1;
					letterCount.replace(c, count);
				} else {
					// If not in map, create one
					letterCount.put(c, 1);
				}
			}
		}
		
		// Close input stream after finish
		iStream.close();
			
		// Sort the map by value in descending order
		letterCount.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEachOrdered(x -> sortedCount.put(x.getKey(), x.getValue()));
		
		// Declare writer to output to file
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
			
		// Declare iterator to iterate through sorted HashMap 
		Iterator<Entry<Character, Integer>> iterator = sortedCount.entrySet().iterator();
			
		// Loop through and output result to text file
		while (iterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry)iterator.next();
			writer.write(pair.getKey() + ": " + pair.getValue() + "\r\n");
		}
		
		// Close writer after finish
		writer.close();
			
		// Print complete message after finish
		System.out.println("Completed writing to " + outputFileName); 
		
		int counter = 0;
			
		// Part 2: find key of encrypted text
		for (Map.Entry<Character, Integer> pair : sortedCount.entrySet()) {
			if (counter > 2) {
				// Only do the first 3 set
				break;
			}
			// Find distance of the current key with letter 'E'
			int letterIndex = letters.indexOf(pair.getKey());
			int dist = Math.abs(letterIndex - letters.indexOf('E'));
			
			// Convert text to char array for manipulation
			char[] encryptedText = sb.toString().toCharArray();
			
			// Print to screen the key length
			System.out.println("The key length: " + dist);
			for(int i = 0; i < encryptedText.length; i++) {
				// If its a letter
				if (letters.indexOf(encryptedText[i]) >= 0) {
					// Decrypt it with key
					int decryptIndex = (letters.indexOf(encryptedText[i]) + letters.length() - dist) % letters.length();
					encryptedText[i] = letters.charAt(decryptIndex);
				}
				
				System.out.print(encryptedText[i]);
			}
			
			System.out.println("\n");
			counter++;
		}
		
		// Part 3: Vigenere Cipher Decrypt
		String key = "KISWAHILI";
		
		// Reader read in text to StringBuffer
		BufferedReader reader = new BufferedReader(new FileReader(vigenereInput));
		String line;
		StringBuffer text = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			text.append(line);
			text.append("\n");
		}
		
		// Close reader after finish
		reader.close();

		// Variable for storing decrypted vigenere text
		char[] decryptedVigenere = text.toString().toCharArray();
		
		// counter for key for decrypting
		int keyCount = 0;
		
		System.out.println("Decrypted Vigenere Text:\n");
		
		// Decrypt text given from text file
		for (int i = 0; i < decryptedVigenere.length; i++) {
			// If its a letter
			if (letters.indexOf(decryptedVigenere[i]) >= 0) {
				int decryptIndex = (letters.indexOf(decryptedVigenere[i]) + letters.length() - letters.indexOf((char)key.charAt(keyCount))) % letters.length();
				decryptedVigenere[i] = letters.charAt(decryptIndex);
				// Manipulate Looping key with modding the key length
				keyCount = (keyCount + 1) % key.length();
			}
			
			// Print out the decrypted character one by one
			System.out.print(decryptedVigenere[i]);
		}
		
	}// End main()
}
