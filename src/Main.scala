import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object Main {
  def main(args: Array[String]): Unit = {
    
    val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)
    val file = sc.textFile("/home/lt106/Downloads/BigData/spark-2.1.0-bin-hadoop2.7/README.md")
   val words = file.flatMap(lines=> lines.split(" "))
   val pairs = words.map(word=> (word,1))

   val counts = pairs.reduceByKey((x,y)=> x+y)
   counts.collect().foreach(println)
  
  }
  
}