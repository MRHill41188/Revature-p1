import org.apache.hadoop.hdfs.server.common.JspHelper.Url
import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException
import java.sql.SQLTimeoutException
import java.sql.PreparedStatement


/**
 * A Scala JDBC connection example by Alvin Alexander,
 * https://alvinalexander.com
 */
object connectionUtil {

    // provide driver, url, username, password for the database
    val driver = "com.mysql.jdbc.Driver"
    //val url = "jdbc:mysql://localhost:3306/databasetest"
    //val username = "username"
    //val password = "password"
    // instead of hard coding in username and password use system variables
    val url = System.getenv("JDBC_DATABASE")
    val username = System.getenv("JDBC_USERNAME")
    val password = System.getenv("JDBC_PASSWORD")

    // there's probably a better way to do this



  def gameRecords() :Unit ={
    var connection: Connection = null

    try {
      // make the connection
      //
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * from game_record")
      while (resultSet.next()) {
        val player_name = resultSet.getString("Player_name")
        val record_name = resultSet.getString("Record_Name")
        val stat = resultSet.getString("Stat")
        println(player_name +" "+record_name+" "+ stat)

      }
    } catch {
      case e: Throwable => e.printStackTrace
    }
    finally {
      connection.close()
    }
  }

  def seasonalRecords() :Unit ={
    var connection: Connection = null

    try {
      // make the connection
      //Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * from seasonal_record")
      while (resultSet.next()) {
        val player_name = resultSet.getString("Player_name")
        val record_name = resultSet.getString("Record_Name")
        val stat = resultSet.getString("Stat")
        println(player_name +" "+record_name+" "+ stat)

      }
    } catch {
      case e: Throwable => e.printStackTrace
    }
    finally {
      connection.close()
    }
  }
  def careerRecords() :Unit ={
    var connection: Connection = null

    try {
      // make the connection
      //Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * from career_record")
      while (resultSet.next()) {
        val player_name = resultSet.getString("Player_name")
        val record_name = resultSet.getString("Record_Name")
        val stat = resultSet.getString("Stat")
        println(player_name +" "+record_name+" "+ stat)

      }
    } catch {
      case e: Throwable => e.printStackTrace
    }
    finally {
      connection.close()
    }
  }
  def miscRecords() :Unit ={
    var connection: Connection = null

    try {
      // make the connection
      //Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * from misc_record")
      while (resultSet.next()) {
        val player_name = resultSet.getString("Player_name")
        val record_name = resultSet.getString("Record_Name")
        val stat = resultSet.getString("Stat")
        println(player_name +" "+record_name+" "+ stat)

      }
    } catch {
      case e: Throwable => e.printStackTrace
    }
    finally {
      connection.close()
    }
  }

}