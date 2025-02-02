/*You have an RDD containing customer orders with the following schema: (order_id,
customer_id, order_date, order_total). You want to find the total revenue generated by each
customer. How would you approach this problem using RDD operations?*/

/*order_id,customer_id, order_date, order_total
1,10,20240710,100
3,10,20240711,200
2,12,20240710,150
4,12,20240713,450
5,14,20240710,350
6,10,20240713,750
5,14,20240710,700*/

import org.apache.spark.SparkContext

object SetA_1 {

  def main(args:Array[String]):Unit={

    val sc=new SparkContext("local[*]","Order_Details")
    val rdd1 = sc.textFile("C:/Seekho_BigData/data/Order_Details.txt")
    rdd1.foreach(println)
    //println(rdd1.getNumPartitions)
    val rdd2 = rdd1.map( x => x.split(","))
    val rdd3 = rdd2.map( x=> (x(1),x(3)))
    val rdd4 = rdd3.reduceByKey((x,y) => (x.toInt + y.toInt).toString)
    val rdd5 = rdd4.collect()

    for ( i <- rdd5 )
      {
        println(s"Total cost of order for customer ${i._1} is Rs ${i._2} ")
      }

  }



}
