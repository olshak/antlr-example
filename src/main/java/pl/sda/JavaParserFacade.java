package pl.sda;

import example.Java8Lexer;
import example.Java8Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class JavaParserFacade {
    private static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }

    public Java8Parser.CompilationUnitContext parse(File file) throws IOException {

        String code = readFile(file, Charset.forName("UTF-8"));
        Java8Lexer lexer = new Java8Lexer(new ANTLRInputStream(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokens);
        return parser.compilationUnit();
    }
}
