import org.apache.spark.SparkConf
import scala.collection.JavaConversions._
import org.apache.spark._
import org.apache.hadoop.mapred.KeyValueTextInputFormat
import org.apache.hadoop.io.{MapWritable, Text}
import java.util.HashMap





object HadoopInput {
  def main(args: Array[String]): Unit = {
val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)


 val input = sc.hadoopFile[Text, Text, KeyValueTextInputFormat]("/home/lt106/Downloads/BigData/spark-2.1.0-bin-hadoop2.7/README.md").map{
      case (x, y) => (x.toString, y.toString)
    }

input.collect().foreach(println)
  
  



  }
}