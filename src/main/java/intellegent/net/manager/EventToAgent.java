package intellegent.net.manager;

public class EventToAgent {
	
	public static String Agent (String event) {
	
		String Agent = "";
		
		String Parse[] = event.split(",");
		Agent = Parse[0];
		System.out.println(Agent);
		
	return Agent;
	
	}
	
	public static void eventCount (String Agent, Integer count) {
		switch (Agent) {
		case "A" : break;
		case "B" : break;
		case "C" : break;
		case "D" : break;
		case "E" : break;
		
		
	}

		
}
}