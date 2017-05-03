import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object CollectAsMap {
  
  def main(args: Array[String]): Unit = {
     val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)

  val a = sc . parallelize ( List (1 , 2 , 1 , 3) , 1)
val b = a . zip ( a )
b. collectAsMap.foreach(println)
  }
}