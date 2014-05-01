package transactiondetails;

import java.io.File;

public class Synchronisation  {
	public static void main(String[] args) throws InterruptedException
{
String foldername="BankFiles";
File folder=new File(foldername);
File[] listoffiles=folder.listFiles();
int n=listoffiles.length;
System.out.println(n);
Thread[] th=new Thread[n];
for(int i=0;i<n;i++)
{
th[i]=new Thread(new ListOfFiles(listoffiles[i].getAbsolutePath()));
}
for(int j=0;j<n;j++)
{
th[j].start();
}
for(int j=0;j<n;j++)
{
th[j].join();
}
Transaction.finalAmount();



}
}
	
	
