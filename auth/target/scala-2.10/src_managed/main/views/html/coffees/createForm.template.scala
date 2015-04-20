
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Coffee],Seq[scala.Tuple2[String, String]],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(coffeeForm: Form[Coffee], suppliers: Seq[(String, String)]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq[Any](format.raw/*1.62*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/(""" 

"""),_display_(Seq[Any](/*7.2*/main/*7.6*/ {_display_(Seq[Any](format.raw/*7.8*/("""
    
    <h1>Add a coffee</h1>
    
    """),_display_(Seq[Any](/*11.6*/form(routes.CoffeesController.save())/*11.43*/ {_display_(Seq[Any](format.raw/*11.45*/("""
        
        <fieldset>
        
            """),_display_(Seq[Any](/*15.14*/inputText(coffeeForm("name"), '_label -> "Coffee name"))),format.raw/*15.69*/("""
            """),_display_(Seq[Any](/*16.14*/inputText(coffeeForm("price"), '_label -> "Price"))),format.raw/*16.64*/("""
            """),_display_(Seq[Any](/*17.14*/inputText(coffeeForm("sales"), '_label -> "Sales"))),format.raw/*17.64*/("""
            """),_display_(Seq[Any](/*18.14*/inputText(coffeeForm("total"), '_label -> "Total"))),format.raw/*18.64*/("""

            """),_display_(Seq[Any](/*20.14*/select(
                coffeeForm("supID"), 
                suppliers, 
                '_label -> "Supplier", '_default -> "-- Choose a supplier --",
                '_showConstraints -> false
            ))),format.raw/*25.14*/("""
            

        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Create this coffee" class="btn primary"> or 
            <a href=""""),_display_(Seq[Any](/*32.23*/routes/*32.29*/.CoffeesController.list())),format.raw/*32.54*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*35.6*/("""
    
""")))})),format.raw/*37.2*/("""
"""))}
    }
    
    def render(coffeeForm:Form[Coffee],suppliers:Seq[scala.Tuple2[String, String]]): play.api.templates.Html = apply(coffeeForm,suppliers)
    
    def f:((Form[Coffee],Seq[scala.Tuple2[String, String]]) => play.api.templates.Html) = (coffeeForm,suppliers) => apply(coffeeForm,suppliers)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 06 15:27:28 EDT 2015
                    SOURCE: /Users/calfinz/activator-1.3.2-minimal/auth/app/views/coffees/createForm.scala.html
                    HASH: 457b91723749df324a25c4cec7b06db5e4b3ba94
                    MATRIX: 558->1|703->82|735->106|814->61|842->80|870->155|908->159|919->163|957->165|1034->207|1080->244|1120->246|1207->297|1284->352|1334->366|1406->416|1456->430|1528->480|1578->494|1650->544|1701->559|1932->768|2149->949|2164->955|2211->980|2297->1035|2335->1042
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|41->20|46->25|53->32|53->32|53->32|56->35|58->37
                    -- GENERATED --
                */
            