package com.lab05;

import junit.framework.TestCase;

public class AppTest extends TestCase {

    public void testTextProcessing() {
        String text = "Java is a high-level, object-oriented programming language developed by Sun Microsystems (now owned by Oracle) in 1995. It is known for its 'write once, run anywhere' (WORA) principle, meaning that Java code can run on any device that has a Java Virtual Machine (JVM) installed, regardless of the underlying architecture. Java is widely used for developing various types of applications, such as enterprise software, mobile applications, and large-scale distributed systems. It has a strong community and ecosystem, with a large number of libraries, frameworks, and tools available for development.";

        String expectedResult = "Java is  high-level, object-oriented programming language developed by Sun Microsystems (now owned by Oracle)  1995. It is known for its 'write once, run anywhere' (WORA) principle, meaning that Java code can run  any device that has  Java Virtual Machine (JVM) installed, regardless of  underlying architecture. Java is widely used for developing various types of applications, such as enterprise software, mobile applications, and large-scale distributed systems. It has  strong community and ecosystem, with  large number of libraries, frameworks, and tools available for development.";
        String result = App.processText(text);

        assertEquals(expectedResult, result);
    }
}

