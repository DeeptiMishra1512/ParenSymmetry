import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParenSymmetry {

    public Boolean isBalanced(String s) {

        int countOpenPara = 0;
        int countClosedPara = 0;
        Boolean balanced;
        for(int i=0;i<=s.length()-1;i++){

           // if(s.substring(s.indexOf(",")).equals("("){
            if(s.charAt(i) == '('){
                countOpenPara++;
            }
            else if(s.charAt(i) == ')'){
                countClosedPara++;
            }

        }
        if(countOpenPara == countClosedPara){
           balanced = true;
        }
        else {
            balanced = false;
        }
       return balanced;
    }

    public void checkFile(String filename) {
        // open file named filename

        // for each line in the file
        // read the line
        // print whether or not the line's parenthesis are balanced

        // CLOSE the file

        try{
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                System.out.println(isBalanced(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
//return result;

    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
