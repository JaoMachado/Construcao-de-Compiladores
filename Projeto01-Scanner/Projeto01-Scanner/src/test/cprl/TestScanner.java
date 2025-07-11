package test.cprl;

import edu.citadel.compiler.Source;
import edu.citadel.cprl.Scanner;
import edu.citadel.cprl.Symbol;
import edu.citadel.cprl.Token;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Modificação da classe de testes original, facilitando a implementação do
 * Scanner por parte dos alunos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TestScanner {

    public static void main( String[] args ) {
        
        // cada linha abaixo executa o Scanner para um arquivo de código fonte
        // você pode descomentar uma linha de cada vez e ir testando, comparando
        // o que é gerado com os arquivos de resultados
        
        // quando achar que está tudo ok, execute o teste (no pacote de testes)
        // correspondente para a verificação final
        
        executar( "../examples/ScannerTests/Correct/Correct_01.cprl" );
        //executar( "../examples/ScannerTests/Correct/Correct_02.cprl" );
        //executar( "../examples/ScannerTests/Incorrect/Incorrect_01.cprl" );
        //executar( "../examples/ScannerTests/Incorrect/Incorrect_02.cprl" );
        
    }
    
    public static void executar( String... args ) {
        
        try {
            
            // verificação de argumentos
            if ( args.length != 1 ) {
                printUsageAndExit();
            }

            System.out.println( "initializing..." );
            System.out.println();

            System.out.println( "starting main loop..." );
            System.out.println();

            String fileName = args[0];
            FileReader reader = new FileReader( fileName, StandardCharsets.UTF_8 );
            Source source = new Source( reader );
            Scanner scanner = new Scanner( source );
            Token token;

            do {
                token = scanner.getToken();
                printToken( token );
                scanner.advance();
            } while ( token.getSymbol() != Symbol.EOF );

            System.out.println();
            System.out.println( "...done" );
            
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        
    }

    public static void printToken( Token token ) {
        
        PrintStream out = new PrintStream( System.out, true, StandardCharsets.UTF_8 );
        out.printf( "line: %2d   char: %2d   token: ",
                token.getPosition().getLineNumber(),
                token.getPosition().getCharNumber() );

        Symbol symbol = token.getSymbol();
        
        if ( symbol.isReservedWord() ) {
            out.print( "Reserved Word -> " );
        } else if ( symbol == Symbol.identifier || symbol == Symbol.intLiteral
                || symbol == Symbol.stringLiteral || symbol == Symbol.charLiteral ) {
            out.print( token.getSymbol().toString() + " -> " );
        }

        out.println( token.getText() );
        
    }

    private static void printUsageAndExit() {
        System.out.println( "Usage: java test.cprl.TestScanner <test file>" );
        System.out.println();
        System.exit( 0 );
    }
    
}
