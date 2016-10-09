package mediatorvsobserver.observer;

import java.util.List;

public class DataListener implements Observer {
	
	LblDisplay msgLbl;
	
	public DataListener(PersonData personData) {
		 personData.attach(this);
	}

	@Override
	public void update(List<Person> p) {
		
	    String size = p.size() !=0 ? ""+p.size() :"No";
	    String rmSafe =  !size.equals("No") ? p.get(p.size()-1).getFname()+
	    		         " "+p.get(p.size()-1).getLname() : " ";
		msgLbl.setText("<html>"+ size+" persons saved!"+" <br>Last Saved:" +rmSafe+"</html>");
		
	}
    
	public void registerMessage( LblDisplay display){
		msgLbl = display;
	}
	

}
