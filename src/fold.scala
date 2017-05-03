import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object fold {
  def main(args: Array[String]): Unit = {
     val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)
     
    val a = sc . parallelize ( List (1 ,2 ,3),3)
    val folded = a.fold(1)(_ + _)
    print(folded)

  }
}