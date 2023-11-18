package com.lab05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static String processText(String text) {
        String pattern = "\\b(a|the|or|are|on|in|out)\\b";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        return m.replaceAll("");
    }

    public static void main(String[] args) {
        String text = "Java is a high-level, object-oriented programming language developed by Sun Microsystems (now owned by Oracle) in 1995. It is known for its 'write once, run anywhere' (WORA) principle, meaning that Java code can run on any device that has a Java Virtual Machine (JVM) installed, regardless of the underlying architecture. Java is widely used for developing various types of applications, such as enterprise software, mobile applications, and large-scale distributed systems. It has a strong community and ecosystem, with a large number of libraries, frameworks, and tools available for development.";

        String result = processText(text);
        System.out.println("Resulting text: " + result);
    }
}
