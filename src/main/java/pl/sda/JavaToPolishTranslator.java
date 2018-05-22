package pl.sda;

import example.*;

public class JavaToPolishTranslator extends Java8BaseVisitor {
    @Override
    public Object visitClassModifier(Java8Parser.ClassModifierContext ctx) {
        System.out.println(ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitClassType(Java8Parser.ClassTypeContext ctx) {
        System.out.println(ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        //System.out.println(ctx.getText());
        System.out.println(ctx.normalClassDeclaration().Identifier().getSymbol().getText());
        return visitChildren(ctx);
    }

}
