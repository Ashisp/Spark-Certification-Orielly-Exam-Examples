
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.feature.HashingTF
import org.apache.spark.mllib.feature.IDF
import org.apache.spark.rdd.RDD
import java.text.Normalizer.Form
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.classification.NaiveBayes

object Mlib {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("Mlib")
    val sc = new SparkContext(conf)
    val spam = sc.textFile("files/spam.txt")
    val ham = sc.textFile("files/ham.txt")
    val tf = new HashingTF(numFeatures = 100)

    val spamFeatures = spam.map(email => tf.transform(email.split(" ")))
    val hamFeatures = ham.map(email => tf.transform(email.split(" ")))

    val positiveExamples = spamFeatures.map(features => LabeledPoint(1, features))
    val negativeExamples = hamFeatures.map(features => LabeledPoint(0, features))
    val trainingData = positiveExamples ++ negativeExamples

    val model = NaiveBayes.train(trainingData, lambda = 1.0, modelType = "multinomial")

  
    val posTestExample = tf.transform("Dear Spark Learner, Thanks so much for attending the Spark Summit 2014!...".split(" "))
    val negTestExample = tf.transform(" bomb ones you people here . ...".split(" "))
    println(model.predict(negTestExample))
    
    //The output will be 1.0 if given email is spam and 0.0 if the given email is non-spam great

    // TO test the system Accuracy we can do as below 
    
   /* val Array(training, test) = trainingData.randomSplit(Array(0.6, 0.4))

val model1 = NaiveBayes.train(training, lambda = 1.0, modelType = "multinomial")

    val predictionAndLabel = test.map(p => (model1.predict(p.features), p.label))
val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()
    */
  
    
    
    
  }
}