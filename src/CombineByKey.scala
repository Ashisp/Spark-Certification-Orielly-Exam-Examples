import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object CombineByKey {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)

    val a = sc.parallelize(List(" dog ", " cat ", " gnu ", " salmon ", " rabbit ", " turkey", " wolf ", " bear ", " bee "), 3)
    val b = sc.parallelize(List(1, 1, 2, 2, 2, 1, 2, 2, 2), 3)
   val c =  b.zip(a)
val x = a++a
x.collect().foreach(println)
//combineByKey
   
   //Array((1,List(dog,cat,turkey))

  }
}