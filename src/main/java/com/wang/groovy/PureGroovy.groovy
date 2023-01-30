package com.wang.groovy
/**
 * Example 1
 */
def message = "Groovy only!"
println message

// Will print out "java.lang.String". Groovy determinate the type by itself
println message.class

// Everything is "Object", the num is not a int, but a Integer
def num = 12
println num.class


println "\n** Example 1 ******************************************************"
/**
 * Example 1
 * 
 * @param val
 * @return
 */
// Call a function, no type definition for function also
def repeat(val){
	for(i in 0..<val) {  // 0..<val 表示一个右不包含的 groovy.lang.IntRange：[0,1,2,...12) 不含 12
		println i+1
	}
}
repeat(12)

println "\n** Example 2 ******************************************************"
/**
 * Example 2
 * 
 * List
 */
def range = 0..4
println range.class  // groovy.lang.IntRange
assert range instanceof List  // groovy.lang.IntRange 是 List interface 的子类

// All assembles are instance of Collection and List
def coll = ["Groovy", "Java", "Ruby", 1]
println coll
assert  coll instanceof Collection   // 也是 Collection 的子类
assert coll instanceof ArrayList

// Add elements to list
coll.add("Python")
coll << "Smalltalk"
// Trick! We add something over 6!
coll[7] = "Perl"  // 是合法的，List 自动将第 6 个元素设为 null
println coll
println coll[6]   // null ！

// Operation for a list
def numbers = [1, 2, 3, 4]
assert numbers + 5 == [1, 2, 3, 4, 5]
assert numbers - [2, 3]== [1, 4]

println numbers
println numbers.join(",")

// "*" means everything in the list
assert ["JAVA", "GROOVY"]== ["Java", "Groovy"]*.toUpperCase()


println "\n** Example 3 ******************************************************"
/**
 * Example 3
 *
 * Map
 */
// Map value's type not have to be same all the way. And the name will be converted to String, no meter has it been named.
java.util.LinkedHashMap<String, Serializable> hash = [name:"Andy", "VPN-#":45]
println hash
assert hash.getClass() == java.util.LinkedHashMap

hash.put("id", 23)
assert hash.get("name") == "Andy"

// You can add new element to map
hash.dob = "01/29/76"
println hash
assert hash.dob == "01/29/76"

// Change and add
assert hash["name"] == "Andy"
hash["name"] = "And"
assert hash.name == "And"   // 可以直接引用 key name。

hash["gender"] = "male"
assert hash["gender"] == "male"
assert hash.gender == "male"


println "\n** Example 4 ******************************************************"
/**
 * Example 4
 *
 * 闭包！！！！
 * 
 */
def acoll = ["Groovy", "Java", "Ruby"]
// 支持 lambda 函数
acoll.each { println it }
// The above "it" is the default value name for the parameter passing to ".each". can be override by something else, for example "value"
acoll.each{ value -> println value }

// 闭包还允许使用多个参数 — 在这个示例中，下面的代码包含两个参数（key 和 value）。
hash = [name:"Andy", "VPN-#":45]
hash.each{ key, value ->
	println "${key} : ${value}"
}

// 闭包处理 String 的例子，注意的是  String 都可以看做是list
"ITERATION".each{ print it.toLowerCase() }
println ""

// 定义一个 lambda 函数：入参是 word以
def excite = { word -> return "${word}!!" }  // interpolated string 语法
println excite("Hello Groovy")
println excite.call("Call Groovy")

