/*
***
 REINALDO TOLEDO LEGUIZAMÓN       *
 SANTIAGO HERNÁNDEZ CHAPARRO      *
 LENGUAJES DE PROGRAMACIÓN        *
 UNIVERSIDAD NACIONAL DE COLOMBIA *
 TRADUCTOR: CORAL -> PYTHON       *
 2022-2                           *
                                  *
***
*/
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Main {


    public static void main(String[] args) throws Exception {
        try{
            // crear un analizador léxico que se alimenta a partir de la entrada (archivo  o consola)
            MiLenguajeLexer lexer;
            if (args.length>0)
                lexer = new MiLenguajeLexer(CharStreams.fromFileName(args[0]));
            else
                lexer = new MiLenguajeLexer(CharStreams.fromStream(System.in));
            // Identificar al analizador léxico como fuente de tokens para el sintactico
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // Crear el objeto correspondiente al analizador sintáctico que se alimenta a partir del buffer de tokens
            MiLenguajeParser parser = new MiLenguajeParser(tokens);
            ParseTree tree = parser.start_grammar(); // Iniciar el analisis sintáctico en la regla inicial: r

            System.out.println("\n--------------------------\nProyecto final de Lenguajes de programación\nProgravisión\n-Reinaldo Toledo\n-Santiago Hernández\n-Jorge Rodríguez");
            System.out.println("\n--------------------------\nTraducción a Pseudocodigo\n");

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new ShortToUnicodeString(), tree);


            System.out.println("\n--------------------------\nOutput:\n");
            MyVisitor loader = new MyVisitor();
            loader.visit(tree);
             // print a \n after translation
            //System.out.println(tree.toStringTree(parser)); // imprime el arbol al estilo LISP
        } catch (Exception e){
            System.err.println("Error (Test): " + e);
        }
    }
}
