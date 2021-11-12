object changeUserInfo {

  def showMenu(){

    println(Console.BOLD + "Please enter your username")


    var userName = scala.io.StdIn.readLine()
    var password = ""
    var newUserName = ""
    var newPassword = ""

    if(userName != null){

      println(Console.BOLD +"Please enter your current password")
      password = scala.io.StdIn.readLine()
      //println(userName)
      //println(password)
      if(password != ""){

        println("Please enter your new username or enter your current username to keep it")
        newUserName = scala.io.StdIn.readLine()
        if(newUserName != ""){
          println("please enter your new password")
          newPassword = scala.io.StdIn.readLine()
        }
      }


    }

    connectionUtil.updateUser(userName, password, newUserName, newPassword)
  }

}
