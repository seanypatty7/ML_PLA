package Perceptron2;

import java.io.*;
import java.util.*;

public class Application{
    public static void main(String[] args) throws IOException {
        List<Datapoint> datapoints = readIrisDataset();
        Collections.shuffle(datapoints);

        int trainSize = (int) (datapoints.size() * 0.8);
        List<Datapoint> trainingSet = datapoints.subList(0, trainSize);
        List<Datapoint> testingSet = datapoints.subList(trainSize, datapoints.size());

        Datapoint[] trainingArray = trainingSet.toArray(new Datapoint[0]);
        Datapoint[] testingArray = testingSet.toArray(new Datapoint[0]);

        // Initialize f(x) - Initial (untrained) hyperplane 
        Hyperplane initialHyperplane = new Hyperplane(4); 
        System.out.println("Initial hyperplane (f(x)) weights: " + initialHyperplane);

        // Train the model to get g(x) - Trained hyperplane
        Hyperplane trainedHyperplane = new Hyperplane(4);
        int stepsNeeded = Perceptron.train(trainedHyperplane, trainingArray);
        System.out.println("Training completed in " + stepsNeeded + " steps.");
        System.out.println("Trained hyperplane (g(x)) weights: " + trainedHyperplane);

        //User input for new data
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Test the model with the data file and compare f(x) and g(x)");
            System.out.println("2. Input new data for prediction");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1/2/3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    testModelAndCompareHyperplanes(initialHyperplane, trainedHyperplane, testingArray);
                    break;
                case 2:
                    predictNewData(trainedHyperplane);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    break;
            }
        }
    }

    //Read data file
    public static List<Datapoint> readIrisDataset() throws IOException {
        List<Datapoint> datapoints = new ArrayList<>();

        try (InputStream inputStream = Application.class.getResourceAsStream("/Perceptron2/iris.data");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] tokens = line.split(",");
                double sepalLength = Double.parseDouble(tokens[0]);
                double sepalWidth = Double.parseDouble(tokens[1]);
                double petalLength = Double.parseDouble(tokens[2]);
                double petalWidth = Double.parseDouble(tokens[3]);
                String irisClass = tokens[4];
                datapoints.add(new Datapoint(sepalLength, sepalWidth, petalLength, petalWidth, irisClass));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        return datapoints;
    }

    public static void testModelAndCompareHyperplanes(Hyperplane initialHyperplane, Hyperplane trainedHyperplane, Datapoint[] testingArray) {
        
        // Compare f(x) and g(x)
        System.out.println("Initial hyperplane (f(x)) weights: " + initialHyperplane);
        System.out.println("Trained hyperplane (g(x)) weights: " + trainedHyperplane);
        
        // Calculate the average squared error between f(x) and g(x) weights
        double errorSum = 0;
        for (int i = 0; i < trainedHyperplane.w.length; i++) {
            double diff = initialHyperplane.w[i] - trainedHyperplane.w[i];
            errorSum += diff * diff;
        }
        double avgErrorSquared = errorSum / trainedHyperplane.w.length;
        System.out.println("Average squared error between f(x) and g(x): " + avgErrorSquared);
    }



    public static void predictNewData(Hyperplane hyperplane) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter new datapoint features:");
        System.out.print("Format: SepalLength *Press Enter* SepalWidth *Press Enter* PetalLength *Press Enter* PetalWidth *Press Enter*: ");

        double sepalLength = scanner.nextDouble();
        double sepalWidth = scanner.nextDouble();
        double petalLength = scanner.nextDouble();
        double petalWidth = scanner.nextDouble();

        Datapoint newDatapoint = new Datapoint(sepalLength, sepalWidth, petalLength, petalWidth, ""); 
        int prediction = hyperplane.classify(newDatapoint);

        System.out.println("Prediction: " + (prediction == 1 ? "Iris-setosa" : "Not Iris-setosa"));
    }
}
