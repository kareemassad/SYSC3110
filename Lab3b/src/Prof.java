/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.*;

public class Prof {
	private String name;
	private Date midtermDate;
	private ArrayList<Student> students;
	private TeachingAssistant ta;
	private List<ProfListener> profListeners;

	public Prof(String aName) {
		this.name = aName;
		this.students = new ArrayList<Student>();
		profListeners = new ArrayList<ProfListener>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date){
		this.midtermDate=date;
		ProfEvent event = new ProfEvent(this);
		for (ProfListener pe: profListeners){
			pe.midtermAnnounced(event);
		}
		for(Student s: this.students){
			s.study(date);
		}
		ta.proctor(date);

	}
	public void postponeMidterm(Date date){
		this.midtermDate=date;
		ProfEvent event = new ProfEvent(this);
		for (ProfListener pe: profListeners){
			pe.midtermPostponed(event);
		}
		for(Student s: this.students){
			s.party(date);
		}
		ta.postpone(date);

	}

	public void setTA(TeachingAssistant theTA){
		this.ta = theTA;
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	}

	public synchronized void addProfListener(ProfListener pl){
		profListeners.add(pl);
	}
	public synchronized void removeProfListener(ProfListener pl){
		profListeners.remove(pl);
	}

	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addStudent(s);
		p.addStudent(s2);
		p.setTA(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
