package Assignment2;

/*
CIS2168 03 Fall 2019 Data Structures
Alexandro Drogo
tuj78444@temple.edu
Lab4_Assignment 2

Program Description:
This program uses liked lists to store data input by a user. The user can choose to add an 
assignment, remove an assignment, see which assignment is due soonest, and show all active
assignments.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author cindy
 */
public class ManageAssignments {

    String courseID;
    String assignmentName;
    Date dueDate;
    Scanner scanner = new Scanner(System.in);

    //create a linked list of Assignment objects
    LinkedList<Assignment> schoolWork = new LinkedList<Assignment>();

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ManageAssignments mA = new ManageAssignments();

        //get user choice and act accordingly
        int menuChoice;

        //do-while loop that displays a menu to the user until they give the quit command
        do {
            //display a menu
            System.out.println("\nMenu:");
            System.out.println("1: Add Assignment");
            System.out.println("2: Remove Assignment");
            System.out.println("3: Show Active Assignments");
            System.out.println("4: Show Assignment that is Due First");
            System.out.println("0: Quit");
            System.out.print("Type Choice Here: ");
            menuChoice = scanner.nextInt();
            String newAssignment = scanner.nextLine();

            //Switch statement to select what the user would like to do 
            switch (menuChoice) {
                case 1:
                    mA.addAssignment();
                    break;

                case 2:
                    //String currentAssignmentName;
                    mA.removeAssignment();
                    break;

                case 3:
                    mA.showAssignments();
                    break;

                case 4:
                    mA.dueSoonest();
                    break;

                default:
                    System.out.println("Program Ended");
            }

        } while (menuChoice > 0);

    }

    //Methods
    //Add assignment prompts user to input the course ID, assignment name and the date the assignment is due
    public void addAssignment() throws ParseException {
        System.out.println("1: Add Assignment:");
        System.out.println("Please enter the course ID: ");
        courseID = scanner.nextLine();

        System.out.println("Please enter the assignment name: ");
        assignmentName = scanner.nextLine();

        System.out.println("Please enter the assignment due date: ");
        String due_Date = scanner.nextLine();
        //Simple class format was a format i found on W3 Schools.com
        //Im not sure how to get rid of the time date, but it seems like when you use the .parse, that automatically shows
        dueDate = new SimpleDateFormat("MM/dd/yyyy").parse(due_Date);
        schoolWork.add(new Assignment(courseID, assignmentName, dueDate));
    }

    //Method to remove an assignment. The user is prompted to enter the assignment name that they would like to remove from the list
    //The user is asked about the assignemnt not the course becuase there could be mulitple assignments that have the same course id.
    public void removeAssignment() {
        System.out.println("2: Remove Assignment:");
        System.out.print("Please enter the name of the assignment you would like to remove: ");
        assignmentName = scanner.nextLine();

        for (int i = 0; i < schoolWork.size(); i++) {
            Assignment assignN = schoolWork.get(i);
            if (assignN.getAssignmentName().equals(assignmentName)) {
                schoolWork.remove(assignN);
                break;
            }
        }
        System.out.println("Removed Assignment: " + assignmentName);
    }

    //Method to show the user the assignments in the order they were assigned.
    public void showAssignments() {
        for (int i = 0; i < schoolWork.size(); i++) {
            Assignment assign = schoolWork.get(i);
            System.out.println("\nCourse ID: " + assign.getCourseID());
            System.out.println("Assignment Name: " + assign.getAssignmentName());
            System.out.println("Due Date: " + assign.getDueDate());
        }
    }

    //Method that shows which assignment is due the soonest and what day it is due.
    public void dueSoonest() {
        Date closestDate = new Date();
        for (int i = 0; i < schoolWork.size(); i++) {
            Assignment assignDD = schoolWork.get(i);
            closestDate = assignDD.getDueDate();
            break;
        }
        //Reads through liked list and finds the closest due date
        for (int i = 0; i < schoolWork.size(); i++) {
            Assignment assignDD = schoolWork.get(i);
            if (assignDD.getDueDate().compareTo(closestDate) < 0) {
                closestDate = assignDD.getDueDate();
            }
        }

        System.out.println("\nAssignment Due the Soonest:");
        for (int i = 0; i < schoolWork.size(); i++) {
            Assignment assignDD = schoolWork.get(i);
            if (assignDD.getDueDate().compareTo(closestDate) == 0) {
                System.out.println("Course ID:" + assignDD.getCourseID());
                System.out.println("Assignment Name: " + assignDD.getAssignmentName());
                System.out.println("Due Date: " + assignDD.getDueDate());
            }
        }
    }

}
