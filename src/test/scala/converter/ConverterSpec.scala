package converter

import org.scalatest._

class ConverterSpec extends FlatSpec with Matchers {
  "Parsing args" should "throw an Exception for bad args" in {
    val expectedMessage =
      "Please Input: [Numerical Value] [Input Unit] [Target Unit] [Student Response]"

    var thrown = intercept[Exception] {
      Converter.main(Array())
    }
    assert(thrown.getMessage === expectedMessage)

    thrown = intercept[Exception] {
      Converter.main(Array("100.0"))
    }
    assert(thrown.getMessage === expectedMessage)

    thrown = intercept[Exception] {
      Converter.main(Array("100.0", "Celsius"))
    }
    assert(thrown.getMessage === expectedMessage)

    thrown = intercept[Exception] {
      Converter.main(Array("100.0", "Celsius", "Fahrenheit"))
    }
    assert(thrown.getMessage === expectedMessage)
  }

  "Converter.convert" should "return Invalid for invalid args" in {
    var result =
      Converter.convert(Array("Celsius", "Celsius", "Fahrenheit", "212.0"))
    assert(result === "Invalid")

    result = Converter.convert(Array("73.12", "gallons", "Kelvin", "19.4"))
    assert(result === "Invalid")

    result = Converter.convert(Array("136.1", "dog", "Celsius", "45.32"))
    assert(result === "Invalid")

    result = Converter.convert(Array("100.0", "", "Fahrenheit", "213.0"))
    assert(result === "Invalid")
  }

  "Converter.convert" should "return Incorrect" in {
    var result =
      Converter.convert(Array("100.0", "Celsius", "Fahrenheit", "212.66"))
    assert(result === "Incorrect")

    result = Converter.convert(Array("100.0", "Celsius", "Fahrenheit", "213.0"))
    assert(result === "Incorrect")

    result =
      Converter.convert(Array("317.33", "Kelvin", "Fahrenheit", "111.554"))
    assert(result === "Incorrect")

    result = Converter.convert(Array("6.5", "Fahrenheit", "Rankine", "dog"))
    assert(result === "Incorrect")
  }

  "Converter.convert" should "return Correct" in {
    var result =
      Converter.convert(Array("100.0", "Celsius", "Fahrenheit", "212.0"))
    assert(result === "Correct")

    result =
      Converter.convert(Array("100.0", "Celsius", "Fahrenheit", "212.04"))
    assert(result === "Correct")

    result = Converter.convert(Array("84.2", "Fahrenheit", "Rankine", "543.94"))
    assert(result === "Correct")

    result = Converter.convert(Array("25.6", "cups", "liters", "6.1"))
    assert(result === "Correct")

    result = Converter.convert(Array("480.34", "tablespoons", "gallons", "1.9"))
    assert(result === "Correct")

    result =
      Converter.convert(Array("50000.0", "tablespoons", "cubic-feet", "26.109"))
    assert(result === "Correct")
  }
}
