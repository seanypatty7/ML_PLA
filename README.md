# ML_PLA
Perceptron Learning Algorithm Implementation
This was a homework assignment from my Intro to Machine Learning Course. 
'Implement the PLA algorithm using your favorite programming language (Java, C, C++ are only allowed). Make sure that you find useful linearly separable data with a minimum of 3 features, but they don't have to be evenly divided between the positive and negative class. Run and test your code, and turn in your code along with your data. '
For my assignment, I used 'https://archive.ics.uci.edu/dataset/53/iris' which is an Iris Plant dataset that can be used to detect the type of Iris plant given.
This data set had 4 features: SepalLength, SepalWidth, PetalLength, PetalWidth and had 3 classes: Iris Setosa, Iris Versicolour, or Iris Virginica.
To make this a binary classification problem, I chose to do 1 if Iris Setosa and -1 if not Iris Setosa. This homework trains on a given dataset and will predict if an Iris plant is class Setosa or not based on it's given features.

Dataset Information:
What do the instances in this dataset represent?
Each instance is a plant

Additional Information
This is one of the earliest datasets used in the literature on classification methods and widely used in statistics and machine learning.  The data set contains 3 classes of 50 instances each, where each class refers to a type of iris plant.  One class is linearly separable from the other 2; the latter are not linearly separable from each other.

Predicted attribute: class of iris plant.
This is an exceedingly simple domain.

This data differs from the data presented in Fishers article (identified by Steve Chadwick,  spchadwick@espeedaz.net ).  The 35th sample should be: 4.9,3.1,1.5,0.2,"Iris-setosa" where the error is in the fourth feature. The 38th sample: 4.9,3.6,1.4,0.1,"Iris-setosa" where the errors are in the second and third features.  
