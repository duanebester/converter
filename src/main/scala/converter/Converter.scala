package converter

import scala.math.BigDecimal
object Converter extends App {

  def rounded(in: Double): Double = {
    BigDecimal(in).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def convert(args: Array[String]): String = {
    var result: String = "Invalid"

    try {
      val inputNumber = args(0).toDouble
      val inputUnit = args(1)
      val targetUnit = args(2)
      var studentResponse = 0.0

      try {
        studentResponse = args(3).toDouble
      } catch {
        case _: Throwable => return "Incorrect"
      }

      val inputTemperatureOption = Temperature.valueOf(inputUnit)
      val targetTemperatureOption = Temperature.valueOf(targetUnit)

      val inputVolumeOption = Volume.valueOf(inputUnit)
      val targetVolumeOption = Volume.valueOf(targetUnit)

      if (inputTemperatureOption.isDefined && targetTemperatureOption.isDefined) {
        val inputTemperature = inputTemperatureOption.get
        val outputTemperature = targetTemperatureOption.get

        val answer =
          outputTemperature.fromCelsius(inputTemperature.toCelsius(inputNumber))

        result =
          if (rounded(answer) == rounded(studentResponse))
            "Correct"
          else
            "Incorrect"

      } else if (inputVolumeOption.isDefined && targetVolumeOption.isDefined) {
        val inputVolume = inputVolumeOption.get
        val outputVolume = targetVolumeOption.get

        val answer = outputVolume.fromLiters(inputVolume.toLiters(inputNumber))

        result =
          if (rounded(answer) == rounded(studentResponse))
            "Correct"
          else
            "Incorrect"

      } else {
        result = "Invalid"
      }
    } catch {
      case _: Throwable => {
        result = "Invalid"
      }
    }

    result
  }

  if (args.length != 4) {
    throw new Exception(
      "Please Input: [Numerical Value] [Input Unit] [Target Unit] [Student Response]"
    )
  }

  println(convert(args))
}
