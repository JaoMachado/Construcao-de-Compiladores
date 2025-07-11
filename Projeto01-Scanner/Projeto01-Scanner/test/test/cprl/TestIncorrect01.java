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
 * literais de Strings e Chars
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TestIncorrect01 {
    
    @Test
    public void testIncorrect01() throws IOException, FileNotFoundException {
        
        testar( "TesteIncorrect01",
                "../examples/ScannerTests/Incorrect/Incorrect_01.cprl",
                "../examples/ScannerTests/Incorrect/Incorrect_01-Results.txt" );
        
    }
    
    
}
