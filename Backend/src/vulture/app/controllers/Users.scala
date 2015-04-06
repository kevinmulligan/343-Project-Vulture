package controllers

import play.api.Play.current
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.db._
import play.api.libs._

object Users extends Controller {

  def info = Action { request =>
    var response : JsValue = Json.obj("error"->"error")
    request.session.get("connected").map { user =>

      val conn = DB.getConnection()

      try {
          val stmt = conn.createStatement
          val rs = stmt.executeQuery("select u.Username, u.Email, u.FirstName, u.LastName, u.Address, u.City, u.State, u.ZipCode, u.Age, s.Name as Sexuality, g.Name as Gender, a.Name as Accent FROM Users u inner join Sexuality s on u.Sexuality = s.id inner join Gender g on u.Gender = g.id inner join Accent a on u.Accent = a.id where u.Email = '" + user + "'")
          while(rs.next()) {
            val username = rs.getString("Username")        
            val email = rs.getString("Email")        
            val fname = rs.getString("FirstName")        
            val lname = rs.getString("LastName")        
            val address = rs.getString("Address")        
            val city = rs.getString("City")        
            val state = rs.getString("State")        
            val zip = rs.getString("ZipCode")        
            val age = rs.getString("Age")        
            val sexuality = rs.getString("Sexuality")        
            val gender = rs.getString("Gender")        
            val accent = rs.getString("Accent")
          
            val json: JsValue = Json.obj(
                  "username"->username,
                  "email"->email,
                  "first"->fname,
                  "last"->lname,
                  "address"->address,
                  "city"->city,
                  "zip"->zip,
                  "age"->age,
                  "sexuality"->sexuality,
                  "gender"->gender,
                  "accent"->accent)
           response = json
          }
        } finally {
          conn.close()
        }
      }.getOrElse {
        Unauthorized("Not logged in")
      }
    Ok(response)
  }
}
