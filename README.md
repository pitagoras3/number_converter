# NumberConverter

NumberConverter implemented for recruitment process in Comarch company.

## What do you need?
The only things which you need to run this project is to have:
- Java 8,
- Maven (working `mvn` command in terminal),
- Working internet connection,
- Free `4567` port.

## How to run it?
Simple as that:
- Download zipped project from Github (or `git clone https://github.com/pitagoras3/number_converter.git`),
- Open root project folder in terminal,
- Run `mvn exec:java`

Or... Just run `main(String[] args)` function placed in `API` class in your IDE.

## How to use it?
You can use your internet browser or Postman to use this REST API.

URL wich evaluates conversion function is available on:
```
http://localhost:4567/convert/METHOD/NUMBER_TO_CONVERT
```
__Methods__:
- `hex`
- `roman`

__Number__ to convert must be positive integer.

## Examples of usage
```
http://localhost:4567/convert/hex/123
```

```
http://localhost:4567/convert/roman/1
```

## Errors
If user will provide wrong data, he will receive error describing what's wrong.

- `404 Not Found` - Something is wrong with URL,
- `No such method error.` - User provided method which is not `hex || roman`,
- `Not a number error.` - User provided not a number into _number_ parameter.
- `Not positive number error.` - User provided neg


## What I've used to make NumberConverter?
For API development I've used Spark library: [Spark documentation.](http://sparkjava.com/documentation#routes)

### Conversion to roman system
Conversion to roman system is made using changed and repaired method from this Gist: [julienhaversano/Converter.java](https://gist.github.com/julienhaversano/9197588).

In this solution I've changed iteration over array from this:

``` java
for (int i : NUMBER_VALUES) { // loop through all the values
            while (num >= NUMBER_VALUES[i]) { // Check if the number is greater than the current value
                roman += NUMBER_LETTERS[i]; // Add the letter to the String
                num -= NUMBER_VALUES[i]; // Subtract the amount from the value
            }
        }
```

Which caused ArrayIndexOutOfBoundsException (because it took value from array, not the index), into this:

``` java
StringBuilder romanNumberBuilder = new StringBuilder();
        for (int i = 0; i < ARABIC_VALUES.length; i++) {
            while (numberToConvert >= ARABIC_VALUES[i]) {
                romanNumberBuilder.append(ROMAN_VALUES[i]);
                numberToConvert -= ARABIC_VALUES[i];
            }
        }
```

As you can see I've also added StringBuilder instead of concatenating String inside loop with `+=` (which is generally a bad practice).

## Unit tests
As part of exercise I wrote unit tests for project. There are two `@Test` classes in project:
- APITest
- ConverterTest

`APITest` tests connection with API by sending different requests - it is __necessary__ to have running API during this test (in other case test methods inside this class will mostly fail).

`ConverterTest` class can work without running API - it tests backend methods which are responsible for conversion to specific numeral systems.