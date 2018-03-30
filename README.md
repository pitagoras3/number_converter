# NumberConverter

NumberConverter implemented for recruitment process in Comarch company.

## How to run?
Simply - download zip from github (or `git clone https://github.com/pitagoras3/number_converter.git`) and open project in your IDE, then import maven dependencies and run main method in API class.

## Spark
For API development I've used Spark library: [Spark documentation.](http://sparkjava.com/documentation#routes)

## Conversion to roman system
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