package controllers

import play.api.Play.current
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.db._
import play.api.libs._

object Application extends Controller {

  def index = Action {
    Ok("Why u usin' dis?")
  }

}
