/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cprl;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

/**
 * Métodos utilitários para os testes.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Utils {
    
    /*
     * Executa um teste comparando a saída do escaneamento de um arquivo de
     * código fonte e um arquivo de resultado.
     */
    public static void testar( 
            String titulo, 
            String caminhoFonte, 
            String caminhoResultado ) throws FileNotFoundException, IOException {
        
        System.out.println( titulo );
        String expResult = carregar( caminhoResultado );
        String result = gerar( caminhoFonte );
        
        result = result.replace( "\r", "" );
        expResult = expResult.replace( "\r", "" );
        
        System.out.println( "\n\n*********** Resultado:" );
        System.out.println( result );
        
        System.out.println( "\n\n*********** Esperado:" );
        System.out.println( expResult );
        
        assertEquals( expResult, result );
        
    }
    
    /*
     * Carrega um arquivo de solução e retorna a String com o conteúdo do mesmo.
     */
    private static String carregar( String path ) throws FileNotFoundException {
        
        StringBuilder expResultBuilder = new StringBuilder();
        try ( Scanner s = new Scanner( new File( path ) ) ) {
            while ( s.hasNextLine() ) {
                expResultBuilder.append( s.nextLine() ).append( "\n" );
            }
            return expResultBuilder.toString().trim();
        }
        
    }
    
    /*
     * Executa o Scanner em um arquivo de código fonte e retorna toda a saída
     * gerada pelo mesmo na saída padrão em uma String.
     */
    private static String gerar( String path ) throws IOException {
        
        try ( 
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream( baos, true, StandardCharsets.UTF_8 ) ) {
            
            PrintStream ant = System.out;
            System.setOut( ps );
            
            TestScanner.executar( path );
            System.out.flush();
            
            System.setOut( ant );
            
            return baos.toString().trim();
            
        }
        
    }
    
}
