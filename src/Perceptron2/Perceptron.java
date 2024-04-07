package Perceptron2;

public class Perceptron {
    public static int train(Hyperplane hyperplane, Datapoint[] datapoints) {
        int steps = 0;
        boolean anyIncorrect;
        do {
            anyIncorrect = false;
            for (Datapoint datapoint : datapoints) {
                if (hyperplane.classify(datapoint) != datapoint.label) {
                    anyIncorrect = true;
                    for (int i = 0; i < hyperplane.w.length; i++) {
                        hyperplane.w[i] += datapoint.label * datapoint.features[i];
                    }
                }
            }
            if (anyIncorrect) steps++;
        } while (anyIncorrect);
        return steps;
    }
}

