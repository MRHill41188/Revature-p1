object basicLogin {

  def showMenu(userName: String): Unit ={

    println(Console.BOLD + "Welcome basic " + userName)
    println(Console.BOLD + "Here are the result of the queries")
    println("")
    //spark stuff here
    println("")
    adminLogin.pressEnterToContinue()

  }

}
