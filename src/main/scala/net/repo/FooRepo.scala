package net.repo

sealed abstract class Foo(id: Long, name: String)

object Foo {
	private [repo] def build(id: Long, name: String) = new Foo(id, name) {}
}

trait FooRepo {
	def get(id: Long): Option[Foo]
}