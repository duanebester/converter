package converter

trait Volume {
  def toLiters(in: Double): Double
  def fromLiters(in: Double): Double
}

object Volume {
  def valueOf(string: String) = string match {
    case "liters"       => Some(Liters)
    case "gallons"      => Some(Gallons)
    case "tablespoons"  => Some(Tablespoons)
    case "cups"         => Some(Cups)
    case "cubic-inches" => Some(CubicInches)
    case "cubic-feet"   => Some(CubicFeet)
    case _              => None
  }
}

case object Liters extends Volume {
  def toLiters(vol: Double) = {
    vol
  }
  def fromLiters(vol: Double) = {
    vol
  }
}
case object Cups extends Volume {
  def toLiters(vol: Double) = {
    vol / 4.227
  }
  def fromLiters(vol: Double) = {
    vol * 4.227
  }
}
case object Tablespoons extends Volume {
  def toLiters(vol: Double) = {
    vol * 0.0147868
  }
  def fromLiters(vol: Double) = {
    vol / 0.0147868
  }
}
case object CubicInches extends Volume {
  def toLiters(vol: Double) = {
    vol / 61.024
  }
  def fromLiters(vol: Double) = {
    vol * 61.024
  }
}
case object CubicFeet extends Volume {
  def toLiters(vol: Double) = {
    vol * 28.317
  }
  def fromLiters(vol: Double) = {
    vol / 28.317
  }
}
case object Gallons extends Volume {
  def toLiters(vol: Double) = {
    vol * 3.785
  }
  def fromLiters(vol: Double) = {
    vol / 3.785
  }
}
