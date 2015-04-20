
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[scala.Tuple2[Coffee, Supplier]],Int,String,play.api.mvc.Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[(Coffee,Supplier)], currentOrderBy: Int, currentFilter: String)(implicit flash: play.api.mvc.Flash):play.api.templates.Html = {
        _display_ {
def /*19.2*/header/*19.8*/(orderBy: Int, title: String):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*19.41*/("""
    <th class="col"""),_display_(Seq[Any](/*20.20*/orderBy)),format.raw/*20.27*/(""" header """),_display_(Seq[Any](/*20.36*/if(scala.math.abs(currentOrderBy) == orderBy){/*20.83*/{if(currentOrderBy < 0) "headerSortDown" else "headerSortUp"}})),format.raw/*20.144*/("""">
        <a href=""""),_display_(Seq[Any](/*21.19*/link(0, Some(orderBy)))),format.raw/*21.41*/("""">"""),_display_(Seq[Any](/*21.44*/title)),format.raw/*21.49*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage: Int, newOrderBy: Option[Int] = None) = {{
    routes.CoffeesController.list(
    newPage, 
    newOrderBy.map { orderBy =>
        if(orderBy == scala.math.abs(currentOrderBy)) -currentOrderBy else orderBy
    }.getOrElse(currentOrderBy),
    currentFilter)
    
}};
Seq[Any](format.raw/*1.120*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*14.2*/("""

"""),format.raw/*18.37*/("""
"""),format.raw/*23.2*/("""

"""),_display_(Seq[Any](/*25.2*/main/*25.6*/ {_display_(Seq[Any](format.raw/*25.8*/("""
    

  <section id="items">
    <div id='daily-product' class='daily'>
    </div>
    <div id='daily-tutor' class="daily">
    </div>
  </section>
""")))})))}
    }
    
    def render(currentPage:Page[scala.Tuple2[Coffee, Supplier]],currentOrderBy:Int,currentFilter:String,flash:play.api.mvc.Flash): play.api.templates.Html = apply(currentPage,currentOrderBy,currentFilter)(flash)
    
    def f:((Page[scala.Tuple2[Coffee, Supplier]],Int,String) => (play.api.mvc.Flash) => play.api.templates.Html) = (currentPage,currentOrderBy,currentFilter) => (flash) => apply(currentPage,currentOrderBy,currentFilter)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 06 17:14:10 EDT 2015
                    SOURCE: /Users/calfinz/activator-1.3.2-minimal/auth/app/views/coffees/list.scala.html
                    HASH: fed2913398bf96cb4731ec0950d7918a775d5ff3
                    MATRIX: 572->1|751->638|765->644|862->677|918->697|947->704|992->713|1047->760|1132->821|1189->842|1233->864|1272->867|1299->872|1337->248|1348->252|1653->119|1682->246|1710->526|1740->636|1768->888|1806->891|1818->895|1857->897
                    LINES: 19->1|21->19|21->19|23->19|24->20|24->20|24->20|24->20|24->20|25->21|25->21|25->21|25->21|27->6|27->6|36->1|38->5|39->14|41->18|42->23|44->25|44->25|44->25
                    -- GENERATED --
                */
            