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
 * Teste de corretude, verifica se os componentes léxicos são reconhecidos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TestCorrect01 {
    
    @Test
    public void testCorrect01() throws IOException, FileNotFoundException {
        
        testar( "TesteCorrect01",
                "../examples/ScannerTests/Correct/Correct_01.cprl",
                "../examples/ScannerTests/Correct/Correct_01-Results.txt" );
        
    }
    
    
}
