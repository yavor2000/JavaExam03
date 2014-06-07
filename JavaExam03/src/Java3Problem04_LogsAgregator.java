import java.util.Scanner;
import java.util.TreeMap;


public class Java3Problem04_LogsAgregator {

	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int n = input.nextInt();
			TreeMap<String, TreeMap<String, Integer>> people = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				String IP = input.next();
				String name = input.next();
				String duration = input.next();
				int dur=0;
				if (people.containsKey(name)) {
					TreeMap<String, Integer> sites = people.get(name);
					if (sites.containsKey(IP)) {
						dur=sites.get(IP); //if site is already present in people TreeMap add-up the duration 
					}
					sites.put(IP, dur+Integer.parseInt(duration));
					people.put(name, sites);
					continue;
				} //if the site is not existing in this people TreeMap create a new one and add it
				TreeMap<String, Integer> sites = new TreeMap<>();
				sites.put(IP, Integer.parseInt(duration));
				people.put(name, sites);
			}
			for (String name : people.keySet()) {
				String line="";
				System.out.print(name+": "); //print the name of the people in the alphabetical order
				int allDuration = 0;
				for (String site : people.get(name).keySet()) {
					allDuration+=people.get(name).get(site);
					line += (site+", "); //and add up the sites (alphabetically)
				}
				line = ""+allDuration+" ["+line.replaceAll(", $", "]"); //add total duration and remove the last bracket
				System.out.print(line+"\n");
			}
		}

	}

}
