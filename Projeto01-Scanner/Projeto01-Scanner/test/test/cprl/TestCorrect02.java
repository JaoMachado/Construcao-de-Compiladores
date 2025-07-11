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
 * Teste de corretude, verifica se alguns literais de String e Char são
 * reconhecidos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TestCorrect02 {
    
    @Test
    public void testCorrect02() throws IOException, FileNotFoundException {
        
        testar( "TesteCorrect02",
                "../examples/ScannerTests/Correct/Correct_02.cprl",
                "../examples/ScannerTests/Correct/Correct_02-Results.txt" );
        
    }
    
    
}
