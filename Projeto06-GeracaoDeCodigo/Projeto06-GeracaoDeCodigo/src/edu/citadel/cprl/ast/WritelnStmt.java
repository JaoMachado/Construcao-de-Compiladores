package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.cprl.Type;
import java.util.ArrayList;

import java.util.List;

/**
 * The abstract syntax tree node for a writeln statement.
 */
public class WritelnStmt extends OutputStmt {

    /**
     * Construct a writeln statement with the list of expressions.
     */
    public WritelnStmt(List<Expression> expressions) {
        super(expressions);
    }

    // inherited checkConstraints() method is sufficient
    @Override
    public void emit() throws CodeGenException {

        // <editor-fold defaultstate="collapsed" desc="Implementação">
        
        // sua implementação aqui
        
        List<Expression> expressao = this.getExpressions();

        for (Expression n : expressao) {
            if (n != null) {
                n.emit();
                Type var = n.getType();

                if (var == Type.Integer) {
                    emit("PUTINT");
                } else if (var == Type.Boolean) {
                    emit("PUTBYTE");
                } else if (var == Type.Char) {
                    emit("PUTCH");
                } else if (var == Type.String) {
                    emit("PUTSTR");
                }else{
                    throw new CodeGenException(n.getExprPosition(),"Invalid type.");
                }
            }
        }
        emit("PUTEOL");
        
        // </editor-fold>
        
    }

}
