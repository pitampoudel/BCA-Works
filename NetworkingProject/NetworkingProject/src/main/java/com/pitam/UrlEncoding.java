package com.pitam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class UrlEncoding {

    public static void main(String[] args) {
        Map<String, String> samples = new LinkedHashMap<>();

        // Common URL and text cases
        samples.put("URL with query", "https://www.google.com/search?q=java+url+encoding");
        samples.put("Spaces", "this text has spaces");
        samples.put("Asterisks", "this*text*has*asterisks");
        samples.put("Percents", "this%text%has%percents");
        samples.put("Plus signs", "this+text+has+plus+signs");
        samples.put("Slashes", "this/text/has/slashes");
        samples.put("Question marks", "this?text?has?question?marks");
        samples.put("Hash signs", "this#text#has#hash#signs");
        samples.put("Ampersands", "this&text&has&ampersands");
        samples.put("Equals signs", "this=text=has=equals=signs");
        samples.put("Tilde", "this~text~has~tildes");
        samples.put("Backticks", "this`text`has`backticks`");
        samples.put("Apostrophes", "this'text'has'apostrophes'");
        samples.put("Double quotes", "this\"text\"has\"double-quotes\"");
        samples.put("Parentheses", "this(text)has(parentheses)");
        samples.put("Curly braces", "this{text}has{curly}braces");
        samples.put("Square brackets", "this[text]has[square]brackets");
        samples.put("Colon", "this:text:has:colons");
        samples.put("Semicolon", "this;text;has;semicolons");
        samples.put("Comma", "this,text,has,commas");
        samples.put("Pipe", "this|text|has|pipes");
        samples.put("Caret", "this^text^has^carets");
        samples.put("At sign", "this@text@has@ats");
        samples.put("Dollar sign", "this$text$has$dollars");
        samples.put("Line breaks (\\n)", "this\ntext\nhas\nline breaks\n");
        samples.put("Carriage returns (\\r)", "this\rtext\rhas\rreturns\r");
        samples.put("Tabs (\\t)", "this\ttext\thas\ttabs\t");
        samples.put("Backspace (\\b)", "this\btext\bhas\bbackspaces\b");
        samples.put("Form feed (\\f)", "this\ftext\fhas\fformfeeds\f");

        // Print all with encoding
        samples.forEach((desc, text) -> {
            String encoded = URLEncoder.encode(text, StandardCharsets.UTF_8);
            System.out.println("----- " + desc + " -----");
            System.out.println("Original: " + text);
            System.out.println("Encoded : " + encoded);
            System.out.println();
        });
    }
}
