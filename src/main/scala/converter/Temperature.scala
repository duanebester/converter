package converter

trait Temperature {
  def toCelsius(in: Double): Double
  def fromCelsius(in: Double): Double
}

object Temperature {
  def valueOf(string: String) = string match {
    case "Kelvin"     => Some(Kelvin)
    case "Celsius"    => Some(Celsius)
    case "Rankine"    => Some(Rankine)
    case "Fahrenheit" => Some(Fahrenheit)
    case _            => None
  }
}

case object Kelvin extends Temperature {
  def toCelsius(temp: Double) = {
    temp - 273.15
  }
  def fromCelsius(in: Double) = {
    in + 273.15
  }
}
case object Celsius extends Temperature {
  def toCelsius(temp: Double) = {
    temp
  }
  def fromCelsius(in: Double) = {
    in
  }
}
case object Rankine extends Temperature {
  def toCelsius(temp: Double) = {
    (temp - 491.67) * (5.0 / 9.0)
  }
  def fromCelsius(in: Double) = {
    (in * (9.0 / 5.0)) + 491.67
  }
}
case object Fahrenheit extends Temperature {
  def toCelsius(temp: Double) = {
    (temp - 32.0) * (5.0 / 9.0)
  }
  def fromCelsius(in: Double) = {
    (in * (9.0 / 5.0)) + 32.0
  }
}
