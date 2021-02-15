import java.io.*;
import java.util.Scanner;
import java.util.Stack;

/**
*This program is a postfix evaluator.
*It reads information from a file on the computer
*computes the answer (sum, difference, quotient, or product)
*and prints out the answer.
*
*@author Georgia Fitzgerald
*@version 03/19/2019
*/
public class PostfixEvaluator{

  /**
  *This method computes the product, quotient, sum, or difference
  *of two integers depending on the inputted operator
  *
  *@param num1 first integer
  *@param num2 second integer
  *@param operator used in computation
  *@return answer an Integer
  */
  public static int compute(int num1, int num2, String operator){
    if(operator.equals("+")){//If addition
      return num1 + num2;
    }else if(operator.equals("-")){//If subtraction
      return num2 - num1;
    }else if(operator.equals("*")){//If multiplication
      return num1 * num2;
    }else if(operator.equals("/")){//If division
      return num2 / num1;
    }else{
      return 0; //if operator not found in case of error
    }
  }

  /**
  *This method evaluates an inputted String that represents a postfix expression
  *It interprets the expression using a Stack and returns the answer
  *
  *@param word the String expression evaluated
  *@return answer an Integer
  */
  public static int evaluate(String word){
    Stack<Integer> stack = new Stack<Integer>();//Stack used to evaluate word
    for(int i = 0; i < word.length(); i++){//for every token in word
      String token = Character.toString(word.charAt(i));//set variable to be current token
      if(isOperator(token)){//if the token is an operator
        int num1 = stack.pop();
        int num2 = stack.pop();
        stack.push(compute(num1, num2, token));
      }else{//If not operator but instead operand
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();//return the answer
  }

  /**
  *This method checks to see if the inputted token is an operator and returns
  *a boolean value
  *
  *@param token is a String
  *@return boolean value determined by whether or not the input is an operator
  */
  public static boolean isOperator(String token){
    return token.equals("-") || token.equals("+") || token.equals("*") || token.equals("/");
  }

  /**
  *The main code takes information from a file on the computer and inputs it
  *into the evaluate method then prints out the expression and answer
  *The file name should be listed in the execution command "java PostfixEvaluator info.txt"
  *
  *@throws FileNotFoundException in case the file is not in the correct location
  *@param args is an array holding Strings found on a file located on the computer
  */
  public static void main(String[] args) throws FileNotFoundException {
    File infile = new File(args[0]);//set file referenced as parameter of main

    Scanner dataIn = new Scanner(infile);//create scanner to go through lines
    String line = "";//create variable to hold info of line
    while (dataIn.hasNext()) { //while there is another line in the file
      line = dataIn.nextLine(); //give info in line to variable
      String expression = ""; //initialize variable to hold individual tokens in line
      Scanner parser = new Scanner(line); //create scanner to parse through line

      while(parser.hasNext()){ //while there is more on the line
        expression = expression + parser.next();//add info to variable holding tokens
      }
      System.out.println(line + " results in " + evaluate(expression));//print info on line and the answer
    }
    dataIn.close();//close scanner
  }
}
