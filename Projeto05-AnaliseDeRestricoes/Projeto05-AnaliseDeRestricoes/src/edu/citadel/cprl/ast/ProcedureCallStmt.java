package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.cprl.Token;

import java.util.List;

/**
 * The abstract syntax tree node for a procedure call statement.
 */
public class ProcedureCallStmt extends Statement {

    private Token procId;
    private List<Expression> actualParams;
    private ProcedureDecl procDecl;

    /*
     * Construct a procedure call statement with its name token, the
     * list of actual parameters being passed as part of the call,
     * and a reference to the declaration of the procedure being called.
     */
    public ProcedureCallStmt( Token procId,
            List<Expression> actualParams,
            ProcedureDecl procDecl ) {
        
        this.procId = procId;
        this.actualParams = actualParams;
        this.procDecl = procDecl;
        
    }

    public Token getProcId() {
        return procId;
    }

    public List<Expression> getActualParams() {
        return actualParams;
    }

    public ProcedureDecl getProcDecl() {
        return procDecl;
    }
    
    @Override
    public void checkConstraints() {
        
        // Regra de Tipo: a quantidade de argumentos (actual parameters)
        // precisa ser a mesma da quantidade de parâmetros formais e cada par
        // deve ter o mesmo tipo.
        
        // Regra Variada: se um parâmetro formal é um parâmetro var, então o
        // argumento deve ser um valor nomeado, não uma expressão arbitrária.
        
        // <editor-fold defaultstate="collapsed" desc="Implementação">
                    
        // sua implementação aqui
        try{
            List<ParameterDecl> formParams = procDecl.getFormalParams();
            
            if(actualParams.size() != formParams.size()){
                String errorMsg = "Incorrect number of actual parameters.";
                throw error(procId.getPosition(), errorMsg);
            }
            
            for(Expression exp: actualParams){
                exp.checkConstraints();
            }
            
            for(int i = 0; i < actualParams.size(); i++){
                Expression exp = actualParams.get(i);
                ParameterDecl param = formParams.get(i);
                
                if(!matchTypes(exp.getType(), param.getType())){
                    String errorMsg = "Parameter type mismatch.";
                    throw error(exp.getPosition(), errorMsg);
                }
                
                if (param.isVarParam()) {
                    if (exp instanceof NamedValue) {
                        exp = new Variable((NamedValue) exp);
                        actualParams.set(i, exp);
                    } else {
                        String errorMsg = "Expression for a var parameter must be a variable.";
                        throw error(exp.getPosition(), errorMsg);
                    }
                }
            }
        } catch(ConstraintException e) {
            ErrorHandler.getInstance().reportError(e);
        }

        // </editor-fold>
        
    }

    @Override
    public void emit() throws CodeGenException {
        // ...
    }
    
}
