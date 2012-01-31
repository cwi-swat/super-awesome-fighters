// Output created by jacc on Tue Jan 31 16:28:35 CET 2012

package jsaf.syntax;

import jsaf.ast.*;
import jsaf.ast.util.*;
import jsaf.ast.cond.*;
import jsaf.ast.fighter.Behavior;
import jsaf.ast.fighter.Def;
import jsaf.ast.fighter.Fighter;
import jsaf.ast.fighter.Strength;
import jsaf.ast.action.*;

class Parser implements Tokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private ISemantic[] yysv;
    private ISemantic yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new ISemantic[yyss];
        yytok = (lexer.getToken()
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 28:
                    switch (yytok) {
                        case IDENT:
                            yyn = 2;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 29:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 56;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 30:
                    switch (yytok) {
                        case '{':
                            yyn = 3;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 31:
                    switch (yytok) {
                        case IDENT:
                            yyn = 7;
                            continue;
                        case '}':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 32:
                    switch (yytok) {
                        case AND:
                            yyn = 8;
                            continue;
                        case OR:
                            yyn = 9;
                            continue;
                        case '[':
                            yyn = 10;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 33:
                    switch (yytok) {
                        case IDENT:
                            yyn = 7;
                            continue;
                        case '}':
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 34:
                    switch (yytok) {
                        case '}':
                            yyn = 12;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 35:
                    switch (yytok) {
                        case '=':
                            yyn = 13;
                            continue;
                        case '[':
                        case OR:
                        case AND:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 36:
                    switch (yytok) {
                        case IDENT:
                            yyn = 15;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 37:
                    switch (yytok) {
                        case IDENT:
                            yyn = 15;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 38:
                    switch (yytok) {
                        case CHOOSE:
                            yyn = 18;
                            continue;
                        case IDENT:
                            yyn = 19;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 39:
                    switch (yytok) {
                        case '}':
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 40:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 41:
                    switch (yytok) {
                        case INTEGER:
                            yyn = 20;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 42:
                    switch (yytok) {
                        case '[':
                        case OR:
                        case AND:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 43:
                    switch (yytok) {
                        case '[':
                        case OR:
                        case AND:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 44:
                    switch (yytok) {
                        case AND:
                            yyn = 8;
                            continue;
                        case '[':
                        case OR:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 45:
                    switch (yytok) {
                        case CHOOSE:
                            yyn = 18;
                            continue;
                        case IDENT:
                            yyn = 19;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 46:
                    switch (yytok) {
                        case '(':
                            yyn = 22;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 47:
                    switch (yytok) {
                        case ']':
                        case IDENT:
                        case CHOOSE:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 48:
                    switch (yytok) {
                        case '}':
                        case IDENT:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 49:
                    switch (yytok) {
                        case ']':
                            yyn = 23;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 50:
                    switch (yytok) {
                        case IDENT:
                            yyn = 25;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 51:
                    switch (yytok) {
                        case '}':
                        case IDENT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 52:
                    switch (yytok) {
                        case ')':
                            yyn = 26;
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 53:
                    switch (yytok) {
                        case IDENT:
                            yyn = 25;
                            continue;
                        case ')':
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 54:
                    switch (yytok) {
                        case ']':
                        case IDENT:
                        case CHOOSE:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 55:
                    switch (yytok) {
                        case ')':
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 59;
                    continue;

                case 56:
                    return true;
                case 57:
                    yyerror("stack overflow");
                case 58:
                    return false;
                case 59:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        ISemantic[] newyysv = new ISemantic[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yyr1() { // fighter : IDENT '{' defs '}'
        { result = new Fighter(((Ident)yysv[yysp-4]), ((Pair)yysv[yysp-2])); }
        yysv[yysp-=4] = yyrv;
        return 1;
    }

    private int yyr11() { // actions : IDENT actions
        { yyrv = new Cons<Ident>(((Ident)yysv[yysp-2]), ((Pair)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yypactions();
    }

    private int yyr12() { // actions : IDENT
        { yyrv = new Cons<Ident>(((Ident)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypactions();
    }

    private int yypactions() {
        switch (yyst[yysp-1]) {
            case 22: return 24;
            default: return 27;
        }
    }

    private int yyr6() { // condition : IDENT
        { yyrv = new Atom(((Ident)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypcondition();
    }

    private int yyr7() { // condition : condition AND condition
        { yyrv = new And(((Condition)yysv[yysp-3]), ((Condition)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypcondition();
    }

    private int yyr8() { // condition : condition OR condition
        { yyrv = new Or(((Condition)yysv[yysp-3]), ((Condition)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yypcondition();
    }

    private int yypcondition() {
        switch (yyst[yysp-1]) {
            case 9: return 16;
            case 8: return 14;
            default: return 4;
        }
    }

    private int yyr4() { // def : IDENT '=' INTEGER
        { yyrv = new Strength(((Ident)yysv[yysp-3]), ((Int)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 5;
    }

    private int yyr5() { // def : condition '[' action action ']'
        { yyrv = new Behavior(((Condition)yysv[yysp-5]), ((Action)yysv[yysp-3]), ((Action)yysv[yysp-2])); }
        yysv[yysp-=5] = yyrv;
        return 5;
    }

    private int yyr2() { // defs : def defs
        { yyrv = new Cons<Def>(((Def)yysv[yysp-2]), ((Pair)yysv[yysp-1]));}
        yysv[yysp-=2] = yyrv;
        return yypdefs();
    }

    private int yyr3() { // defs : /* empty */
        { yyrv = new Nil<Def>(); }
        yysv[yysp-=0] = yyrv;
        return yypdefs();
    }

    private int yypdefs() {
        switch (yyst[yysp-1]) {
            case 3: return 6;
            default: return 11;
        }
    }

    private int yyr9() { // action : IDENT
        { yyrv = new Simple(((Ident)yysv[yysp-1])); }
        yysv[yysp-=1] = yyrv;
        return yypaction();
    }

    private int yyr10() { // action : CHOOSE '(' actions ')'
        { yyrv = new Choose(((Pair)yysv[yysp-2])); }
        yysv[yysp-=4] = yyrv;
        return yypaction();
    }

    private int yypaction() {
        switch (yyst[yysp-1]) {
            case 10: return 17;
            default: return 21;
        }
    }

    protected String[] yyerrmsgs = {
    };

private Lexer lexer; 

private Fighter result;

public Fighter getResult() {
  return result;
}

public Parser(Lexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(msg); 
}

}
