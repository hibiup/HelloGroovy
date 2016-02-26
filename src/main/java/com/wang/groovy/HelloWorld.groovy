package com.wang.groovy

/**
 * 除非另行指定，Groovy 的所有内容都�? public
 * 
 * @author wangji
 *
 */
class HelloWorld {
	/**
	 * 无需为参数声明类型，也无需 public. 
	 * 
	 * @param args
	 */
	static void main(args) {
		// 1)
		// 无需类型
		def greeting = "Hello Groovy!"
		// 结尾无需分号";"
		println greeting

		// 2)
		// 与 上面完全等价
		String greetingType = "Hello Java!";
		System.out.println(greetingType);
	}
}

