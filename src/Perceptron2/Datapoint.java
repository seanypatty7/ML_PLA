package Perceptron2;

public class Datapoint {
    public double[] features; // 5 features including bias
    public int label;

    public Datapoint(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String irisClass) {
        this.features = new double[5]; // 4 features + 1 bias
        this.features[0] = 1; // bias term
        this.features[1] = sepalLength;
        this.features[2] = sepalWidth;
        this.features[3] = petalLength;
        this.features[4] = petalWidth;
        this.label = irisClass.equals("Iris-setosa") ? 1 : -1;
    }
}

