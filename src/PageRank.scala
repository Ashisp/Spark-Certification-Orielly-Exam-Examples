import org.apache.spark.{ SparkContext, SparkConf }

/**
 * Page Rank Algorthm
 */
object PageRank {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("World Count in scala")
    val sc = new SparkContext(conf)
    //Get the start time 
    val start = System.currentTimeMillis()

    val lines = sc.textFile("/home/lt106/Downloads/BigData/spark-2.1.0-bin-hadoop2.7/data/mllib/pagerank_data.txt")

    val links = lines.map { s =>
      val parts = s.split("\\s+")
      (parts(0), parts(1))
    }.distinct().groupByKey().cache()
    var ranks = links.mapValues(v => 1.0)

    for (i <- 1 to 10) {
      val contribs = links.join(ranks).values.flatMap {
        case (urls, rank) =>
          val size = urls.size
          urls.map(url => (url, rank / size))
      }
      ranks = contribs.reduceByKey(_ + _).mapValues(0.15 + 0.85 * _)
    }

    val output = ranks.collect()
    output.foreach(tup => println(tup._1 + " has rank: " + tup._2 + "."))
    // get the end time 
    val end = System.currentTimeMillis()
    println("Iteration took " + (end - start) + " ms")
  }

}