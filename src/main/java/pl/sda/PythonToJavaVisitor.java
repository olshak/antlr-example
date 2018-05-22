package pl.sda;

import example.Python3BaseVisitor;
import example.Python3Parser;

public class PythonToJavaVisitor extends Python3BaseVisitor {
    @Override
    public Object visitFuncdef(Python3Parser.FuncdefContext ctx) {
        System.out.println("visiting funcdef");
        return visitChildren(ctx);
    }

}
