
package views.html.coffees

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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.17*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>Coffee database</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/(""""> 
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*8.70*/routes/*8.76*/.Assets.at("stylesheets/Style.css"))),format.raw/*8.111*/(""""> 
          <link href='http://fonts.googleapis.com/css?family=Oswald:400,700' rel='stylesheet' type='text/css'>
        <script src="assets/javascripts/main.js" charset="UTF-8"></script>
    </head>
    <body>
        
  <header>
		<span id="title" onclick='parent.location="index.html"'> VULTURE </span>
		<input id="search-bar" type="search" placeholder="Search...">
		<span id="account-buttons">
		  Welcome User
		  <a id='log-in' href="/logout">Log out</a>
		</span>
  </header>
        
     
            """),_display_(Seq[Any](/*24.14*/content)),format.raw/*24.21*/("""
    
        
    </body>
</html>"""))}
    }
    
    def render(content:Html): play.api.templates.Html = apply(content)
    
    def f:((Html) => play.api.templates.Html) = (content) => apply(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 06 17:47:19 EDT 2015
                    SOURCE: /Users/calfinz/activator-1.3.2-minimal/auth/app/views/coffees/main.scala.html
                    HASH: 4c7fbeae289cce4fb17dfa05451f53b69694e9ea
                    MATRIX: 510->1|602->16|781->160|795->166|860->209|968->282|982->288|1039->323|1590->838|1619->845
                    LINES: 19->1|22->1|28->7|28->7|28->7|29->8|29->8|29->8|45->24|45->24
                    -- GENERATED --
                */
            