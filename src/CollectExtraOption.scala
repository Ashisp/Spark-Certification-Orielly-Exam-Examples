import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object CollectExtraOption {
  def main(args: Array[String]): Unit = {
    
    val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)
    val a = sc . parallelize ( List (" cat " , " horse " , 4.0 , 3.5 , 2 , " dog ") )
a . collect ({ case a : Int => " is integer " ;case b : String => " is string " }) . collect}.foreach(println)
}