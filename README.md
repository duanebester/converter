# Converter Project

Project that converts various temperatures and volumes.

## Testing

Check out the project and run `sbt test`.

CI tests run on pushes to master and every pull request.

## Building

Check out the project and run `sbt assembly`

Now you can run conversion checks:

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

## Cutting a release

To release a new version, we need to create a tag and push it.

> Tag must have v\* in the tag: v0.0.1

```
git tag <tagname>
git push origin <tag>
```

For Example:

```
git tag v0.0.1
git push origin v0.0.1
```

These will be available in the [Releases](https://github.com/duanebester/converter/releases) section.

## Using the latest release

You can go to the [Releases](https://github.com/duanebester/converter/releases) section and download the latest `converter.zip`!

Downloading and unzipping the above, you can grade the `[Target Number]` below:

```
java -jar converter.jar [Input Number] [Input Unit] [Target Unit] [Target Number]
```

#### Examples

```
java -jar converter.jar 100.0 Celsius Fahrenheit 212.0
# Correct
```

```
java -jar converter.jar 100.0 Celsius Fahrenheit 200.0
# Incorrect
```
