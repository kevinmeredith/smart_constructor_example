package net.web

import net.repo.{Foo, FooRepo}

object HttpServer {

	sealed abstract class HttpResponse
	case object Ok 				    extends HttpResponse
	case object InternalServerError extends HttpResponse

	def getFoo(id: Long, fooRepo: FooRepo): HttpResponse = 
		fooRepo.get(id).fold[HttpResponse](InternalServerError){ foo => Ok }

	// def f(id: Long): Foo = Foo.build(42) // compile-time error: method build in object Foo cannot be accessed in object net.repo.Foo

}