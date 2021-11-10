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



  def addUser(u: String, p :String) :Unit ={
    var connection: Connection = null

    try {
      // make the connection
      //
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("insert into p1Users (userName, password, userType) VALUES "+ "('"+u+"',"+ "'"+p+"'"+ ",'basic')")
      while (resultSet.next()) {
       // val player_name = resultSet.getString("Player_name")
       //val record_name = resultSet.getString("Record_Name")
       // val stat = resultSet.getString("Stat")
       // println(player_name +" "+record_name+" "+ stat)

      }
    } catch {
      case e: Throwable => e.printStackTrace
    }
    finally {
      connection.close()
    }
  }

  def updateUser(u: String, p :String, nUser: String, nPass: String) :Unit ={
    var connection: Connection = null

    try {
      // make the connection
      //Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("select * from p1Users where userName = "+"'"+u+"'")
      while (resultSet.next()) {
        val userName = resultSet.getString("userName")
        val password = resultSet.getString("password")

        if(u == userName && p == password){
         // println("update starting")
          val sql = "update p1Users set userName = ?, password = ? where userName = ?"
          val statement = connection.prepareStatement(sql)

          statement.setString(3, u)
          statement.setString(1, nUser)
          statement.setString(2, nPass)

          val result = statement.executeUpdate()
          println(Console.BOLD+"Update Complete")
          println("")
        }


      }
    } catch {
      case e: Throwable => e.printStackTrace
    }
    finally {
      connection.close()
    }
  }

  def removeUser(u: String, p :String) :Unit ={
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
  def login(u: String, p :String) : Unit ={
    var connection: Connection = null

    try {
      // make the connection
      //Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("select * from p1Users where userName = "+"'"+u+"'")
      while (resultSet.next()) {
        val userName = resultSet.getString("userName")
        val password = resultSet.getString("password")
        val userType = resultSet.getString("userType")
        //println("u " + u)
        //println("username " + userName)
        //println("p " + p)
        //println("password " + password)
        if(u == userName && p == password && userType == "admin"){

          adminLogin.showMenu(userName)

        } else if (u == userName && p == password && userType == "basic"){

           basicLogin.showMenu(userName)

        }
      }
    } catch {
      case e: Throwable => e.printStackTrace
        //println("The username or password provided is incorrect")
        //loginScreen.showMenu()

    }
    finally {
      connection.close()
    }
  }

}