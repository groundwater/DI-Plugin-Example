package controllers

class FullControllersPlugin(app: play.api.Application) extends ControllersPlugin {
    lazy val msg = app.plugin(classOf[ActorsPlugin]).get.message
    lazy val application = new Application{val message = msg}
} 

/*
 * production plugin implementation
 */
class FullActorsPlugin(app: play.api.Application) extends ActorsPlugin {
	val message = "Hello World"
}

