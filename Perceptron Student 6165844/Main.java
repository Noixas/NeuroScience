import  java.util.Random;
public class Main
{
  public static void main(String[] args)
  {
    //OR
    double[][] inputOR = {{0,0}, {0,1}, {1,0}, {1,1}};
    double[] outputOR = {0,1,1,1};
    //AND
    double[][] inputAND = {{0,0}, {0,1}, {1,0}, {1,1}};
    double[] outputAND = {0,0,0,1};
    //OR and AND perceptrons, they are trained in their constructor
  LogicalPerceptron OR_Perceptron = new LogicalPerceptron(3,inputOR,outputOR);
  LogicalPerceptron AND_Perceptron = new LogicalPerceptron(3,inputAND,outputAND);
  OR_Perceptron.testValue(0,1, "OR");
  AND_Perceptron.testValue(0,1, "AND");

  createLinePerceptron(50000);//Crea a line perceptron with 1000 random numbers as training data, 10,000 makes it more precise
  }
  private static void createLinePerceptron(int trainingAmount)
  {
    int input = trainingAmount;
    double[][] inputFunct =  new double[input][2];
    double[] outputFunct =  new double[input];
    Random rand = new Random();
    for(int i = 0; i<input;i++)
    {
      double x = rand.nextDouble()*100;//Multiply by hundred to get more human readable inputs
      double y = rand.nextDouble()*100;
      inputFunct[i][0] = x;
      inputFunct[i][1] = y;
      double line = 2*x + 1;//LINE to be trained for
      if(y < line)  outputFunct[i] = -1;
      else outputFunct[i] = 1;
    //  System.out.println("Index: "+i+" input: "+   inputFunct[i][0] + " Expected output: " + outputFunct[i]);
    }
    LinePerceptron p = new LinePerceptron(3,inputFunct,outputFunct);
    p.testValue(1);
    p.testValue(5);
    p.testValue(-354);
    p.testValue(600);
  }
}
