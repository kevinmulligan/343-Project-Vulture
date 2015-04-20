package controllers

import play.api.Play.current
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.db._
import play.api.libs._

object Home extends Controller {

  def info = Action { request =>
    var response : JsValue = Json.obj("error"->"error")
    request.session.get("connected").map { user =>

      val conn = DB.getConnection()
      val products = scala.collection.mutable.Buffer[JsValue]()
      val tutors = scala.collection.mutable.Buffer[JsValue]()
      try {
          val stmt = conn.createStatement
          var rs = stmt.executeQuery("select p.Name, p.Description, p.Rating, p.Quantity, p.Cost, i.imagePath from Products as p inner join ProductImage as i on i.productID = p.id")
          while(rs.next()) {
            val name = rs.getString("Name")
            val desc = rs.getString("Description")
            val rating = rs.getInt("Rating")
            val quantity = rs.getInt("Quantity")
            val cost = rs.getDouble("Cost")
            val imagePath = rs.getString("imagePath")

            val product: JsValue = Json.obj(
                  "name"->name,
                  "desc"->desc,
                  "rating"->rating,
                  "quantity"->quantity,
                  "cost"->cost,
                  "imagePath"->imagePath)
           products.append(product)
          }

          rs = stmt.executeQuery("select t.CostPerHour, t.Rating, t.Description, t.Height, t.Weight, h.Name as HairColor, t.HasTattoos, u.FirstName from Tutor as t inner join HairColor as h on t.HairColor = h.id inner join Users as u on t.UserID = u.id")
          
          while(rs.next()) {
            val cph = rs.getString("CostPerHour")
            val rating = rs.getInt("Rating")
            val desc = rs.getString("Description")
            val height = rs.getInt("Height")
            val weight = rs.getInt("Weight")
            val haircolor = rs.getString("HairColor")
            val tattoos = rs.getBoolean("HasTattoos")
            val first = rs.getString("FirstName")

            val tutor: JsValue = Json.obj(
                 "costPerHour"->cph,
                 "rating"->rating,
                 "desc"->desc,
                 "height"->height,
                 "weight"->weight,
                 "hairColor"->haircolor,
                 "hasTattoos"->tattoos,
                 "firstName"->first)
            tutors.append(tutor)
          }

          response = Json.obj("products"->Json.toJson(products.toSeq), "tutors"->Json.toJson(tutors.toSeq))
        } finally {
          conn.close()
        }
      }.getOrElse {
        Unauthorized("Not logged in")
      }
    Ok(response)
  }
}
