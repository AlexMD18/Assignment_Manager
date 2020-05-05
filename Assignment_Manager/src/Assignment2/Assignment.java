package Assignment2;

import java.util.Date;

/**
 *
 * @author cindy
 */
//Represents each assignment; getters and setters for each data field
public class Assignment {

    //define private data fields: course id, assignment name, due date
    private String courseID;
    private String assignmentName;
    private Date dueDate;

    //define a constructor here, taking in the given data field values for the new object
    public Assignment(String courseID, String assignmentName, Date dueDate) {
        this.courseID = courseID;
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
    }

    //define a getter and a setter method for each data field here
    public String getCourseID() {
        return courseID;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    //Setter methods
    public void setCourseID(String newCourseID) {
        courseID = newCourseID;
    }

    public void setAssignmentName(String newAssignmentName) {
        assignmentName = newAssignmentName;
    }

    public void setDueDate(Date newDueDate) {
        dueDate = newDueDate;
    }

    //optionally: define a toString() method
    @Override
    public String toString() {
        return "\n Assignment: " + "Course ID: " + courseID + ", Assignment: " + assignmentName + ", Due Date: " + dueDate;
    }
}
