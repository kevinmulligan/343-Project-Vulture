package controllers

import play.api.Play.current
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.db._
import play.api.libs._

object Product extends Controller {

  def getProduct(id: Int) = Action { request =>
    var response : JsValue = Json.obj("error"->"error")
    request.session.get("connected").map { user =>
      val conn = DB.getConnection()
      try {
          val stmt = conn.createStatement
          var rs = stmt.executeQuery("select p.Name, p.Description, p.Rating, p.Quantity, p.Cost, i.imagePath from Products as p inner join ProductImage as i on i.productID = p.id where p.id="+id)
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
            response = product 
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
