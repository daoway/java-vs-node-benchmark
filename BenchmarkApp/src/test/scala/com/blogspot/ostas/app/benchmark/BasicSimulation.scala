package com.blogspot.ostas.app.benchmark

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://127.0.0.1:8080") // Here is the root for all relative URLs
    .acceptHeader("text/html")
    .disableFollowRedirect
    .disableCaching

  val scn = scenario("Get hello from World")
    .repeat(1000) {
    exec(
      http("request_1")
        .get("/")
    )
  }

  setUp(scn.inject(atOnceUsers(350)).protocols(httpConf))
    .assertions(global.successfulRequests.percent.is(100))
}
