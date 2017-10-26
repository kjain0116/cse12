/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw4;

import java.util.*;

/**
* Course class that holds all the information about a course.
* 
* @author Kavita Jain
* @version 1.0
* @since 7/29/17
*/
public class Course implements Course_Interface {

	private String courseName;
	private String courseCode;
	private MyPriorityQueue<Registration> waitlistQueue;
	private List<Student> roster;
	private int maxCapacity;

	/**
	 * Course constructor
	 * @param name Student name
	 * @param code Course code
	 * @param capacity Max capacity
	 */
	public Course(String name, String code, int capacity) {
		this.courseName = name;
		this.courseCode = code;
		this.maxCapacity = capacity;
		this.waitlistQueue = new MyPriorityQueue<>(5);
		this.roster = new LinkedList<>();
	}

	/**
     * Returns a string representation of the Course code 
     *
     * @return String representation of the course code
     */
	@Override
	public String toString() {
		return courseCode;
	}
	
	/**
     * Accessor for course name
     *
     * @return course name
     */
	@Override
	public String getCourseName() {
		return this.courseName;
	}

	/**
     * Accessor for course code
     *
     * @return course code
     */
	@Override
	public String getCourseCode() {
		return this.courseCode;
	}

	/**
     * Accessor for course capacity
     *
     * @return course capacity
     */
	@Override
	public int getCourseCapacity() {
		return this.maxCapacity;
	}

	/**
     * Accessor for Course Roster
     *
     * @return course roster
     */
	@Override
	public List<Student> getCourseRoster() {
		return this.roster;
	}

	/**
     * Checks whether the course enrollment has reached its capacity
     *
     * @return Returns true if the number of enrolled students is equal to
     * capacity, false otherwise
     */
	@Override
	public boolean isFull() {
		return this.roster.size() == this.maxCapacity;
	}

	/**
     * Enqueues the student to the waitlist for this course
     *
     * @param r Registration to be waitlisted
     */
	@Override
	public void addToWaitlist(Registration r) {
		this.waitlistQueue.offer(r);
		r.setTimestamp();
		r.getStudent().waitlistCourse(this);
	}

	/**
     * Enrolls the next student in to the course. Does nothing if
     * the waitlist is empty
     *
     * @return Registration Request that was processed
     */
	@Override
	public Registration processWaitlist() {
		Registration r = this.waitlistQueue.poll();
		if(r != null) {
			this.roster.add(r.getStudent());
			r.getStudent().enrollCourse(this);
			return r;
		}
		return null;
	}
}
