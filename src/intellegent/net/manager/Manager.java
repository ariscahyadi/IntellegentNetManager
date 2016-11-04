package intellegent.net.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Manager {
	
	static String Agent = "";
	static Integer AgentID = 0;
	static Integer[] NumberEvent = {0, 0, 0, 0, 0};
	
    public static void main(String[] args) throws IOException, InterruptedException {
        Reader Events = new FileReader("../IntellegentNetAgent/status.log");
        @SuppressWarnings("resource")
		BufferedReader input = new BufferedReader(Events);
        String event = null;
        while (true) {
        	event = input.readLine();
        	if (event == null) {
        		Thread.sleep(1000);
        	}
        	else {
        		//System.out.println(event);
        		String Parse[] = event.split(",");
        		Agent = Parse[0];
        		//System.out.println(Agent);
        		AgentID = Integer.valueOf(Agent);
        		
        		switch (AgentID) {
        			case 0 : NumberEvent[AgentID] = NumberEvent[AgentID]+1; break;
        			case 1 : NumberEvent[AgentID] = NumberEvent[AgentID]+1; break;
        			case 2 : NumberEvent[AgentID] = NumberEvent[AgentID]+1; break;
        			case 3 : NumberEvent[AgentID] = NumberEvent[AgentID]+1; break;
        			case 4 : NumberEvent[AgentID] = NumberEvent[AgentID]+1; break;
        		}
        		
        		System.out.println(Agent + " : " + NumberEvent[AgentID]);
        		for (AgentID = 0; AgentID<5 ; AgentID++){
        			System.out.println(NumberEvent[AgentID]);
        		}
        		
        		WeightedGraph.main(NumberEvent);
        	}
        }
    }
}