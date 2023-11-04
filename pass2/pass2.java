import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class pass2 {
public static void main(String[] args) throws IOException {
System.out.println("\033[H\033[2J");
System.out.flush();
BufferedReader br = new BufferedReader(new
FileReader("C:\\Users\\Abhishek\\Desktop\\SPOS CODES\\pass2/input.txt"));
BufferedReader sy = new BufferedReader(new
FileReader("C:\\Users\\Abhishek\\Desktop\\SPOS CODES\\pass2/sym.txt"));
BufferedReader sy1 = new BufferedReader(new
FileReader("C:\\Users\\Abhishek\\Desktop\\SPOS CODES\\pass2/sym.txt"));
BufferedReader sy2 = new BufferedReader(new
FileReader("C:\\Users\\Abhishek\\Desktop\\SPOS CODES\\pass2/sym.txt"));
BufferedReader li = new BufferedReader(new
FileReader("C:\\Users\\Abhishek\\Desktop\\SPOS CODES\\pass2/lit.txt"));
String split_words[] = new String[5] ;
String sym_words[] = new String[5] ;
String lit_words[] = new String[5] ;
String check;
int addr;
String c;
String d;
String e,f;
int counter = 100;
int Dscounter;
c=br.readLine();
split_words=c.split(" ");
counter=Integer.parseInt(split_words[1]);
System.out.println(split_words[0]+"\t"+split_words[1]+"\t"+split_words[2]+"\n");
while(( c = br.readLine()) != null)
{
split_words=c.split(" ");
counter++;
System.out.print(counter+"\t");
System.out.println(split_words[0]+"\t"+split_words[1]+"\t"+split_words[2]);
if(split_words[2].startsWith("S"))
{
System.out.print(counter+"\t");
System.out.print(split_words[0]+"\t"+split_words[1]+"\t"+split_words[2]+"\t");
while(( d = sy.readLine()) != null)
{ sym_words = d.split(" ");
if(split_words[2].equals(sym_words[0]))
{ System.out.println(sym_words[2]+"\n");
break;
}
}
}
else if(split_words[2].startsWith("L"))
{ System.out.print(counter+"\t");
System.out.print(split_words[0]+"\t"+split_words[1]+"\t"+split_words[2]);
while(( e = li.readLine()) != null)
{
lit_words = e.split(" ");
if(split_words[2].equals(lit_words[0]))
{
System.out.println("\t"+lit_words[0]+"\n");
break;
}
}
}
else if(split_words[1].contentEquals("DC"))
{
while(( f = sy1.readLine()) != null)
{
sym_words = f.split(" ");
System.out.print("\n");
System.out.print(counter+"\t");
if(split_words[0].equals(sym_words[1]))
{
System.out.print("\t");
System.out.print(sym_words[2]+"\t");
System.out.print("00"+"\t");
System.out.print(split_words[2]+"\n");
break;
}
 }
}
else if(split_words[1].contentEquals("DS"))
{
while(( f = sy2.readLine()) != null)
{
sym_words = f.split(" ");
if(split_words[0].equals(sym_words[1]))
{
System.out.print(counter+"\t");
System.out.print(sym_words[2]+"\t");
System.out.print("00"+"\t");
System.out.print(split_words[2]);
/*Dscounter=Integer.parseInt(split_words[2]);
counter=counter+Dscounter-1;
*/
break;
}
}
}
else
{
System.out.println("\n"+"inside else");
System.out.print("\n"+counter+"\t");
System.out.println(split_words[0]+"\t"+split_words[1]+"\t"+split_words[2]);
}
}
}
}
