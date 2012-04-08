package controllers

import play.api._
import play.api.mvc._

import play.api.templates._

/*
 * cake layer
 */
trait Application extends Controller {
    val message: String
	def index = Action {
	    Ok(message)
	}
}

trait ControllersPlugin extends Plugin {
    val application: Application 
}

/*
 * plugin trait to be implemented via plugins
 */
trait ActorsPlugin extends Plugin {
	val message: String
}
