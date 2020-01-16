import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Acronyms {
	
	File file;
	BufferedReader in;
	TreeMap<String, String> acroMap;
	String paragraph = "I drove my PU to TSO to get a HD. My CPU has a virus. I sometimes SO when trying to kick a FG. I had 2 RBI at the game. I saw 2 PDA infractions in the hall.";
	
	public Acronyms() throws IOException {
		acroMap = new TreeMap<String,String>();
		
		try {
			file = new File("/home/compsci/eclipse-workspace/022MapsLab2/src/acronyms.txt");
			in = new BufferedReader(new FileReader(file));
		} catch (Exception e) {
			System.out.println("file not found, exiting program");
			System.exit(0);
		}
		
		while (in.ready()) {
			String[] temp = in.readLine().split(" – ");
			acroMap.put(temp[0], temp[1]);
		}
		
	}
	public void deAcronym() {
		String[] temp = paragraph.split(" ");
		for (String s : temp) {
			boolean periodNeeded = false;
			if (s.contains(".")) {
				s = s.substring(0, s.length()-1);
				periodNeeded = true;
			}
			if (acroMap.containsKey(s)) {
				System.out.print(acroMap.get(s));
				
				if (periodNeeded) {
					System.out.print(".");
				}
				System.out.print(" ");
			} else {
				System.out.print(s + " ");
			}
		}
	}

}
