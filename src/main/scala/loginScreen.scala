object loginScreen {

  def showMenu(){

    println(Console.BOLD + "Please enter your username")


    var userName = scala.io.StdIn.readLine()
    var password = "password"

    if(userName != null){

      println(Console.BOLD +"Please enter your password")
      password = scala.io.StdIn.readLine()

    }

    connectionUtil.login(userName, password)
  }

}
