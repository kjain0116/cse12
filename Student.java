/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw4;

import java.util.*;

/**
* Student class that holds all the basic info about a student
* 
* @author Kavita Jain
* @version 1.0
* @since 7/29/17
*/
public class Student implements Student_Interface {

    private String studentID;
    private String name;
    private List<Course> myEnrolledCourses;
    private List<Course> myWaitlist;
    private int courseCoins;

    /**
     * Constructor that populates the instance variables with parameters passed
     *
     * @param id StudentID
     * @param name Name of the student
     * @param coins Course Coins
     */
    public Student(String id, String name, int coins) {
        this.studentID = id;
        this.name = name;
        this.courseCoins = coins;
        this.myEnrolledCourses = new LinkedList<>();
        this.myWaitlist = new LinkedList<>();
    }

    /**
     * Returns a string representation of the Student that includes the name and
     * the studentID
     *
     * @return String representation of the student
     */
    @Override
    public String toString() {
        return this.name + "(" + this.studentID + ")";
    }
    
    /**
     * Adds course c to the list of enrolled courses Also removes c from the
     * waitlisted courses
     *
     * @param c Course to be enrolled in
     */
	@Override
	public void enrollCourse(Course c) {
		this.myEnrolledCourses.add(c);
		this.myWaitlist.remove(c);
		
	}

	/**
     * Adds course c to the waitlist
     *
     * @param c course to be waitlisted
     */
	@Override
	public void waitlistCourse(Course c) {
		this.myWaitlist.add(c);
		
	}

	/**
     * Accessor for name
     *
     * @return name - Name of the student
     */
	@Override
	public String getStudentName() {
		return this.name;
	}

	/**
     * Accessor for Student ID
     *
     * @return studentID - Student ID
     */
	@Override
	public String getStudentID() {
		return this.studentID;
	}

	/**
     * Returns a list of all enrolled courses
     *
     * @return List of enrolled courses
     */
	@Override
	public List<Course> getmyEnrolledCourses() {
		return this.myEnrolledCourses;
	}

	/**
     * Returns a list of all waitlisted courses
     *
     * @return List of waitlisted courses
     */
	@Override
	public List<Course> getmyWaitlist() {
		return this.myWaitlist;
	}

	/**
     * Accessor for course coins
     *
     * @return course coins
     */
	@Override
	public int getCoins() {
		return this.courseCoins;
	}

	/**
     * Deducts numCoins from coursecoins
     *
     * @param numCoins Number of coins to be deducted
     */
	@Override
	public void deductCoins(int numCoins) {
		this.courseCoins = this.courseCoins - numCoins;
	}
}
