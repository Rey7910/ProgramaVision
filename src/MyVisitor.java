import java.util.HashMap;

public class MyVisitor<T> extends MiLenguajeBaseVisitor<T>{
    HashMap<String,Object> table = new HashMap<>();

    String global_variable;

    boolean current_for = false;

    public T visitSubstatement(MiLenguajeParser.SubstatementContext ctx) {

        if(ctx.dec()!=null){

            visitDec(ctx.dec());
        }else if(ctx.for_() != null){

            current_for=true;
            visitDec(ctx.for_().dec());
            Boolean condition = (Boolean) visitCondex(ctx.for_().condex());



            while(condition){

                int substatement_counter = 0;
                for(int i=0; i<ctx.for_().getChildCount();i++){

                    if(ctx.for_().getChild(i).getClass().toString().equals("class MiLenguajeParser$SubstatementContext")){
                        substatement_counter+=1;
                    }
                }

                for(int i=0; i<substatement_counter;i++){
                    visitSubstatement(ctx.for_().substatement(i));
                }


                condition = (Boolean) visitCondex(ctx.for_().condex());

                Double add_this =(Double) visitArith(ctx.for_().assign().arith());



                //System.out.println(add_this);
                table.put(global_variable, add_this);
            }

        }else if (ctx.while_() != null) {


            //System.out.println("i found a while loop");


            Boolean condition = (Boolean) visitCondex(ctx.while_().condex());

            while(condition){

                int substatement_counter = 0;
                for(int i=0; i<ctx.while_().getChildCount();i++){

                    if(ctx.while_().getChild(i).getClass().toString().equals("class MiLenguajeParser$SubstatementContext")){
                        substatement_counter+=1;
                    }
                }

                for(int i=0; i<substatement_counter;i++){
                    visitSubstatement(ctx.while_().substatement(i));
                }



                condition = (Boolean) visitCondex(ctx.while_().condex());
            }


        }else if (ctx.print() != null) {


            Double ans = (Double) visitArith(ctx.print().arith());

            int ans_int = ans.intValue();

            if(ans_int - ans == 0){
                System.out.println(ans_int);
            }else{
                System.out.println(ans);
            }


        }else if (ctx.assign() != null) {
            ctx.assign().id();

            int letter = 1;
            String char_catched;
            String current_variable="";


            for(int i=0; i<ctx.assign().id().getChildCount();i++){

                if(i==letter){
                    char_catched =  ctx.assign().id().getChild(i).getChild(0).getClass().toString();

                    if(char_catched.equals("class MiLenguajeParser$Literal_aContext")){
                        current_variable = current_variable.concat("a");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_bContext")){
                        current_variable = current_variable.concat("b");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_cContext")){
                        current_variable = current_variable.concat("c");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_dContext")){
                        current_variable = current_variable.concat("d");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_eContext")){
                        current_variable = current_variable.concat("e");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_fContext")){
                        current_variable = current_variable.concat("f");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_gContext")){
                        current_variable = current_variable.concat("g");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_hContext")){
                        current_variable = current_variable.concat("h");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_iContext")){
                        current_variable = current_variable.concat("i");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_jContext")){
                        current_variable = current_variable.concat("j");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_kContext")){
                        current_variable = current_variable.concat("k");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_lContext")){
                        current_variable = current_variable.concat("l");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_mContext")){
                        current_variable = current_variable.concat("m");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_nContext")){
                        current_variable = current_variable.concat("n");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_oContext")){
                        current_variable = current_variable.concat("o");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_pContext")){
                        current_variable = current_variable.concat("p");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_qContext")){
                        current_variable = current_variable.concat("q");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_rContext")){
                        current_variable = current_variable.concat("r");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_sContext")){
                        current_variable = current_variable.concat("s");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_tContext")){
                        current_variable = current_variable.concat("t");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_uContext")){
                        current_variable = current_variable.concat("u");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_vContext")){
                        current_variable = current_variable.concat("v");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_wContext")){
                        current_variable = current_variable.concat("w");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_xContext")){
                        current_variable = current_variable.concat("x");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_yContext")){
                        current_variable = current_variable.concat("y");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_zContext")){
                        current_variable = current_variable.concat("z");
                    }
                    letter+=3;
                }

            }

            //System.out.println(current_variable);


            //System.out.println(table.get(current_variable));

            if (table.get(current_variable) == null) {

                System.err.printf("Error semantico, la variable con nombre: \"" + current_variable + "\" no ha sido declarada.\n");
                System.exit(-1);
            } else {

                //System.out.println("valor: "+visitArith(ctx.assign().arith()));
                table.put(current_variable, visitArith(ctx.assign().arith()));
            }
        } else if(ctx.if_()!=null){
            boolean way_took = false;
            boolean condition = (boolean) visitCondex(ctx.if_().condex());

            if(condition){
                //System.out.println("execute instructions inside if statement");
                way_took=true;
                int substatement_counter = 0;
                for(int i=0; i<ctx.if_().getChildCount();i++){

                    if(ctx.if_().getChild(i).getClass().toString().equals("class MiLenguajeParser$SubstatementContext")){
                        substatement_counter+=1;
                    }
                }

                for(int i=0; i<substatement_counter;i++){
                    visitSubstatement(ctx.if_().substatement(i));
                }
            }else if(ctx.if_().elseif()!=null){
                int else_if_counter = 0;

                for(int i=0; i<ctx.if_().getChildCount();i++){
                    if(ctx.if_().getChild(i).getClass().toString().equals("class MiLenguajeParser$ElseifContext")){
                        else_if_counter+=1;
                    }
                }

                //System.out.println(else_if_counter);


                for(int j=0; j<else_if_counter;j++){
                    condition = (boolean) visitCondex(ctx.if_().elseif(j).condex());
                    //System.out.println(condition);
                    if(condition){
                        way_took=true;
                        int substatement_counter = 0;
                        for(int i=0; i<ctx.if_().elseif(j).getChildCount();i++){

                            if(ctx.if_().elseif(j).getChild(i).getClass().toString().equals("class MiLenguajeParser$SubstatementContext")){
                                substatement_counter+=1;
                            }
                        }

                        for(int i=0; i<substatement_counter;i++){
                            visitSubstatement(ctx.if_().elseif(j).substatement(i));
                        }
                        break;
                    }
                }
            }

            if(ctx.if_().else_()!=null && !way_took){
                int substatement_counter = 0;
                for(int i=0; i<ctx.if_().else_().getChildCount();i++){

                    if(ctx.if_().getChild(i).getClass().toString().equals("class MiLenguajeParser$SubstatementContext")){
                        substatement_counter+=1;
                    }
                }

                for(int i=0; i<substatement_counter;i++){
                    visitSubstatement(ctx.if_().else_().substatement(i));
                }
            }
            way_took=false;

        }

        //return super.visitSubstatement(ctx);
        return null;
    }


    @Override
    public T visitCondex(MiLenguajeParser.CondexContext ctx) {

        Boolean num = false;
        if(ctx.TOKEN_OPEN_PAR()!=null){

            return (visitCondex(ctx.condex(0)));

        } else if(ctx.NOT()!=null){
            //System.out.println("here we find not statement");

            return (visitCondex(ctx.condex(0)));

        }else if(ctx.arith()!=null){
            //System.out.println("here we find arith statement");

            Double num1 = (Double) visitArith(ctx.arith(0));
            Double num2 = (Double) visitArith(ctx.arith(1));

            Boolean ans = null;

            String operator = ctx.getChild(1).getChild(0).toString();

            //System.out.println(operator);

            switch (operator){
                case "+|":
                    ans = Math.abs(num1 - num2) < 0.000000001;
                    break;
                case "<":
                    ans = num1 > num2;
                    break;
                case "<}":
                    ans = num1 >= num2;
                    break;
                case "<-":
                    ans = num1 < num2;
                    break;
                case "|+":
                    ans = num1 <= num2;
                    break;
                case "<.":
                    ans = Math.abs(num1 - num2) > 0.000000001;
                    break;

            }

            return (T) ans;

        }else{
            return (T) num;
        }


    }


    @Override
    public T visitArith(MiLenguajeParser.ArithContext ctx) {

        //System.out.println("Visit arith");

        //System.out.println(ctx);


        if (ctx.integer() != null) {

            //System.out.println("visit integer arith");

            int number = 1;
            String char_catched;
            String current_variable="";
            //System.out.println("Integer found");


            for(int i=0; i<ctx.integer().getChildCount();i++) {

                if(number == i){
                    char_catched =  ctx.integer().getChild(i).getChild(0).getClass().toString();


                    if(char_catched.equals("class MiLenguajeParser$Literal_0Context")){
                        current_variable = current_variable.concat("0");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_1Context")){
                        current_variable = current_variable.concat("1");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_2Context")){
                        current_variable = current_variable.concat("2");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_3Context")){
                        current_variable = current_variable.concat("3");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_4Context")){
                        current_variable = current_variable.concat("4");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_5Context")){
                        current_variable = current_variable.concat("5");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_6Context")){
                        current_variable = current_variable.concat("6");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_7Context")){
                        current_variable = current_variable.concat("7");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_8Context")){
                        current_variable = current_variable.concat("8");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_9Context")){
                        current_variable = current_variable.concat("9");
                    }

                    number+=3;
                }

            }

            Double num = Double.parseDouble(current_variable);

            //System.out.println(num);

            return (T) num;

        } else if (ctx.TOKEN_OPEN_PAR() != null) {

            return visitArith(ctx.arith(0));

        } else if (ctx.id() != null) {


            //System.out.println("visit id arith");
            Object value;

            int letter = 1;
            String char_catched;
            String current_variable="";


            for(int i=0; i<ctx.id().getChildCount();i++){

                if(i==letter){
                    char_catched =  ctx.id().getChild(i).getChild(0).getClass().toString();

                    if(char_catched.equals("class MiLenguajeParser$Literal_aContext")){
                        current_variable = current_variable.concat("a");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_bContext")){
                        current_variable = current_variable.concat("b");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_cContext")){
                        current_variable = current_variable.concat("c");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_dContext")){
                        current_variable = current_variable.concat("d");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_eContext")){
                        current_variable = current_variable.concat("e");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_fContext")){
                        current_variable = current_variable.concat("f");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_gContext")){
                        current_variable = current_variable.concat("g");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_hContext")){
                        current_variable = current_variable.concat("h");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_iContext")){
                        current_variable = current_variable.concat("i");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_jContext")){
                        current_variable = current_variable.concat("j");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_kContext")){
                        current_variable = current_variable.concat("k");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_lContext")){
                        current_variable = current_variable.concat("l");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_mContext")){
                        current_variable = current_variable.concat("m");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_nContext")){
                        current_variable = current_variable.concat("n");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_oContext")){
                        current_variable = current_variable.concat("o");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_pContext")){
                        current_variable = current_variable.concat("p");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_qContext")){
                        current_variable = current_variable.concat("q");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_rContext")){
                        current_variable = current_variable.concat("r");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_sContext")){
                        current_variable = current_variable.concat("s");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_tContext")){
                        current_variable = current_variable.concat("t");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_uContext")){
                        current_variable = current_variable.concat("u");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_vContext")){
                        current_variable = current_variable.concat("v");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_wContext")){
                        current_variable = current_variable.concat("w");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_xContext")){
                        current_variable = current_variable.concat("x");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_yContext")){
                        current_variable = current_variable.concat("y");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_zContext")){
                        current_variable = current_variable.concat("z");
                    }
                    letter+=3;
                }

            }
            String name;
            name = current_variable;

            if ((value = table.get(name)) == null) {
                System.err.printf("Error semantico, la variable con nombre \"" + name + "\" no fue declarada.\n");
                System.exit(-1);
                return null;
            } else {
                return (T) value;
            }

        } else if(ctx.float_()!= null){
            int number = 1;
            String char_catched;
            String current_variable="";
            //System.out.println("float found");



            for(int i=0; i<ctx.float_().getChildCount();i++) {

                if(ctx.float_().getChild(i).toString().equals("||||")){
                    current_variable = current_variable.concat(".");
                    number+=1;
                }

                if(number == i){
                    char_catched =  ctx.float_().getChild(i).getChild(0).getClass().toString();


                    if(char_catched.equals("class MiLenguajeParser$Literal_0Context")){
                        current_variable = current_variable.concat("0");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_1Context")){
                        current_variable = current_variable.concat("1");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_2Context")){
                        current_variable = current_variable.concat("2");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_3Context")){
                        current_variable = current_variable.concat("3");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_4Context")){
                        current_variable = current_variable.concat("4");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_5Context")){
                        current_variable = current_variable.concat("5");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_6Context")){
                        current_variable = current_variable.concat("6");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_7Context")){
                        current_variable = current_variable.concat("7");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_8Context")){
                        current_variable = current_variable.concat("8");
                    }else if(char_catched.equals("class MiLenguajeParser$Literal_9Context")){
                        current_variable = current_variable.concat("9");
                    }

                    number+=3;
                }

            }

            Double num = Double.parseDouble(current_variable);

            //System.out.println(num);

            return (T) num;
        }else{
            //System.out.println("lets make an operation");
            Double num1 = (Double) visitArith(ctx.arith(0));
            Double num2 = (Double) visitArith(ctx.arith(1));

            //System.out.println("literal 1: "+num1);
            //System.out.println("literal 2: "+num2);

            Double ans = null;



            String operator = ctx.getChild(1).getChild(0).toString();


            switch (operator){
                case "<|-":
                    ans = num1 - num2;

                    break;
                case "<|}":
                    ans = num1 + num2;
                    break;
                case "<<||":
                    ans = num1 * num2;
                    break;
                case "||<<":
                    ans = num1 / num2;
                    break;
                case "|<|<":
                    ans = num1 % num2;
                    //System.out.println("mod: "+ans);
                    break;
            }

            return (T) ans;

        }


    }

    @Override
    public T visitAssign(MiLenguajeParser.AssignContext ctx) {
        return super.visitAssign(ctx);
    }


    @Override
    public T visitDec(MiLenguajeParser.DecContext ctx) {

        //return super.visitDec(ctx);
        // System.out.println(ctx.getChild(1).getChild(0).getClass().toString().equals("class MiLenguajeParser$Literal_xContext"));


        int letter = 1;
        String char_catched;
        String current_variable="";


        for(int i=0; i<ctx.id().getChildCount();i++){

            if(i==letter){
                char_catched =  ctx.id().getChild(i).getChild(0).getClass().toString();

                if(char_catched.equals("class MiLenguajeParser$Literal_aContext")){
                    current_variable = current_variable.concat("a");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_bContext")){
                    current_variable = current_variable.concat("b");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_cContext")){
                    current_variable = current_variable.concat("c");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_dContext")){
                    current_variable = current_variable.concat("d");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_eContext")){
                    current_variable = current_variable.concat("e");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_fContext")){
                    current_variable = current_variable.concat("f");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_gContext")){
                    current_variable = current_variable.concat("g");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_hContext")){
                    current_variable = current_variable.concat("h");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_iContext")){
                    current_variable = current_variable.concat("i");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_jContext")){
                    current_variable = current_variable.concat("j");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_kContext")){
                    current_variable = current_variable.concat("k");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_lContext")){
                    current_variable = current_variable.concat("l");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_mContext")){
                    current_variable = current_variable.concat("m");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_nContext")){
                    current_variable = current_variable.concat("n");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_oContext")){
                    current_variable = current_variable.concat("o");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_pContext")){
                    current_variable = current_variable.concat("p");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_qContext")){
                    current_variable = current_variable.concat("q");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_rContext")){
                    current_variable = current_variable.concat("r");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_sContext")){
                    current_variable = current_variable.concat("s");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_tContext")){
                    current_variable = current_variable.concat("t");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_uContext")){
                    current_variable = current_variable.concat("u");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_vContext")){
                    current_variable = current_variable.concat("v");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_wContext")){
                    current_variable = current_variable.concat("w");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_xContext")){
                    current_variable = current_variable.concat("x");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_yContext")){
                    current_variable = current_variable.concat("y");
                }else if(char_catched.equals("class MiLenguajeParser$Literal_zContext")){
                    current_variable = current_variable.concat("z");
                }
                letter+=3;
            }

        }

        //System.out.println(table.get(current_variable));

        if (table.get(current_variable) != null) {
            System.err.printf("ERROR: La variable \'"+current_variable+"\' ya fue declarada anteriormente");
            System.exit(-1);
        } else {
            table.put(current_variable, 0.0);
            if(current_for){
                global_variable=current_variable;
                current_for=false;
            }
            //System.out.println("Variable with name: "+current_variable+" added");
        }

        return null;
    }

    @Override
    public T visitIf(MiLenguajeParser.IfContext ctx) {


        return null;
    }


    @Override

    public T visitId(MiLenguajeParser.IdContext ctx) {

        return null;
    }

}
