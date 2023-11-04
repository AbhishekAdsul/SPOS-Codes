import java.util.*;
import java.io.*;
public class pass1 {
public static void main(String args[]) throws FileNotFoundException,Exception{
System.out.println("\033[H\033[2J");
System.out.flush();
String line="",line2="";
Map data=new HashMap();
data.put("DS", "001");
data.put("Dc", "002");
System.out.println("DATA TABLE:"+data);
Map mnemonic=new HashMap();
mnemonic.put("ADD", "01");
mnemonic.put("SUB", "02");
mnemonic.put("MUL", "03");
mnemonic.put("DIV", "04");
mnemonic.put("MOVER", "05");
mnemonic.put("MOVEM", "06");
System.out.println("MNEMONIC TABLE:"+mnemonic);
Map directive=new HashMap();
directive.put("START", "11");
directive.put("END","12");
System.out.println("DIRECTIVE TABLE:"+directive);
Map condition=new HashMap();
condition.put("LT", "21");
condition.put("GT", "22");
condition.put("LTE", "23");
condition.put("GTE", "24");
condition.put("EQU", "25");
System.out.println("CONDITION TABLE:"+condition);
Map Register=new HashMap();
Register.put("AREG", "31");
Register.put("BREG", "32");
Register.put("CREG", "33");
Register.put("DREG", "34");
System.out.println("REGISTER TABLE:"+Register);
Map Symbol=new HashMap();
Map lit_table=new HashMap();
BufferedReader br =new BufferedReader(new FileReader("C:\\Users\\Abhishek\\Desktop\\SPOS CODES\\pass1\\input.txt"));
String split_words[] = new String[5] ;
String c;
int counter = 100;
int coun1= 0;
int coun2=0;
while(( c = br.readLine()) != null)
{
split_words = c.split("\t");
System.out.println("\n"+c);
if(split_words.length>4)
{
System.out.println("more than 4 words not allowed");
}
try
{
if(split_words[0] != null)
{
if(Symbol.containsKey(split_words[0]))
{
System.out.print(Symbol.get(split_words[0]));
Symbol.put(split_words[0],Integer.toString(coun2));
}
}
if(split_words[1] != null)
{
if(directive.containsKey(split_words[1]))
{
System.out.println("\t");
}
if(mnemonic.containsKey(split_words[1]))
{
System.out.print("\t"+mnemonic.get(split_words[1]));
}
if(Symbol.containsKey(split_words[1]))
{
if(split_words[2]=="DS")
{
counter=counter+Integer.parseInt(split_words[2]);
}
}
if(split_words[2] != null)
{
if(split_words[1] == "START")
{
counter = Integer.parseInt(split_words[2]);
}
if(Register.containsKey(split_words[2]))
{
System.out.print("\t"+Register.get(split_words[2]));
}
}
if(split_words[3] != null)
{
if(split_words[3].startsWith("="))
{
coun1++;
lit_table.put(split_words[3], Integer.toString(coun1));
System.out.println("\tL"+lit_table.get(split_words[3]));
}
else
{
if(Symbol.containsKey(split_words[3]))
{
System.out.print("\tS"+Symbol.get(split_words[3]));
}
else
{
coun2++;
Symbol.put(split_words[3],Integer.toString(coun2));
System.out.print("\tS"+Symbol.get(split_words[3]));
}
}
}
 }
}
catch(Exception e)
{
continue;
}
counter++;
System.out.println("\n");
} //end while
System.out.println(line);
System.out.println("SYMBOL TABLE:"+Symbol);
System.out.println("Literal TABLE:"+lit_table);
}
}
