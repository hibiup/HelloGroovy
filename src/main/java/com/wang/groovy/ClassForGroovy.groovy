package com.wang.groovy

class Song {
	def name
	def artist
	def genre

	def getGenre(){
		genre?.toUpperCase()
	}

	String toString(){
		// Groovy 默认给方法的最后一行加上 return
		"${name}, " + artist?.toUpperCase() + " ,${getGenre()}"
	}
}

class ClassForGroovy {
	static void main(args) {
		// Groovy compiler generates construct method automatically. 用于类中定义的任何属性
		def song = new Song(name:"Thriller", artist:"Michael Jackson", genre:"Disco")
		println song

		// artist.toUpperCase will be ignored
		song = new Song(name:"Thriller", genre:"Disco")
		println song

		// getGenre() method works to genre property
		println song.getGenre()
		assert song.genre == "DISCO"

		// Question mark(?) check song.artist to prevent null point exception.
		println song.artist?.toLowerCase()  // (song.artist == null)? null : song.artist.toLowerCase()
	}
}

class Parent {
	Song child = new Song();

	void configChild(Closure c) {
		c.delegate = child
		c.setResolveStrategy Closure.DELEGATE_FIRST
		c()
	}
}