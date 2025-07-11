/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cprl;

import static test.cprl.Utils.testar;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;

/**
 * Teste de corretude, verifica se o Scanner reconhece erros léxicos em
 * símbolos que podem gerar problemas ou símbolos que não devem ser reconhecidos
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TestIncorrect02 {
    
    @Test
    public void testIncorrect02() throws IOException, FileNotFoundException {
        
        testar( "TesteIncorrect02",
                "../examples/ScannerTests/Incorrect/Incorrect_02.cprl",
                "../examples/ScannerTests/Incorrect/Incorrect_02-Results.txt" );
        
    }
    
}
