package collection

object FlatMap extends App {
  // each musician has name and list of instruments
  case class Musician( name: String, instruments: List[String])

  val band: List[Musician] = List[Musician](
    Musician(
      name = "Geddy Lee",
      instruments = List(
        "vocals", "bass guitar", "Oberheim polyphonic",
        "Minimoog", "Moog Taurus pedals"
      )
    ),
    Musician(
      name = "Alex Lifeson",
      instruments = List(
        "electric and acoustic guitars", "classical guitar",
        "guitar synthesizer", "Moog Taurus pedals"
      )
    ),
    Musician(
      name = "Neil Peart",
      instruments = List(
        "drums", "orchestra bells", "bell tree", "timpani",
        "gong", "cowbells", "temple blocks",   "wind chimes", "crotales"
      )
    )
  )
  // which are the instruments you need to arrange if you invite band.

  val instruments: List[String] = band.flatMap(_.instruments).distinct
  println(instruments)
}
