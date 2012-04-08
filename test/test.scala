package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

import controllers.ActorsPlugin

/*
 * replacement implementation of ActorInjector trait
 */
class MockActorInjector(app: play.api.Application) extends ActorsPlugin {
	val message = "I'm a mock injector"
}

/* 
 * test using above plugin
 */
class FakeApp extends Specification {
    "fake application" should {
		"load mock dependency" in {
			running(TestServer(9000, FakeApplication(
				additionalPlugins = Seq("test.MockActorInjector")
			)), HTMLUNIT) { browser =>
				browser.goTo("http://localhost:9000")
				browser.pageSource() must equalTo("I'm a mock injector")
			}
		}
    }
}
