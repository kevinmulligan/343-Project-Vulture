
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Form[Coffee],Seq[scala.Tuple2[String, String]],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(pk: String, coffeeForm: Form[Coffee], suppliers : Seq[(String, String)]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq[Any](format.raw/*1.75*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/("""

"""),_display_(Seq[Any](/*7.2*/main/*7.6*/ {_display_(Seq[Any](format.raw/*7.8*/("""
    
    <h1>Edit coffee</h1>
    
    """),_display_(Seq[Any](/*11.6*/form(routes.CoffeesController.update(pk))/*11.47*/ {_display_(Seq[Any](format.raw/*11.49*/("""
    
        <fieldset>
        
            """),_display_(Seq[Any](/*15.14*/inputText(coffeeForm("name"),  '_label -> "Coffee name"))),format.raw/*15.70*/("""
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
            <input type="submit" value="Save this coffee" class="btn primary"> or 
            <a href=""""),_display_(Seq[Any](/*31.23*/routes/*31.29*/.CoffeesController.list())),format.raw/*31.54*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*34.6*/("""
    
    """),_display_(Seq[Any](/*36.6*/form(routes.CoffeesController.delete(pk), 'class -> "topRight")/*36.69*/ {_display_(Seq[Any](format.raw/*36.71*/("""
        <input type="submit" value="Delete this coffee" class="btn danger">
    """)))})),format.raw/*38.6*/("""
    
""")))})),format.raw/*40.2*/("""
"""))}
    }
    
    def render(pk:String,coffeeForm:Form[Coffee],suppliers:Seq[scala.Tuple2[String, String]]): play.api.templates.Html = apply(pk,coffeeForm,suppliers)
    
    def f:((String,Form[Coffee],Seq[scala.Tuple2[String, String]]) => play.api.templates.Html) = (pk,coffeeForm,suppliers) => apply(pk,coffeeForm,suppliers)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 06 15:27:28 EDT 2015
                    SOURCE: /Users/calfinz/activator-1.3.2-minimal/auth/app/views/coffees/editForm.scala.html
                    HASH: 790fb87eca85f2477cbefefaa6333b90cf6979c0
                    MATRIX: 563->1|721->95|753->119|832->74|860->93|888->168|925->171|936->175|974->177|1050->218|1100->259|1140->261|1223->308|1301->364|1351->378|1423->428|1473->442|1545->492|1595->506|1667->556|1718->571|1949->780|2163->958|2178->964|2225->989|2311->1044|2357->1055|2429->1118|2469->1120|2582->1202|2620->1209
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|41->20|46->25|52->31|52->31|52->31|55->34|57->36|57->36|57->36|59->38|61->40
                    -- GENERATED --
                */
            