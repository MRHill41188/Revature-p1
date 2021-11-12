import adminLogin.pressEnterToContinue
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object basicLogin {

  def showMenu(userName: String): Unit ={

    System.setProperty("hadoop.home.dir", "C:\\hadoop")
    val spark = SparkSession
      .builder
      .appName("hello hive")
      .config("spark.master", "local")
      .enableHiveSupport()
      .getOrCreate()
    //println("created spark session")
    spark.sparkContext.setLogLevel("OFF")
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)
    Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
    Logger.getRootLogger.setLevel(Level.OFF)
    //spark.sparkContext.setLogLevel("ERROR")
    spark.sql("DROP table IF EXISTS PoliceShooting")
    spark.sql("create table IF NOT EXISTS PoliceShooting(Id int,Victim_name varchar(255),Victim_age int,Victim_gender varchar(255),Victim_race varchar(255),Date_of_Incident date,City varchar(255),State varchar(255),Zipcode Int,Agency_responsible_for_death varchar(255),Cause_of_death varchar(255),Criminal_Charges varchar(255),Symptoms_of_mental_illness varchar(255),Alleged_Weapon varchar(255),Alleged_Threat_Level varchar(255),Fleeing varchar(255),Armed_Unarmed_Status varchar(255)) row format delimited fields terminated by ','")
    spark.sql("LOAD DATA LOCAL INPATH 'input/USPoliceViolence.csv' INTO TABLE PoliceShooting")

    println(Console.BOLD + "Welcome basic " + userName)
    println(Console.BOLD + "The results of the queries are being prepared, please wait")
    println("")
    // 1
    println(Console.BOLD+"Top 5 cities with incident")
    spark.sql("SELECT City, COUNT(*) FROM PoliceShooting Group by(City) order by(COUNT(1)) DESC").show(5)
    //2
    println(Console.BOLD+"number of incidents by race")
    spark.sql("SELECT victim_race, COUNT(*) FROM PoliceShooting Group by(victim_race) order by(COUNT(1)) DESC").show(5)
    //3
    println(Console.BOLD+"number of incidents by gender")
    spark.sql("SELECT victim_gender, COUNT(*) FROM PoliceShooting Group by(victim_gender) order by(COUNT(1)) DESC").show(4)
    //4
    println(Console.BOLD+"number of incidents per year")
    spark.sql("SELECT year(date_of_incident), COUNT(*) FROM PoliceShooting Group by(year(date_of_incident)) order by(year(date_of_incident)) DESC").show(8)
    //5
    println(Console.BOLD+"Number of incident with armed vs unarmed suspects")
    spark.sql("SELECT Armed_Unarmed_Status, COUNT(*) FROM PoliceShooting Group by(Armed_Unarmed_Status) order by(COUNT(1)) DESC").show(5)
    //6


    pressEnterToContinue()

  }

}
