import scala.io.StdIn.readInt
import scala.sys._
import scala.util.control._


object launcher extends App {


 // def main(args: Array[String]): Unit = {

    //mainMenu()

  //}

  def mainMenu():Int = {

    println("Please Enter Your Selection")
    println(Console.BOLD+"1. Login")
    println(Console.BOLD+"2. Update User Login")
    println(Console.BOLD+"0. Close Program")
    readInt()
  }

  def selectionLoop(): Unit = {

    var selection = 0

    do {
      selection = mainMenu()
      //println(selection+  "before swtich menu")
      switchMenu(selection)
      //println(selection + "after switch")
    }while(selection != 0)

  }


  def switchMenu(selection: Int): Unit = {
      selection match{
                  case 1 => {loginScreen.showMenu()}
                  case 2 => {changeUserInfo.showMenu()}
                  case _ => {launcher.mainMenu()}
                  case 0 => {print(Console.BOLD+"Exiting program")}
      }

  }
  selectionLoop()
}

