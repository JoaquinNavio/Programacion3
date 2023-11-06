import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //MUTANTE WORD
       String[] entry234234= new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        //NO MUTANTE WORD
        String[] entry345= new String[]{"ATGGCA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        //NO MUTANTES MIA
        String[] entry= new String[]{
                "ATGCAA",
                "CAGTGC",
                "TATTCT",
                "AGACGG",
                "GCCTCA",
                "TTACTG"};
        String[] entry22 = {
                "ATGCGA",
                "CAGTGC",
                "TTGTGT",
                "AGAATG",
                "CCGCTA",
                "TCACTG"
        };
        String[] entry44 = {
                "ATGCGA",
                "CAGTAC",
                "TTGTGA",
                "AGAAGG",
                "TCCCTA",
                "TCACTA"
        };
        //MUTANTES MIA 1
        String[] entry345345 = {
                "ATGCGA",
                "CAGTGC",
                "TTATGA",
                "AGTAGA",
                "TCCTTA",
                "TCACTA"
        };
        String[] entry2342345 = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        String[] entry3455 = {
                "ATGCGA",
                "CAGTAC",
                "TTAAGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        try {
            if (checkHorizontal(entry)+checkVertical(entry)+checkObliquoDERECHA(entry)+checkObliquoIZQ(entry)>=2){
                System.out.println("ES MUTANTE");
            }else{
                System.out.println("NO ES MUTANTE");
            }
        }catch (Exception e){
            System.out.printf("ERROR  "+ e.getMessage());
        }
    }

    public static int checkHorizontal(String[] entry) {
        int cont=0;
        int genMutante=0;
        //USO CONTAINS PARA CHEQUEAR SI TIENE 4 CARACTERES SEGUIDOS IGUALES
        for (String row : entry) {
            if (row.contains("AAAA") || row.contains("CCCC") || row.contains("TTTT") || row.contains("GGGG")){
                genMutante += 1;
                System.out.println(entry[cont]);
            } else {
            }
            cont+=1;
        }
        return  genMutante;
    }
    public static int checkVertical(String[] entry) {
        int genMutante=0;
        for (int i = 0; i < entry.length  ; i++) {
            String auxString="";
            for (String str : entry) {
                auxString += str.charAt(i);
            }
            String[] entry2 = new String[1];
            entry2[0]=auxString;
            //LLAMO A CHECKHORIZONTAL PARA VERIFICAR SI ES MUTANTE
            genMutante+=checkHorizontal(entry2);

        }
        return  genMutante;
    }
    public static int checkObliquoIZQ(String[] entry) {
        //VARIABLES A UTILIZAR PARA EL RECORRIDO
        int genMutante=0;
        String auxString="";
        int index = 0;
        int aux=entry.length;
        int aux2=0;
        for (int j = 0; j < entry.length-3; j++) {
            for (int i = 0; i < aux; i++) {
                auxString += entry[i].charAt(index);
                index += 1;
            }
            String[] entry2 = new String[1];
            entry2[0]=auxString;
            //LLAMO A CHECKHORIZONTAL PARA VERIFICAR SI ES MUTANTE
            genMutante+=checkHorizontal(entry2);
            aux2+=1;
            aux-=1;
            index=aux2;
            auxString ="";
        }

        //RESETEO LAS VARIABLES PARA CHEQUEAR LA DIAGONAL HACIA ABAJO
        auxString="";
        index = 0;
        aux=entry.length;
        aux2=0;
        int contador=1;
        for (int j = 0; j < entry.length-3; j++) {

            for (int i = contador; i < aux; i++) {
                auxString += entry[i].charAt(index);
                index += 1;
            }
            String[] entry3 = new String[1];
            entry3[0]=auxString;
            //LLAMO A CHECKHORIZONTAL PARA VERIFICAR SI ES MUTANTE
            genMutante+=checkHorizontal(entry3);
            aux2+=1;
            index=0;
            auxString ="";
            contador++;}
        return genMutante;
    }

    public static int checkObliquoDERECHA(String[] entry) {
        //VARIABLES A UTILIZAR PARA EL RECORRIDO
        int genMutante=0;
        String auxString="";
        int index = entry.length-1;
        int aux=entry.length;
        int aux2=entry.length-1;
        //FOR DONDE RECORRO DIAGONALMENTE HACIA EL COSTADO
        for (int j = 0; j < entry.length-3; j++) {
            for (int i = 0; i < aux; i++) {
                auxString += entry[i].charAt(index);
                index -= 1;}
            String[] entry2 = new String[1];
            entry2[0]=auxString;
            //LLAMO A CHECKHORIZONTAL PARA VERIFICAR SI ES MUTANTE
            genMutante+=checkHorizontal(entry2);
            aux2-=1;
            aux-=1;
            index=aux2;
            auxString ="";}
        //RESETEO LAS VARIABLES PARA CHEQUEAR LA DIAGONAL HACIA ABAJO
        genMutante=0;
        auxString="";
        index = entry.length-1;
        aux=entry.length;
        aux2=1;
        //FOR DONDE RECORRO DIAGONALMENTE HACIA ABAJO
        for (int j = 0; j < 3; j++) {

            for (int i = aux2; i < aux; i++) {
                auxString += entry[i].charAt(index);
                index -= 1;
            }

            String[] entry2 = new String[1];
            entry2[0]=auxString;
            //LLAMO A CHECKHORIZONTAL PARA VERIFICAR SI ES MUTANTE
            genMutante+=checkHorizontal(entry2);
            aux2+=1;
            index = entry.length-1;
            auxString ="";
        }
        return genMutante;
    }
}