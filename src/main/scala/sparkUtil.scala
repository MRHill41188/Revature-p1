import org.apache.spark.sql.SparkSession

object sparkUtil {

    def main(args: Array[String]): Unit = {
      // create a spark session
      // for Windows
      System.setProperty("hadoop.home.dir", "C:\\winutils")
      System.setProperty("hadoop.home.dir", "C:\\hadoop")
      val spark = SparkSession
        .builder
        .appName("hello hive")
        .config("spark.master", "local")
        .enableHiveSupport()
        .getOrCreate()
      println("created spark session")
      spark.sparkContext.setLogLevel("ERROR")
      spark.sql("DROP table IF EXISTS PoliceShooting")
      spark.sql("create table IF NOT EXISTS PoliceShooting(Beverage String,BranchID String) row format delimited fields terminated by ','");
      spark.sql("LOAD DATA LOCAL INPATH 'input/USPoliceViolence.csv' INTO TABLE PoliceShooting")
      spark.sql("SELECT * FROM PoliceShooting").show()
      //spark.sql("SELECT Count(*) AS NumBranch2BevAFile FROM BevA WHERE BevA.BranchID='Branch2'").show()
      //spark.sql("SELECT * FROM BevA").show()

      //query 1

      //query 2

      //query 3

      //query 4

      //query 5

      //query 6

      //query 7 future prediction


    }
  }
