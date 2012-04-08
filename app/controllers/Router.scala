package controllers

import play.api.Play.current

object Route {
    val application = current.plugin(
            classOf[ControllersPlugin]).get.application
}
