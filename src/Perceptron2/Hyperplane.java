package Perceptron2;

public class Hyperplane {
    public double[] w;

    public Hyperplane(int dimensions) {
        this.w = new double[dimensions + 1]; 
        for (int i = 0; i < this.w.length; i++) {
            this.w[i] = Math.random() * 2 - 1;
        }
    }

    public double dotProduct(Datapoint datapoint) {
        double result = 0;
        for (int i = 0; i < this.w.length; i++) {
            result += this.w[i] * datapoint.features[i];
        }
        return result;
    }

    public int classify(Datapoint datapoint) {
        return dotProduct(datapoint) > 0 ? 1 : -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Hyperplane: ");
        for (int i = 0; i < this.w.length; i++) {
            sb.append(String.format("w%d: %.4f ", i, this.w[i]));
        }
        return sb.toString().trim();
}
}

