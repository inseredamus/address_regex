# address_regex

Input: string of address in resources : addressesInput.properties
Output: string of street and string of street-number as JSON object : in test  AddressOutputTest.jsonFormatedAddressTest

Used technologies : Java, Junit, Intellij, org.json, maven, regular expressions

You can run the test in a terminal with : mvn test or use the IDE and run the test directly from the class : AddressOutputTest or the method : jsonFormatedAddressTest

I don't imagine that the code will work for all the addresses they exist in the world, but it works for the addresses of the exercices. If you want to try other addresses, you can add some of them into addressesInput.properties. Don't forget to adjust the for loop in the test.

happy testing!
