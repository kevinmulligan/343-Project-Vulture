
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[scala.Tuple2[String, String]],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form: Form[(String,String)])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.54*/("""

<html>
    <head>
        <title>Login</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.59*/routes/*6.65*/.Assets.at("images/favicon.png"))),format.raw/*6.97*/("""">
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/main.css"))),format.raw/*7.110*/("""">
         <link href='http://fonts.googleapis.com/css?family=Oswald:400,700' rel='stylesheet' type='text/css'>
    </head>
    <body>

        	<header>
            	<span id="title"> VULTURE </span>
            </header>
        
          <article id="login-field">
   		Login with username and password	
        """),_display_(Seq[Any](/*18.10*/helper/*18.16*/.form(routes.Application.authenticate)/*18.54*/ {_display_(Seq[Any](format.raw/*18.56*/("""
            
            
 
                Username: <input type="text" name="email" placeholder="Username" id="email" value=""""),_display_(Seq[Any](/*22.101*/form("email")/*22.114*/.value)),format.raw/*22.120*/(""""> </br>

                Password: <input type="password" name="password" id="password" placeholder="Password"> </br>
				<br>
                <input type="submit" id="loginbutton" value="Login">

			"""),_display_(Seq[Any](/*28.5*/form/*28.9*/.globalError.map/*28.25*/ { error =>_display_(Seq[Any](format.raw/*28.36*/("""
                <p class="error">
                    """),_display_(Seq[Any](/*30.22*/error/*30.27*/.message)),format.raw/*30.35*/("""
                </p>
            """)))})),format.raw/*32.14*/("""
            
            """),_display_(Seq[Any](/*34.14*/flash/*34.19*/.get("success").map/*34.38*/ { message =>_display_(Seq[Any](format.raw/*34.51*/("""
                <p class="success">
                    """),_display_(Seq[Any](/*36.22*/message)),format.raw/*36.29*/("""
                </p>
            """)))})),format.raw/*38.14*/("""
           
        """)))})),format.raw/*40.10*/("""
           </article>
            
    </body>
</html>
    


"""))}
    }
    
    def render(form:Form[scala.Tuple2[String, String]],flash:Flash): play.api.templates.Html = apply(form)(flash)
    
    def f:((Form[scala.Tuple2[String, String]]) => (Flash) => play.api.templates.Html) = (form) => (flash) => apply(form)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 06 16:52:30 EDT 2015
                    SOURCE: /Users/calfinz/activator-1.3.2-minimal/auth/app/views/login.scala.html
                    HASH: 657bc492d6ed955c3c4a802ec5d3f2613bfe03e5
                    MATRIX: 539->1|668->53|810->160|824->166|877->198|984->270|998->276|1054->310|1408->628|1423->634|1470->672|1510->674|1676->803|1699->816|1728->822|1965->1024|1977->1028|2002->1044|2051->1055|2143->1111|2157->1116|2187->1124|2254->1159|2317->1186|2331->1191|2359->1210|2410->1223|2504->1281|2533->1288|2600->1323|2654->1345
                    LINES: 19->1|22->1|27->6|27->6|27->6|28->7|28->7|28->7|39->18|39->18|39->18|39->18|43->22|43->22|43->22|49->28|49->28|49->28|49->28|51->30|51->30|51->30|53->32|55->34|55->34|55->34|55->34|57->36|57->36|59->38|61->40
                    -- GENERATED --
                */
            