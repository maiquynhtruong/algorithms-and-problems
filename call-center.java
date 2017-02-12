/**
To implement a call center with 3 levels of employees: respondent, manager, and director.
Incoming call -> respondent -> manager -> director.

**/

public class Employee {
	public boolean available;
	public int level;
	public void takeCall(Call call) {
		talk();
	}	
}

public class Respondent {
	this.level = 0;
}

public class Manager {
	this.level = 1;
}

public class Director {
	this.level = 2;
}
public class Call{
	int waitingTime = 0;
	public Call(int time) {
		this.waitingTime = time;
	}
}
public class CallCenter {
	ArrayList<Respondent> respondents = new ArrayList<Respondent>();
	ArrayList<Manager> managers = new ArrayList<Manager>();
	ArrayList<Director> directors = new ArrayList<Director>();
	PriorityQueue<Call> calls = new PriorityQueue<Call>();
	public void dispatchCall(Call incomingCall) {
		while (!calls.isEmpty()) {
			Call call = calls.poll();
			for (Respondent r : respondents) {
				if (r.available) {
					assignCall(r, call);
					break;
				}
			}
			for (Manager m : managers) {
				if (m.available) {
					assignCall(m, call);
					break;
				}
			}
			for (Director d : directors) {
				if (d.available) {
					assignCall(d, call);
					break;
				}
			}
		}
	}
	public void gotNewCall() {
		Call newCall = new Call(0);
		dispatchCall(newCall);
	}
	public void assingCall(Employee e, Call call) {
		e.takeCall(call);
	}
}