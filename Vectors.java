import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

class Vector{
    private int[] vectorArray;

    public Vector(int[] vectorArray){
        this.vectorArray = vectorArray;
    }

    private double computeDotProduct(Vector vectorV){
        double dotProduct = 0;

        for (int i = 0; i < this.vectorArray.length; i++){
            dotProduct += this.vectorArray[i] * vectorV.getVectorArray()[i];
        }
        System.out.println("dotProduct:" + dotProduct);
        return dotProduct;
    }
    
    private double computeMagnitude(int[] vectorArrayAny){
        int intermediateAddition = 0;

        for (int i = 0; i < vectorArrayAny.length; i++){
            intermediateAddition += Math.pow(vectorArrayAny[i], 2);
        }
        
        return Math.sqrt(intermediateAddition);
    }

    public double computeCosineCoefficient(Vector vectorV){
        return Math.acos((this.computeDotProduct(vectorV)) / (
            this.computeMagnitude(this.vectorArray) * this.computeMagnitude(vectorV.getVectorArray())
        ));
    }

    public int[] getVectorArray(){
        return this.vectorArray;
    }
}

class Vectors {  
    public static Scanner scanner = new Scanner(System.in);
  
    public static void main(String[] args) { 
        createVectors();  
    } 

    static void createVectors(){
        System.out.println("Enter vector values, separate by comma");
        int[] vector1Array = convertToIntArray(scanner.nextLine().split(","));
        int[] vector2Array = convertToIntArray(scanner.nextLine().split(","));
        
        Vector vector1 = new Vector(vector1Array);
        Vector vector2 = new Vector(vector2Array);

        findCosineMeasure(vector1, vector2);
    }

    static void findCosineMeasure(Vector vectorU, Vector vectorV){
        System.out.println(vectorU.computeCosineCoefficient(vectorV));
    }

    static int[] convertToIntArray(String[] vectorArray){
        int[] vectorIntArray = new int[vectorArray.length];
    
        for (int i = 0; i < vectorArray.length; i++){
            vectorIntArray[i] = Integer.parseInt(vectorArray[i]);
        }
        return vectorIntArray;
    }
}