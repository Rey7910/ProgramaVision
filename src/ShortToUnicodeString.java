import com.sun.security.jgss.GSSUtil;

public class ShortToUnicodeString extends MiLenguajeBaseListener{

    boolean current_assign = false;
    boolean current_for_condex = false;
    boolean current_for_dec = false;

    int indent_level = 0;
    boolean waiting_period=false;

    String indent = "";

    @Override
    public void enterArith(MiLenguajeParser.ArithContext ctx) {




    }

    public void enterPrint(MiLenguajeParser.PrintContext ctx) {

        System.out.println();

        System.out.print("print(");


    }
    public void exitPrint(MiLenguajeParser.PrintContext ctx) {


        System.out.print(")");


    }

    public void enterStart_statement(MiLenguajeParser.Start_statementContext ctx) {



        if(ctx.getParent().getClass().toString().equals("class MiLenguajeParser$WhileContext") || ctx.getParent().getClass().toString().equals("class MiLenguajeParser$IfContext") || ctx.getParent().getClass().toString().equals("class MiLenguajeParser$ForContext") ){
            indent_level+=3;

            for(int i=0;i<indent_level;i++){
                indent = indent.concat(" ");
            }
        }


    }

    public void enterEnd_statement(MiLenguajeParser.End_statementContext ctx) {

        System.out.println("\nend statement");

    }





    public void enterWhile(MiLenguajeParser.WhileContext ctx) {

        System.out.println();
        System.out.print("start while ");
    }

    public void enterFor(MiLenguajeParser.ForContext ctx) {

        System.out.print("start statement for ");
        current_assign = true;
        current_for_dec = true;
    }

    public void enterAssign(MiLenguajeParser.AssignContext ctx) {


        if(!ctx.getParent().getClass().toString().equals("class MiLenguajeParser$ForContext")){
            System.out.print("\n");

        }

        current_assign=true;
    }
    public void exitAssign(MiLenguajeParser.AssignContext ctx) {




    }

    public void enterFloat(MiLenguajeParser.FloatContext ctx) {

        waiting_period = true;


    }


    public void enterIf(MiLenguajeParser.IfContext ctx) {


        System.out.println();
        System.out.print("start statement if ");



    }

    public void enterElseif(MiLenguajeParser.ElseifContext ctx) {


        System.out.println();
        System.out.print("start statement else if ");



    }

    public void enterElse(MiLenguajeParser.ElseContext ctx) {


        System.out.println();
        int indent_parcial = indent_level-3;
        String parcial = "";

        for(int i=0;i<indent_parcial;i++){
            indent = parcial.concat(" ");
        }



        System.out.print("start statement else\n ");



    }

    public void enterDec(MiLenguajeParser.DecContext ctx) {

        if(!ctx.getParent().getClass().toString().equals("class MiLenguajeParser$ForContext")){
            System.out.println();
            System.out.print(indent);
        }
        if(ctx.getChild(0).toString().equals(".")){
            System.out.print("integer ");
        }else{
            System.out.print("float ");
        }




    }

    public void exitDec(MiLenguajeParser.DecContext ctx) {


        if(current_assign && current_for_dec){
            System.out.print(" = 0 ");
            current_assign = false;
            current_for_dec = false;
        }

        if (ctx.getParent().getClass().toString().equals("class MiLenguajeParser$ForContext")){
            System.out.print(" ; ");
        }else{
            System.out.print("\n");
        }
    }

    public void exitId(MiLenguajeParser.IdContext ctx) {

        if(current_assign && !current_for_dec){
            System.out.print(" = ");
            current_assign=false;
        }


    }

    public void enterWord(MiLenguajeParser.WordContext ctx) {

        //System.out.println(ctx.getChild(0).getClass());

        if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_aContext")){
            System.out.print("a");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_bContext")){
            System.out.print("b");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_cContext")){
            System.out.print("c");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_dContext")){
            System.out.print("d");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_eContext")){
            System.out.print("e");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_fContext")){
            System.out.print("f");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_gContext")){
            System.out.print("g");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_hContext")){
            System.out.print("h");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_iContext")){
            System.out.print("i");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_jContext")){
            System.out.print("j");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_kContext")){
            System.out.print("k");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_lContext")){
            System.out.print("l");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_mContext")){
            System.out.print("m");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_nContext")){
            System.out.print("n");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_oContext")){
            System.out.print("o");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_pContext")){
            System.out.print("p");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_qContext")){
            System.out.print("q");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_rContext")){
            System.out.print("r");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_sContext")){
            System.out.print("s");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_tContext")){
            System.out.print("t");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_uContext")){
            System.out.print("u");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_vContext")){
            System.out.print("v");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_wContext")){
            System.out.print("w");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_xContext")){
            System.out.print("x");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_yContext")){
            System.out.print("y");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_zContext")){
            System.out.print("z");
        }
    }

    public void enterNumber(MiLenguajeParser.NumberContext ctx) {

        if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_0Context")){
            System.out.print("0");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_1Context")){
            System.out.print("1");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_2Context")){
            System.out.print("2");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_3Context")){
            System.out.print("3");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_4Context")){
            System.out.print("4");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_5Context")){
            System.out.print("5");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_6Context")){
            System.out.print("6");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_7Context")){
            System.out.print("7");
        }else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_8Context")) {
            System.out.print("8");
        } else if(ctx.getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_9Context")) {
            System.out.print("9");
        }

        if(waiting_period){
            System.out.print(".");
            waiting_period=false;
        }
    }

    public void enterLogic_operator(MiLenguajeParser.Logic_operatorContext ctx) {



        if(ctx.getChild(0).toString().equals("<-")){
            System.out.print("<");
        }else if(ctx.getChild(0).toString().equals("<")){
            System.out.print(">");
        }else if(ctx.getChild(0).toString().equals("<}")){
            System.out.print(">=");
        }else if(ctx.getChild(0).toString().equals("<.")){
            System.out.print("!=");
        }else if(ctx.getChild(0).toString().equals("+|")){
            System.out.print("==");
        }else if(ctx.getChild(0).toString().equals("|+")){
            System.out.print("<=");
        }


        if(ctx.getParent().getParent().getClass().toString().equals("class MiLenguajeParser$ForContext")){
            current_for_condex=true;
        }

    }

    public void exitCondex(MiLenguajeParser.CondexContext ctx) {

        if(current_for_condex){
            System.out.print(" ; ");
            current_for_condex=false;
        }else{
            System.out.print("\n");
        }

    }

    public void enterArith_operator(MiLenguajeParser.Arith_operatorContext ctx) {



        if(ctx.getChild(0).toString().equals("<<||")){
            System.out.print("*");
        }else if(ctx.getChild(0).toString().equals("|<|<")){
            System.out.print("%");
        }else if(ctx.getChild(0).toString().equals("<|-")){
            System.out.print("-");
        }else if(ctx.getChild(0).toString().equals("||<<")){
            System.out.print("/");
        }else if(ctx.getChild(0).toString().equals("<|}")){
            System.out.print("+");
        }


    }


}


