/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class Student implements ProfListener{
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	@Override
	public void midtermAnnounced(ProfEvent e) {
		study(((Prof)e.getSource()).getMidterm());
	}

	@Override
	public void midtermPostponed(ProfEvent e) {
		party(((Prof)e.getSource()).getMidterm());
	}
}
