package pl.sda;

import example.Python3Visitor;
import org.antlr.v4.runtime.RuleContext;

import java.io.File;
import java.io.IOException;

public class Python {
    public static void main(String[] args) {
        Python python = new Python();
        ClassLoader classLoader = python.getClass().getClassLoader();
        File file =  new File(classLoader.getResource("simplePython.txt").getFile());

        try {
            PythonParserFacade pythonParserFacade = new PythonParserFacade();
            RuleContext ctx = pythonParserFacade.parse(file);
            Python3Visitor visitor = new PythonToJavaVisitor();
            visitor.visit(ctx);
            //AstPrinter astPrinter = new AstPrinter();
            //astPrinter.print(ctx);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
