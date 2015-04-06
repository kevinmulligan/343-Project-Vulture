package controllers

import play.api.Play.current
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.db._
import play.api.libs._
import play.api.mvc.BodyParsers.parse

object Login extends Controller {
  def login  = Action(parse.json) { request => 
    val json = request.body.asInstanceOf[JsObject]
    var response = " "
    var session = " " 
    if ((json.keys.contains("username")) && (json.keys.contains("password"))) {
      val conn = DB.getConnection()
      val username = json \ "username"
      try {
        val stmt = conn.createStatement
        val query = "SELECT Password, Email from Users where Username=" + username  
        val rs = stmt.executeQuery(query)
        while(rs.next()) {
          val pass = rs.getString("Password")
          val email = rs.getString("Email")

          if(pass == Codecs.sha1((json \ "password").as[String])) {
            response = "Logged In"
            session = email
          } else {
            response = "Invalid password"
          }
        }
      } catch {
        case e=>
      	  response = "User doesn't exist"
      } finally {
        conn.close()
      }
    }
    Ok(response).withSession("connected" -> session)
  }

  def logout = Action { request =>
    request.session.get("connected").map { user =>
      Ok("Logged out").withNewSession
    }.getOrElse {
      Unauthorized("Not logged in")
    }
  }

}
