# Converter Project

## Testing

Check out the project and run `sbt test`

## Building

Check out the project and run `sbt assembly`

Now you can run conversions like:

```
% java -jar target/scala-2.13/converter.jar 100.0 Celsius Fahrenheit 212.0
Correct
% java -jar target/scala-2.13/converter.jar 100.0 Celsius Fahrenheit 213.0
Incorrect
% java -jar target/scala-2.13/converter.jar 100.0 Celsius Fahrenheit xyz
Incorrect
% java -jar target/scala-2.13/converter.jar 100.0 Celsius test 212.0
Invalid
```
