package controllers

import play.api.Play.current
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.db._

object Application extends Controller {

  def index = Action {
    var outString = "Accents are "
    val conn = DB.getConnection()
    try {
      val stmt = conn.createStatement
      val rs = stmt.executeQuery("SELECT Name from Accent")
      while (rs.next()) {
        outString += rs.getString("Name") + " "
      }
    } finally {
      conn.close()
    }
    Ok(outString)
  }

}
