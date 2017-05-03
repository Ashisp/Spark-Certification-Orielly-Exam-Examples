import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object TransformationsAndActions {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)
    val a = sc.parallelize(List(" dog ", " salmon ", " salmon ", " rat ", " elephant"), 3)
    val b = a.keyBy(_.length)
    val c = sc.parallelize(List(" dog ", " cat ", " gnu ", " salmon ", " rabbit ", " turkey", " wolf ", " bear ", " bee "), 3)
    val d = c.keyBy(_.length)
    b.leftOuterJoin(d).collect.foreach(println)

  }
}