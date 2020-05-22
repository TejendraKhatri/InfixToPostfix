
import java.io.* ;
public class Parser {
    static int lookahead ;

    public Parser() throws IOException {
        lookahead = System.in.read() ;
    }

    void expr() throws IOException {

        factor() ;

        while(true) {

            if (lookahead == '+') {

                match('+') ;
                factor() ;
                System.out.print('+') ;

            } else if (lookahead == '-') {

                match('-') ;
                factor() ;
                System.out.print('-') ;

            } else {

                return ;
            }
        }
    }

    void factor() throws IOException {

        term() ;

        while(true) {

            if (lookahead == '*') {

                match('*') ;
                term() ;
                System.out.print('*') ;

            } else if (lookahead == '/') {

                match('/') ;
                term() ;
                System.out.print('/') ;

            } else if (lookahead == '%') {

                match('%') ;
                term() ;
                System.out.print('%') ;

            } else {

                return ;
            }
        }
    }

    void term() throws IOException {

        if (Character.isDigit((char)lookahead)) {

            System.out.print((char)lookahead) ;
            match(lookahead);
        }

        else if (Character.isLetter((char)lookahead)) {

            System.out.print((char)lookahead) ;
            match(lookahead);
        }
        

    }

    void match(int t) throws IOException {

        if (lookahead == t)
            lookahead = System.in.read() ;
        else
            throw new Error("syntax error") ;
    }
}
