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
          val rs = stmt.executeQuery("select p.Name, p.Description, p.Rating, p.Quantity, p.Cost, i.imagePath from Products as p inner join ProductImage as i on i.productID = p.id")
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



          response = Json.obj("products"->Json.toJson(products.toSeq))
        } finally {
          conn.close()
        }
      }.getOrElse {
        Unauthorized("Not logged in")
      }
    Ok(response)
  }
}
