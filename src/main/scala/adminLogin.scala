import scala.io.StdIn.readLine

object adminLogin {

  def showMenu(){

    println(Console.BOLD + "Welcome admin user")
    println("Please select from the list below")
    println("1. Show result for all queries")
    println("2. Add basic user")
    println("3. Update basic user")
    println("4. Remove basic user")
    println("0. log out and return to main menu")
    scala.io.StdIn.readInt()

  }

  def switchMenu(selection: Int): Unit = {
    selection match{
      case 1 => {adminLogin.showMenu()}
      // case 2 => {seasonalMenu.showMenu()}
      //case 3 => {careerMenu.showMenu()}
      //case 4 => {miscMenu.showMenu()}
      case 0 => {launcher.mainMenu()}
    }

  }


}
