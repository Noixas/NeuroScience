import  java.util.Random;
import java.util.*;
public class LinePerceptron{
  double[][] inputs;
  double[] outputs;
  double[] weights;
  int  iteration, output;
  int theta = 0;
  Random rand;
  static double LEARNING_RATE = 0.01;
  public LinePerceptron(int pInputQuantity, double[][] pInp, double[] pOut)
  {
    System.out.println("\n=====================================");
    System.out.println("PERCEPTRON OF A LINE:");
    System.out.println("=====================================\n");
    rand = new Random();
    outputs = pOut;
    inputs = pInp;
    weights = new double[pInputQuantity];
    RandomizeWeights();
    Train();
  }
  public void Train()
  {
    iteration = 0;
    double globalError;
    weights[2] = 1;
    do{
      iteration++;
      globalError = 0;
      for(int i = 0; i<inputs.length; i++){
          output = calculateOutput(theta, weights, inputs[i][0], inputs[i][1]);
          //difference between predicted value and expected output
          double  localError = outputs[i] - output;
          //update weights
          weights[0] += LEARNING_RATE*localError*inputs[i][0];
          weights[1] += LEARNING_RATE*localError*inputs[i][1];
          //update bias
          weights[2] += LEARNING_RATE*localError;

          globalError += Math.abs(localError);
      }
    //  System.out.println("Iteration " + iteration + " : TotalError = " + globalError);
    }
    while(globalError > 0.01 );
    System.out.println("\n========\n Weights:");
    System.out.println("W0: "+weights[0]+" W1: "+weights[1]+" W2: "+weights[2]);//+" = 0");
    System.out.println("Total iterations: "+iteration);
    System.out.println("\n=======");
  //  testSet(); //Test again the inputs and see their values in console
  }
  private void RandomizeWeights()
  {
    for (int i = 0; i < weights.length; i++) {
      weights[i] = rand.nextDouble();
      System.out.println("Initial Weight "+ i +" is: "+ weights[i]);
    }
  }
  private static int calculateOutput(int theta, double weights[], double x, double y){
      double sum  = x*weights[0] + y*weights[1] + weights[2];
      return (sum >= theta) ? 1:-1;
  }
  //Get the Y corresping to x
  public double guessY(double x)
  {
    double m = (-weights[0]/weights[1]);
    double b = (-weights[2]/weights[1]);
    double sum = m*x+b;
    return sum;
  }
  //helper method for output y when given an x
  public void testValue(int x)
  {
    System.out.println("\n=======");
    System.out.println("TESTING VALUE IN A LINE ");
    System.out.println("Input x = "+x);
    System.out.println("Weights: W0: "+weights[0]+" W1: "+weights[1]+" W2: "+weights[2]);
    System.out.println("Result: "+guessY(x));
  }

  private void testSet()
  {
    for(int i = 0;i<inputs.length;i++){
       double x1 = inputs[i][0];
       double y1 = inputs[i][1];
       output = calculateOutput(theta, weights, x1, y1);
       double result = weights[0]*x1+weights[1]*y1+weights[2];

       System.out.println("\nInput:");
       System.out.println("x = "+x1+",y = "+y1);
       System.out.println("Output = "+output);
       System.out.println(weights[0]+" * X ("+x1+")  + "+weights[1]+" * Y ("+y1+") + "+weights[2]);//+" = "+result);
       System.out.println("Result: "+result);
    }
    System.out.println("\n=======\n");
  }
}
