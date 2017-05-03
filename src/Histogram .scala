import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object Histogram {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)
    
    val a = sc.parallelize(List(1.1, 1.2, 1.3, 2.0, 2.1, 7.4, 7.5, 7.6,
      8.8, 9.0), 3)
    a.histogram(5)
    

  }
}