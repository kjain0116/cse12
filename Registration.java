/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw4;

/**
* Registration class for requests made by students for a particular course.
* 
* @author Kavita Jain
* @version 1.0
* @since 7/29/17
*/
public class Registration implements Comparable<Registration> {

    private Student student;
    private Course course;
    private int coins;
    private long timestamp;

    /**
     * Registration constructor
     * @param student
     * @param course
     * @param coins
     */
    public Registration(Student student, Course course, int coins) {
        this.student = student;
        this.course = course;
        this.coins = coins;
        this.timestamp = System.nanoTime();
    }

    /**
     * Accessor for student
     * @return student
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * Accessor for course
     * @return course
     */
    public Course getCourse() {
        return this.course;
    }

    /**
     * Accessor for coins offered for course
     * @return coins
     */
    public int getCoins() {
        return this.coins;
    }

    /**
     * Compares this Student with another Student, by comparing their course
     * coins/timestamps If the coins of this is less, returns a negative
     * integer. If the coins of the Student received is less, returns a positive
     * integer. If the number of coins is same, use the timestamp comparison to
     * ensure FCFS. (You may want to check the implementation of System.nanoTime
     * to ensure correctness)
     *
     * @param o Student to be compared with
     * @return Result of the comparison
     */
    @Override
    public int compareTo(Registration o) {
    	if(this.coins > o.coins)
    		return 1;
    	else if(this.coins < o.coins)
    		return -1;
    	else {
    		if(this.timestamp > o.timestamp)
        		return 1;
    		else
        		return -1;
    	}
    }

    /**
     * Sets the timestamp inside this registration to be the current time in
     * nano seconds.
     */
    public void setTimestamp() {
        this.timestamp = System.nanoTime();
    }
}
