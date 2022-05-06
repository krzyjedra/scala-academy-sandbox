object DockerScoptApp extends App {
  case class Config(lines: Int = 2, words: String = "DEFAULT")

  import scopt.OParser

  val myBuilder = OParser.builder[Config]
  val myParser = {
    import myBuilder._
    OParser.sequence(
      programName("Krzysiek"),
      head("Title", "1.0.0-alpha"),
      help("help").text("R u looking for help?"),
      opt[Int]('l', "lines")
        .action((x, cfg) => cfg.copy(lines = x))
        .text("My name property")
    )
  }

  val config = OParser.parse(
    myParser,
    args,
    Config(lines = 5, words = "dasd")).getOrElse {
    println("Not enough or incorrect command-line arguments. Exiting...")
    sys.exit(-1)
  }

  println(s"${config.lines} ---> ${config.words}")
}