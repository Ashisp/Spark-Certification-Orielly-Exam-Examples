import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object toTransformation {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)

    val a = sc.parallelize(1 to 10)
    a.map(f => f.to(10)).foreach(println)
  }

}