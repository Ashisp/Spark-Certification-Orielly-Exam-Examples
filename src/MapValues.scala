import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object MapValues {
  def main(args: Array[String]): Unit = {

  val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)
  val a = sc . parallelize ( List (" dog " , " tiger " , " lion " , " cat " , " panther " , "eagle ") , 2)
val b = a.map( x =>( x . length , x ) )
b . mapValues (" x " + _ + " x ") .foreach(println)
 


  }
}