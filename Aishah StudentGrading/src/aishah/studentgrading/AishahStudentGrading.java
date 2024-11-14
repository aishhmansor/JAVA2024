/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aishah.studentgrading;

/**
 *
 * @author User-PC
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AishahStudentGrading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner studentGrade = new Scanner(System.in);
        String choice;
        
        do{
            //number of the students
            String input = JOptionPane.showInputDialog("Number of the students: ");
            int numStudents = Integer.parseInt(input);
            
            //Variables to store grade counts
            int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0;
            int passCount = 0, failCount = 0;
            
            //Looping to get each students mark
            for(int i = 1; i <= numStudents; i++){
                input = JOptionPane.showInputDialog("Enter the mark " + i + ":");
                int mark = Integer.parseInt(input);
                
                //grade based on mark
                
                if (mark >= 70){
                    gradeA++;
                    passCount++;
                } 
                else if (mark >= 60){
                    gradeB++;
                    passCount++;
                }
                else if (mark >= 50){
                    gradeC++;
                    passCount++;
                }
                else if (mark >= 40){
                    gradeD++;
                    passCount++;
                }
                else {
                    gradeF++;
                    failCount++;
                }
            }
            
            //display grading distribution
            String gradeFinalization = """
                                       Grade Finalization:
                                       Grade A: """ + gradeA + "\n"+
                                        "Grade B: " + gradeB + "\n"+
                                        "Grade C: " + gradeC + "\n"+
                                        "Grade D: " + gradeD + "\n"+
                                        "Grade F: " + gradeF + "\n";
            
            //Fail and pass count 
            String passFailSummary = "Total Student's Passed: " + passCount + "\n"+
                                     "Total Student's Failed: " + failCount + "\n";
            
           // determine if more students passed or failed
           String resultMessage;
            if (passCount > failCount) {
                resultMessage = "Bonus to instructor!";
            } 
            else {
                resultMessage = "More students failed.";
            }
            
             // Combine all messages
            String finalMessage = gradeFinalization + passFailSummary + resultMessage;

            // Display the final message in JOptionPane
           /* JOptionPane.showMessageDialog(null, finalMessage, "Results", JOptionPane.INFORMATION_MESSAGE);*/
           
           System.out.println("Final result: " + finalMessage );
           studentGrade.nextLine();

            // Ask user if they want to continue or exit
            choice = JOptionPane.showInputDialog("Do you want to continue? (yes to continue, no to exit):");

        } while (choice.equalsIgnoreCase("yes"));

        // Close scanner and display exit message
        studentGrade.close();
        JOptionPane.showMessageDialog(null, "Program exited.", "Exit", JOptionPane.INFORMATION_MESSAGE);
    }
                                        
        } 
