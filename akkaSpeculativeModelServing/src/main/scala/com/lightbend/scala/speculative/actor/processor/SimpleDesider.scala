package com.lightbend.scala.speculative.actor.processor

import com.lightbend.scala.modelServer.model.ServingResult
import com.lightbend.scala.modelServer.model.speculative.{DeciderTrait, ServingResponse}

object SimpleDesider extends DeciderTrait {

  // The simplest decider returning the first result
  override def decideResult(results: List[ServingResponse]): Any = {

    var result = ServingResult.noModel
    results.foreach(res => res.result.asInstanceOf[ServingResult] match {
      case r if(r.processed) => result = r
      case _ =>
    })
    result
  }
}
