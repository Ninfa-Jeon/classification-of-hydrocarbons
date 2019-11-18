package project;
import java.util.Scanner;
class hydroCarbon{
    String formula;
    public int count=0;
    void setFormula(){
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the formula of a paraffin/olefin: ");
        formula = read.nextLine();
    }
    int checkHc(){
        int a=0;
        char[] chars = formula.toCharArray();
        
        for(char c : chars){
            if(Character.isDigit(c)){
                a += Character.getNumericValue(c);
                a *= 10;
                count++;
            }
        }
        return a;
    }
    String type(int d){
        String name=new String();
        switch(d){
            case 1: name = "Meth";
                    break;
            case 2: name = "Eth";
                    break;
            case 3: name = "Prop";
                    break;
            case 4: name = "But";
                    break;
            case 5: name = "Pent";
                    break;
            case 6: name = "Hex";
                    break;
            case 7: name = "Hept";
                    break;
            case 8: name = "Oct";
                    break;
            case 9: name = "Non";
                    break;
            case 10: name = "Dec";
                    break;
        }
        return(name);
    }
    void functionalGrp(){
        String s = new String();
        s=formula.toLowerCase();
        try{
            if(s.contains("cho")){
                System.out.println("It is an aldehyde");
            }
            else if(s.contains("co")){
                if(s.contains("cooh")){
                    System.out.println("It is a carboxylic acid");
                }
                else
                    System.out.println("It is a ketone");
            }
            else if(s.contains("oh")){
                System.out.println("It is an alcohol");
            }
        }
        catch(NullPointerException e){
            System.out.println("xyz");
        }
    }
}
class alkane extends hydroCarbon{
    alkane(){
        System.out.print("It is an alkane: ");
    }
    void name(int d){
        String name;
        name=super.type(d);
        System.out.println(name + "ane");
    }
    void draw(int d){
        System.out.print("\n\t\t    H");
        for(int i=1;i<d;i++){
            System.out.print("   H");
        }
        System.out.print("\n\t\t    |");
        for(int i=1;i<d;i++){
            System.out.print("   |");
        }
        System.out.print("\n\t\tH---C");
        for(int i=1;i<d;i++){
            System.out.print("---C");
        }
        System.out.println("---H");
        System.out.print("\t\t    |");
        for(int i=1;i<d;i++){
            System.out.print("   |");
        }
        System.out.println();
        System.out.print("\t\t    H");
        for(int i=1;i<d;i++){
            System.out.print("   H");
        }
        System.out.println();
    }
    
}
class alkene extends hydroCarbon{
    alkene(){
        System.out.print("It is an alkene: ");
    }
    void name(int d){
        String name;
        name=super.type(d);
        System.out.println(name + "ene");
    }    
    void draw(int d){
        System.out.print("\n\t\t    H    ");
        for(int i=1;i<d-1;i++){
            System.out.print("   H");
        }
        System.out.print("\n\t\t    |    ");
        for(int i=1;i<d-1;i++){
            System.out.print("   |");
        }
        System.out.print("\n\t\tH---C===");
        for(int i=1;i<d;i++){
            System.out.print("C---");
        }
        System.out.println("H");
        System.out.print("\t\t        |");
        for(int i=1;i<d-1;i++){
            System.out.print("   |");
        }
        System.out.println();
        System.out.print("\t\t        H");
        for(int i=1;i<d-1;i++){
            System.out.print("   H");
        }
        System.out.println();
    }
}
class alkyne extends hydroCarbon{
    alkyne(){
        System.out.print("It is an alkyne: ");
    }
    void name(int d){
        String name;
        name=super.type(d);                                        
        System.out.println(name + "yne");
    }
    void draw(int d){
        System.out.print("\n\t\t\t  ");
        for(int i=1;i<d-1;i++){
            System.out.print("   H");
        }
        System.out.print("\n\t\t\t  ");
        for(int i=1;i<d-1;i++){
            System.out.print("   |");
        }
        System.out.print("\n\t\tH---C≡≡≡");
        for(int i=1;i<d;i++){
            System.out.print("C---");
        }
        System.out.println("H");
        System.out.print("\t\t\t  ");
        for(int i=1;i<d-1;i++){
            System.out.print("   |");
        }
        System.out.print("\n\t\t\t  ");
        for(int i=1;i<d-1;i++){
            System.out.print("   H");
        }
        System.out.println();
    }

}

public class Project {
    public static void main(String[] args) {
        hydroCarbon h = new hydroCarbon();
        h.setFormula();
        int a, b;
        
        a = h.checkHc();
        
        if(h.count==2){
            b = (a%100)/10;
            a /= 100;
        }
        else{
            b = (a%1000)/10;
            a /= 1000;
        }
        
        if(a==0)a++;
        
        if(b == 2*a+2){
            alkane al = new alkane();
            al.name(a);
            al.draw(a);
        }
        else if(b == 2*a){
            alkene al = new alkene();
            al.name(a);
            al.draw(a);
        }
        else if(b == 2*a-2){
            alkyne al = new alkyne();
            al.name(a);
            al.draw(a);
        }
        else{
            System.out.println("The entered hc is neither alkane, alkene or alkyne");
            h.functionalGrp();
        }
    }
    
}
