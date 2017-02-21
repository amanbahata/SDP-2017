package films

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int){

  def name = s"$firstName $lastName"
}

class Film(val name: String, val yearOfRelease: Int, val imbdRating: Double, val director: Director){

  def directorsAge : Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) : Boolean = { false }

  def copy(name: String): Film = Film(name, yearOfRelease, imbdRating, director)
}

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int): Director = new Director(firstName, lastName, yearOfBirth)

  def older(director1: Director, director2: Director): Director = {
    if (director1.yearOfBirth < director2.yearOfBirth)
      director1
    else
      director2
  }
}

object Film {
  def apply(name: String, yearOfRelease: Int, imbdRating: Double, director: Director): Film = new Film(name, yearOfRelease, imbdRating, director)
  def highestRating(film1: Film, film2: Film): Film = {
    if (film1.imbdRating > film2.imbdRating)
      film1
    else
      film2
  }

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director = {
    if (film1.directorsAge > film2.directorsAge)
      film1.director
    else
      film2.director
  }
}



object FilmTest extends App {
  val eastwood = Director("Clint", "Eastwood", 1930)
  val mcTiernan = Director("John", "McTiernan", 1951)
  val nolan = Director("Christopher", "Nolan", 1970)
  val someGuy = Director("Just", "Some Guy", 1990)

  val memento = Film("Memento", 2000, 8.5, nolan)
  val darkKnight = Film("Dark Knight", 2008, 9.0, nolan)
  val inception = Film("Inception", 2010, 8.8, nolan)

  val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = Film("Invictus", 2009, 7.4, eastwood)

  val predator = Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  println(eastwood.yearOfBirth) // should be 1930
  println(dieHard.director.name) // should be "John McTiernan"
  println(invictus.isDirectedBy(nolan)) // should be false

}