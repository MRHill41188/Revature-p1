import org.apache.spark.sql.SparkSession


object adminLogin {

  def showMenu(userName: String): Unit = {

    println(Console.BOLD + "Welcome admin " + userName)
    println(Console.BOLD + "Here are the result of the queries")
    println("")
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
    spark.sql("create table IF NOT EXISTS PoliceShooting(Id int,Victim_name varchar(255),Victim_age int,Victim_gender varchar(255),Victim_race varchar(255),Date_of_Incident date,City varchar(255),State varchar(255),Zipcode Int,Agency_responsible_for_death varchar(255),Cause_of_death varchar(255),Criminal_Charges varchar(255),Symptoms_of_mental_illness varchar(255),Alleged_Weapon varchar(255),Alleged_Threat_Level varchar(255),Fleeing varchar(255),Armed_Unarmed_Status varchar(255)) row format delimited fields terminated by ','")
    spark.sql("LOAD DATA LOCAL INPATH 'input/USPoliceViolence.csv' INTO TABLE PoliceShooting")
    spark.sql("SELECT * FROM PoliceShooting").show()
    println("")
    pressEnterToContinue()

  }

  def pressEnterToContinue(): Unit ={

    println(Console.BOLD + "Press enter to log out and return to main menu")
      val input = scala.io.StdIn.readLine()

  }
}

