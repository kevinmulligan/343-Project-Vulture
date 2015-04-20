// @SOURCE:/Users/calfinz/activator-1.3.2-minimal/auth/conf/routes
// @HASH:359923fcaea9cf4578bfef1faa69aedd78348d18
// @DATE:Mon Apr 06 15:27:26 EDT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:6
class ReverseCoffeesController {
    

// @LINE:14
def list(p:Int = 0, s:Int = 2, f:String = "%"): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "coffees" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == 2) None else Some(implicitly[QueryStringBindable[Int]].unbind("s", s)), if(f == "%") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                

// @LINE:25
def delete(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "coffees/" + implicitly[PathBindable[String]].unbind("id", id) + "/delete")
}
                                                

// @LINE:21
def edit(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "coffees/" + implicitly[PathBindable[String]].unbind("id", id))
}
                                                

// @LINE:17
def create(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "coffees/new")
}
                                                

// @LINE:22
def update(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "coffees/" + implicitly[PathBindable[String]].unbind("id", id))
}
                                                

// @LINE:18
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "coffees")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseApplication {
    

// @LINE:10
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:11
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:9
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:6
class ReverseCoffeesController {
    

// @LINE:14
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CoffeesController.list",
   """
      function(p,s,f) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "coffees" + _qS([(p == null ? """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == null ? """ +  implicitly[JavascriptLitteral[Int]].to(2) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("s", s)), (f == null ? """ +  implicitly[JavascriptLitteral[String]].to("%") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                        

// @LINE:25
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CoffeesController.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "coffees/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:21
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CoffeesController.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "coffees/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:17
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CoffeesController.create",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "coffees/new"})
      }
   """
)
                        

// @LINE:22
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CoffeesController.update",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "coffees/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:18
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CoffeesController.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "coffees"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CoffeesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseApplication {
    

// @LINE:10
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:11
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:9
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:28
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:6
class ReverseCoffeesController {
    

// @LINE:14
def list(p:Int, s:Int, f:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CoffeesController.list(p, s, f), HandlerDef(this, "controllers.CoffeesController", "list", Seq(classOf[Int], classOf[Int], classOf[String]), "GET", """ Coffees list (look at the default values for pagination parameters)""", _prefix + """coffees""")
)
                      

// @LINE:25
def delete(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CoffeesController.delete(id), HandlerDef(this, "controllers.CoffeesController", "delete", Seq(classOf[String]), "POST", """ Delete a computer""", _prefix + """coffees/$id<[^/]+>/delete""")
)
                      

// @LINE:21
def edit(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CoffeesController.edit(id), HandlerDef(this, "controllers.CoffeesController", "edit", Seq(classOf[String]), "GET", """ Edit existing coffee""", _prefix + """coffees/$id<[^/]+>""")
)
                      

// @LINE:17
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CoffeesController.create(), HandlerDef(this, "controllers.CoffeesController", "create", Seq(), "GET", """ Add coffee""", _prefix + """coffees/new""")
)
                      

// @LINE:22
def update(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CoffeesController.update(id), HandlerDef(this, "controllers.CoffeesController", "update", Seq(classOf[String]), "POST", """""", _prefix + """coffees/$id<[^/]+>""")
)
                      

// @LINE:18
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CoffeesController.save(), HandlerDef(this, "controllers.CoffeesController", "save", Seq(), "POST", """""", _prefix + """coffees""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CoffeesController.index(), HandlerDef(this, "controllers.CoffeesController", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseApplication {
    

// @LINE:10
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:11
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:9
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """ Authentication""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      