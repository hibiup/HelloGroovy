package com.wang.groovy
import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Test

class ClassForGroovyTest {

	@Test
	public void testToString() {
		Song song = new Song()
		song.setArtist("Village People");
		song.setName("Y.M.C.A");
		song.setGenre("Disco");

		Assert.assertEquals("Y.M.C.A, VILLAGE PEOPLE ,DISCO", song.toString())
	}

	/**
	 * 在下面的例子中，当我们调用configChild()方法时，我们并没有指出name属性是属于Child的，但是它的确是在设置Child的name属性。事实上光从该方法的调用中，
	 * 我们根本不知道name是属于哪个对象的，你可能会认为它是属于Parent的。真实情况是，在默认情况下，name的确被认为是属于Parent的，但是我们在configChild()
	 * 方法的定义中做了手脚，使其不再访问Parent中的name（Parent也没有name属性），而是Child的name。在configChild()方法中，我们将该方法接受的闭包的
	 * delegate设置成了child，然后将该闭包的ResolveStrategy设置成了DELEGATE_FIRST。这样，在调用configChild()时，所跟闭包中代码被代理到了
	 * child上，即这些代码实际上是在child上执行的。
	 */
	@Test
	public void testClosure() {
		def parent = new Parent()
		parent.configChild { name = "child name" }

		println parent.child.name
	}
}