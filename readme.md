## Analysis of the Junit5 library: Assertions, Assumptions and Tags

[Assertions](https://howtodoinjava.com/junit-5/junit-5-assertions-examples/)

Grouped assertions:
Report all the failing assertions, not just the first one,
which would leave you guessing about the later once.

```java
class AssertionsDemo {
    private Person person = new Person("Jef", "Claes");
    @Test
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }
}
```

Timeout assertions:
Fails test when time limit is reached.
```java
class AssertionsDemo {
    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }
}
```

[Assumptions](https://howtodoinjava.com/junit-5/junit-5-assumptions-examples/)
 
Ignore the test based on a run time condition. 
Shows in intellij like an ignored test
 ```java
 class AssumptionsDemo {
     @Test
     void testOnDev()
     {
         System.setProperty("ENV", "DEV");
         Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
         //remainder of test will proceed
     }
 }
 ```

[Tags](https://howtodoinjava.com/junit-5/junit-5-tag-annotation-example/)
 
```java
 @Tag("development")
 public class ClassATest
 {
     @Test
     @Tag("userManagement")
     void testCaseA(TestInfo testInfo) {
     }
 }
 
 //@IncludeTags example
 
@RunWith(JUnitPlatform.class)
@SelectPackages("com.howtodoinjava.junit5.examples")
@IncludeTags("production")
public class JUnit5Example
{
}
```

Geen project voor Selenium / niet snel test hebben
