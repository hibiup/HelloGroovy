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
	for(i in 0..<val){
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
println range.class
assert range instanceof List

// All assembles are instance of Collection and List
def coll = ["Groovy", "Java", "Ruby", 1]
println coll
assert  coll instanceof Collection
assert coll instanceof ArrayList

// Add elements to list
coll.add("Python")
coll << "Smalltalk"
// Trick! We add something over 6!
coll[7] = "Perl"
println coll
println coll[6]

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
def hash = [name:"Andy", "VPN-#":45]
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
assert hash.name == "And"

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
// 闭包是一段由 {} 包裹起来的匿名函数. 因为闭包是一个代码块，所以能够作为参数进行传递
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

// 以下这个闭包将一个参数 “Hello Groovy” 做为 excite的参数传给 word，而word执行一段代码再将这个参数加上两个"!"返回给 excite
def excite = { word -> return "${word}!!" }
println excite("Hello Groovy")
println excite.call("Call Groovy")

