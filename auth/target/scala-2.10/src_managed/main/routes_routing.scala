// @SOURCE:/Users/calfinz/activator-1.3.2-minimal/auth/conf/routes
// @HASH:359923fcaea9cf4578bfef1faa69aedd78348d18
// @DATE:Mon Apr 06 15:27:26 EDT 2015


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_CoffeesController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Application_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:10
private[this] lazy val controllers_Application_authenticate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:11
private[this] lazy val controllers_Application_logout3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:14
private[this] lazy val controllers_CoffeesController_list4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("coffees"))))
        

// @LINE:17
private[this] lazy val controllers_CoffeesController_create5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("coffees/new"))))
        

// @LINE:18
private[this] lazy val controllers_CoffeesController_save6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("coffees"))))
        

// @LINE:21
private[this] lazy val controllers_CoffeesController_edit7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("coffees/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:22
private[this] lazy val controllers_CoffeesController_update8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("coffees/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:25
private[this] lazy val controllers_CoffeesController_delete9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("coffees/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:28
private[this] lazy val controllers_Assets_at10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+"""))))
        
def documentation = List(("""GET""", prefix,"""controllers.CoffeesController.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """coffees""","""controllers.CoffeesController.list(p:Int ?= 0, s:Int ?= 2, f:String ?= "%")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """coffees/new""","""controllers.CoffeesController.create"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """coffees""","""controllers.CoffeesController.save"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """coffees/$id<[^/]+>""","""controllers.CoffeesController.edit(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """coffees/$id<[^/]+>""","""controllers.CoffeesController.update(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """coffees/$id<[^/]+>/delete""","""controllers.CoffeesController.delete(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_CoffeesController_index0(params) => {
   call { 
        invokeHandler(controllers.CoffeesController.index, HandlerDef(this, "controllers.CoffeesController", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Application_login1(params) => {
   call { 
        invokeHandler(controllers.Application.login, HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ Authentication""", Routes.prefix + """login"""))
   }
}
        

// @LINE:10
case controllers_Application_authenticate2(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate, HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:11
case controllers_Application_logout3(params) => {
   call { 
        invokeHandler(controllers.Application.logout, HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:14
case controllers_CoffeesController_list4(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[Int]("s", Some(2)), params.fromQuery[String]("f", Some("%"))) { (p, s, f) =>
        invokeHandler(controllers.CoffeesController.list(p, s, f), HandlerDef(this, "controllers.CoffeesController", "list", Seq(classOf[Int], classOf[Int], classOf[String]),"GET", """ Coffees list (look at the default values for pagination parameters)""", Routes.prefix + """coffees"""))
   }
}
        

// @LINE:17
case controllers_CoffeesController_create5(params) => {
   call { 
        invokeHandler(controllers.CoffeesController.create, HandlerDef(this, "controllers.CoffeesController", "create", Nil,"GET", """ Add coffee""", Routes.prefix + """coffees/new"""))
   }
}
        

// @LINE:18
case controllers_CoffeesController_save6(params) => {
   call { 
        invokeHandler(controllers.CoffeesController.save, HandlerDef(this, "controllers.CoffeesController", "save", Nil,"POST", """""", Routes.prefix + """coffees"""))
   }
}
        

// @LINE:21
case controllers_CoffeesController_edit7(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.CoffeesController.edit(id), HandlerDef(this, "controllers.CoffeesController", "edit", Seq(classOf[String]),"GET", """ Edit existing coffee""", Routes.prefix + """coffees/$id<[^/]+>"""))
   }
}
        

// @LINE:22
case controllers_CoffeesController_update8(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.CoffeesController.update(id), HandlerDef(this, "controllers.CoffeesController", "update", Seq(classOf[String]),"POST", """""", Routes.prefix + """coffees/$id<[^/]+>"""))
   }
}
        

// @LINE:25
case controllers_CoffeesController_delete9(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.CoffeesController.delete(id), HandlerDef(this, "controllers.CoffeesController", "delete", Seq(classOf[String]),"POST", """ Delete a computer""", Routes.prefix + """coffees/$id<[^/]+>/delete"""))
   }
}
        

// @LINE:28
case controllers_Assets_at10(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        