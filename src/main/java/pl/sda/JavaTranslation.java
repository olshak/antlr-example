package pl.sda;

import example.Java8Visitor;
import example.Python3Visitor;
import org.antlr.v4.runtime.RuleContext;

import java.io.File;
import java.io.IOException;

public class JavaTranslation {
    public static void main(String[] args) {
        JavaTranslation javaTranslation = new JavaTranslation();
        ClassLoader classLoader = javaTranslation.getClass().getClassLoader();
        File file =  new File(classLoader.getResource("simpleJava.txt").getFile());

        JavaParserFacade javaParserFacade = new JavaParserFacade();
        try {
            RuleContext ctx = javaParserFacade.parse(file);
            Java8Visitor visitor = new JavaToPolishTranslator();
            visitor.visit(ctx);
            //astPrinter.print(ctx);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
