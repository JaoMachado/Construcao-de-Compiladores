package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.cprl.Symbol;
import edu.citadel.cprl.Token;
import edu.citadel.cprl.Type;

/**
 * The abstract syntax tree node for a not expression. A not expression is a
 * unary expression of the form "not expr". A simple example would be "not
 * isEmpty()".
 */
public class NotExpr extends UnaryExpr {

    /**
     * Construct a not expression with the specified operator ("not") and
     * operand.
     */
    public NotExpr( Token operator, Expression operand ) {
        
        super( operator, operand );
        setType( Type.Boolean );
        
        assert operator.getSymbol() == Symbol.notRW :
                "Operator is not the reserved word \"not\".";
        
    }
    
    @Override
    public void checkConstraints() {
        
        // Regra de Tipo: o operando tem que ser do tipo Boolean.
        
        // Regra Variada: o resultado tem que ser do tipo Boolean.
        
        // <editor-fold defaultstate="collapsed" desc="Implementação">
                    
        // sua implementação aqui
        try{
            Expression operando = getOperand();
            operando.checkConstraints();
            
            if(operando.getType() != Type.Boolean){
                String errorMsg = "Expression following \"not\" operator is not" + " a Boolean expression.";
                throw error(operando.getPosition(), errorMsg);
            }
        } catch(ConstraintException e){
            ErrorHandler.getInstance().reportError(e);
        }

        // </editor-fold>

    }

    @Override
    public void emit() throws CodeGenException {
        // ...
    }
    
}
