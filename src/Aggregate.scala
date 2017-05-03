import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Aggregate {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)

    val z = sc.parallelize(List(1, 2, 3, 4, 5, 6))

    val agg = z.aggregate((0,0))((acc, value) => (acc._1+value,acc._2+1),(acc1,acc2) => (acc1._1+acc2._1,acc1._2+acc2._2))
    
    
    
           
       
    print(agg)

  }
}