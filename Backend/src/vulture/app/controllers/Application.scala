package controllers

import play.api.Play.current
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.db._
import play.api.libs._

object Application extends Controller {

  def index = Action {
    var outString = "Passwords are "
    val conn = DB.getConnection()
    try {
      val stmt = conn.createStatement
      val rs = stmt.executeQuery("SELECT Password from Users where Username='tswift'")
      while (rs.next()) {
        outString += rs.getString("Password") + " "
      }
    } finally {
      conn.close()
    }
    outString += Codecs.sha1("dickbutt")
    Ok(outString)
  }

}
