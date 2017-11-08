package com.apoorv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//~ number of transactions->transac_Number
public class Apriori_self{
    String filename;String result1it="";
    int transaction_number,max=0,min_support_int;ArrayList<ArrayList<String>> listOLists;double min_support;
    public Apriori_self(String a,double b){
        this.filename=a;
        this.min_support=b;
        
    }
    ArrayList<ArrayList<String>> listofListsC1;ArrayList<ArrayList<Integer>> listofListsC2;
    ArrayList<String> listofListsI11;ArrayList<Integer> listofListsI12;
    ArrayList<String> listofListsI21;ArrayList<Integer> listofListsI22;
    ArrayList<String> listofListsI31;ArrayList<Integer> listofListsI32;
	public void using_apriori(int a){
		result1it+="Input Given\n";
                        System.out.println("Input Given\n");
		for(int i=0;i<listOLists.size();i++){
                    int j_max=(listOLists.get(i)).size();
			for(int j=0;j<j_max;j++){
                            result1it+=((listOLists.get(i))).get(j)+"\t";
				System.out.print(((listOLists.get(i))).get(j)+"\t");
			}
                        result1it+="\n";
                        System.out.print("\n");
		}
			result1it+=max;
                        System.out.println(max);
			execute_apriori(max);
		}
		
		public void execute_apriori(int y){
			int current_it=1,temp_count=0;
			ArrayList<String> listTmp=new ArrayList<String>();
			ArrayList<Integer> listTmp2=new ArrayList<Integer>();
			for(int i=0;i<listOLists.size();i++){
                    int j_max=(listOLists.get(i)).size();
			for(int j=0;j<j_max;j++){
				if(listTmp.contains(((listOLists.get(i))).get(j))==false)
				listTmp.add(((listOLists.get(i))).get(j));
			}
			}
			for(int i=0;i<listTmp.size();i++){
                result1it+=listTmp.get(i)+"\t";
                System.out.print(listTmp.get(i)+"\t");
                  for(int j=0;j<listOLists.size();j++){
                    int k_max=(listOLists.get(j)).size();
			for(int k=0;k<k_max;k++){
				if(((listOLists.get(j)).get(k)).contains(listTmp.get(i)))
				{
							temp_count++;
							break;
				}
			}
			}
				listTmp2.add(temp_count);
				temp_count=0;
			}
                        result1it+="\n";
			System.out.print("\n");
			for(int i=0;i<listTmp2.size();i++){
                result1it+=listTmp2.get(i)+"\t";
                    System.out.print(listTmp2.get(i)+"\t");
			}
//				System.out.println("\nEnter minimum Support");
//				Scanner sc=new Scanner(System.in);
//                                min_support=sc.nextDouble();
//                                min_support=min_support/100.0;
//                                sc.close();
                                min_support_int=(int)Math.ceil(transaction_number*min_support);
                                //ct = (ArrayList<Object>)myTempObject.clone();
                                listofListsI11=(ArrayList<String>)listTmp.clone();
                                listofListsI12=(ArrayList<Integer>)listTmp2.clone();
                                for(int i=0;i<listTmp2.size();i++){
                                    if(listTmp2.get(i)< min_support_int){
                                        listTmp2.remove(i);
                                        listTmp.remove(i);
                                        i=i-1;
                                        
                                    }
			}
                            result1it+="First set of frequent Itemsets given minimum support:"+min_support_int+"\n";
                            System.out.print("First set of frequent Itemsets given minimum support:"+min_support_int+"\n");
                            print_listings(listTmp,listTmp2);
                             //Second Iteration
                            result1it+="\nSecond iteration";
                            System.out.println("\nSecond iteration");
                             int items_temp=listTmp.size();String empt;int items_temp_count;
                             int iter1_result1,iter2_result2;
                             iter1_result1=listTmp.size()-1;
                             iter2_result2=listTmp.size();
                             for(int i=0;i<iter1_result1;i++){
                                 for(int j=i+1;j<iter2_result2;j++){
                                     empt=listTmp.get(i)+","+listTmp.get(j);
                                     listTmp.add(empt);
                                     items_temp_count=calculate_two_items(listTmp.get(i),listTmp.get(j));
                                     listTmp2.add(items_temp_count);
                                 }empt="";
                             }
                             
                             while(items_temp>0){
                                     listTmp.remove(0);
                                     listTmp2.remove(0);
                                     items_temp--;
                                 }
                             listofListsI21=(ArrayList<String>)listTmp.clone();
                                listofListsI22=(ArrayList<Integer>)listTmp2.clone();
                             for(int i=0;i<listTmp2.size();i++){
                                    if(listTmp2.get(i)< min_support_int){
                                        listTmp2.remove(i);
                                        listTmp.remove(i);
                                        i=i-1;
                                        
                                    }
                             }
                             result1it+="Second set of frequent Itemsets given minimum support:"+min_support_int+"\n";
                             System.out.print("Second set of frequent Itemsets given minimum support:"+min_support_int+"\n");
                             print_listings(listTmp,listTmp2);
                             calculating_confidence_for2(listTmp,listTmp2);
                             result1it+="\nThird iteration";
                             System.out.println("\nThird iteration");
                             int items_temp2=listTmp.size();String empt2;int items_temp_count2;
                             int iter1_result12,iter2_result22;
                             iter1_result12=listTmp.size()-1;
                             iter2_result22=listTmp.size();
                             for(int i=0;i<iter1_result12;i++){
                                 for(int j=i+1;j<iter2_result22;j++){
                                     String atemp=(listTmp.get(i)).split(",")[0];String btemp=(listTmp.get(i)).split(",")[1];
                                     String ctemp=(listTmp.get(j)).split(",")[0];String dtemp=(listTmp.get(j)).split(",")[1];
                                     //System.out.println(atemp+"\t\t"+ctemp+"\t\t"+btemp+"\t\t"+dtemp+"\n");
                                     if(atemp.equals(ctemp)&&!btemp.equals(dtemp)){
                                     empt2=atemp+","+btemp+","+dtemp;
                                     listTmp.add(empt2);
                                     items_temp_count2=calculate_three_items(atemp,btemp,dtemp);
                                     listTmp2.add(items_temp_count2);}
                                 }empt2="";
                             }
                             
                             while(items_temp2>0){
                                     listTmp.remove(0);
                                     listTmp2.remove(0);
                                     items_temp2--;
                                 }
                             listofListsI31=(ArrayList<String>)listTmp.clone();
                                listofListsI32=(ArrayList<Integer>)listTmp2.clone();
                             for(int i=0;i<listTmp2.size();i++){
                                    if(listTmp2.get(i)< min_support_int){
                                        listTmp2.remove(i);
                                        listTmp.remove(i);
                                        i=i-1;
                                        
                                    }}
                             result1it+="Third set of frequent Itemsets given minimum support:"+min_support_int+"\n";
                             System.out.print("Third set of frequent Itemsets given minimum support:"+min_support_int+"\n");
                             print_listings(listTmp,listTmp2);
                             calculating_confidence(listTmp,listTmp2);
			}
                public void calculating_confidence_for2(ArrayList<String> tmp,ArrayList<Integer> tmp2){
                   ArrayList<String> tmpList1=new ArrayList<String>();
                   ArrayList<Integer> tmpList2=new ArrayList<Integer>();String emp5;
                    for(int i=0;i<tmp.size();i++){
                        String a=tmp.get(i).split(",")[0];String b=tmp.get(i).split(",")[1];
                        emp5=a+"->"+b;
                        tmpList1.add(emp5);
                        int tempNum=find_value(listofListsI11,a);
                        tmpList2.add(listofListsI12.get(tempNum));
                        emp5="";
                        
                    }
                    /*
                        emp5=b+"->"+a;
                        tmpList1.add(emp5);
                        tempNum=find_value(listofListsI11,b);
                        tmpList2.add(listofListsI12.get(tempNum));
                        emp5="";*/
                    result1it+="Items"+"\t\t\t\t"+"Support"+"\t\t"+"Count"+"\t\t"+"Confidence"+"\t\t";
                    System.out.println("Items"+"\t\t\t\t"+"Support"+"\t\t"+"Count"+"\t\t"+"Confidence"+"\t\t");
                    for(int i=0;i<tmpList1.size();i++){
                            double conf=((float)tmp2.get(i)/(float)(tmpList2.get(i)))*100.0;
                            String strDouble = String.format("%.2f", conf);
                            result1it+=tmpList1.get(i)+"\t\t\t"+tmp2.get(i)+"\t\t"+tmpList2.get(i)+"\t\t"+strDouble;
                            System.out.println(tmpList1.get(i)+"\t\t\t"+tmp2.get(i)+"\t\t"+tmpList2.get(i)+"\t\t"+strDouble);
                        }
                    tmpList1.clear();
                    tmpList2.clear();
                    for(int i=0;i<tmp.size();i++){
                        String a=tmp.get(i).split(",")[0];String b=tmp.get(i).split(",")[1];
                        emp5=b+"->"+a;
                        tmpList1.add(emp5);
                        int tempNum=find_value(listofListsI11,b);
                        tmpList2.add(listofListsI12.get(tempNum));
                        emp5="";
                        
                    }for(int i=0;i<tmpList1.size();i++){
                            double conf=((float)tmp2.get(i)/(float)(tmpList2.get(i)))*100.0;
                            String strDouble = String.format("%.2f", conf);
                            result1it+=tmpList1.get(i)+"\t\t\t"+tmp2.get(i)+"\t\t"+tmpList2.get(i)+"\t\t"+strDouble;
                            System.out.println(tmpList1.get(i)+"\t\t\t"+tmp2.get(i)+"\t\t"+tmpList2.get(i)+"\t\t"+strDouble);
                        }
                }
                public void calculating_confidence(ArrayList<String> tmp,ArrayList<Integer> tmp2){
                    String emp31="",emp32="",emp33="",emp34="",emp35="",emp36="";
                    String emp41="",emp42="",emp43="",emp44="",emp45="",emp46="";
                    listofListsC1=new ArrayList<ArrayList<String>>();
                    listofListsC2=new ArrayList<ArrayList<Integer>>();
                    ArrayList<String> tmplist=new ArrayList<String>();
                    ArrayList<Integer> tmplist2=new ArrayList<Integer>();
                    
                    for(int i=0;i<tmp.size();i++){
                        String a=tmp.get(i).split(",")[0];String b=tmp.get(i).split(",")[1];String c=tmp.get(i).split(",")[2];
                        emp31=a+"^"+b+"->"+c;emp41=a+","+b;tmplist2.add(listofListsI22.get(find_value(listofListsI21,emp41)));
                        emp32=a+"^"+c+"->"+b;emp42=a+","+c;tmplist2.add(listofListsI22.get(find_value(listofListsI21,emp42)));
                        emp33=b+"^"+c+"->"+a;emp43=b+","+c;tmplist2.add(listofListsI22.get(find_value(listofListsI21,emp43)));
                        emp34=a+"->"+"{"+b+","+c+"}";emp44=a;tmplist2.add(listofListsI12.get(find_value(listofListsI11,emp44)));
                        emp35=b+"->"+"{"+a+","+c+"}";emp45=b;tmplist2.add(listofListsI12.get(find_value(listofListsI11,emp45)));
                        emp36=c+"->"+"{"+a+","+b+"}";emp46=c;tmplist2.add(listofListsI12.get(find_value(listofListsI11,emp46)));
                        tmplist.add(emp31);tmplist.add(emp32);tmplist.add(emp33);tmplist.add(emp34);tmplist.add(emp35);tmplist.add(emp36);
                        listofListsC1.add(tmplist);
                        listofListsC2.add(tmplist2);
                    }
                    result1it+="Items"+"\t\t\t\t"+"Support"+"\t\t"+"Count"+"\t\t"+"Confidence"+"\t\t";
                    System.out.println("Items"+"\t\t\t\t"+"Support"+"\t\t"+"Count"+"\t\t"+"Confidence"+"\t\t");
                    for(int i=0;i<listofListsC1.size();i++){
                        for(int j=0;j<(listofListsC1.get(i)).size();j++){
                            double conf=((float)tmp2.get(i)/((float)(listofListsC2.get(i)).get(j)))*100.0;
                            String strDouble = String.format("%.2f", conf);
                            result1it+=(listofListsC1.get(i)).get(j)+"\t\t"+tmp2.get(i)+"\t\t"+(listofListsC2.get(i)).get(j)+"\t\t"+strDouble;
                            System.out.println((listofListsC1.get(i)).get(j)+"\t\t"+tmp2.get(i)+"\t\t"+(listofListsC2.get(i)).get(j)+"\t\t"+strDouble);
                        }
                    }
                    
                }
                public int find_value(ArrayList<String> tmp,String s){
                    int place=0;
                    for(int i=0;i<tmp.size();i++){
                        if((tmp.get(i)).equals(s)){
                            place=i; 
                        }
                    }
                    return place;
                }
                public int calculate_three_items(String a,String b, String c){
                    boolean mytemp1=false,mytemp2=false,mytemp3=false;int count=0;
                for(int j=0;j<listOLists.size();j++){
                    int k_max=(listOLists.get(j)).size();
			for(int k=0;k<k_max;k++){
				if(((listOLists.get(j)).get(k)).contains(a))
				{
					mytemp1=true;
				}
                                if(((listOLists.get(j)).get(k)).contains(b))
				{
					mytemp2=true;
				}
                                if(((listOLists.get(j)).get(k)).contains(c))
				{
					mytemp3=true;
				}
			}
                        if(mytemp1==true && mytemp2==true && mytemp3==true)
				{
					++count;
				}mytemp1=false;mytemp2=false;mytemp3=false;
			}
                return count;
                }
                public void print_listings(ArrayList<String> listTmp,ArrayList<Integer> listTmp2){
                    result1it+= "Items"+"\t\t"+"respected values"+"\t"+"min_support";
                    System.out.println("Items"+"\t\t"+"respected values"+"\t"+"min_support");
                    for(int i=0;i<listTmp.size();i++){
                        result1it+=listTmp.get(i)+"\t\t"+listTmp2.get(i)+"\t\t"+min_support_int;
                System.out.println(listTmp.get(i)+"\t\t"+listTmp2.get(i)+"\t\t"+min_support_int);
			}
                }
                public int calculate_two_items(String a,String b){
                    boolean mytemp1=false,mytemp2=false;int count=0;
                for(int j=0;j<listOLists.size();j++){
                    int k_max=(listOLists.get(j)).size();
			for(int k=0;k<k_max;k++){
				if(((listOLists.get(j)).get(k)).contains(a))
				{
					mytemp1=true;
				}
                                if(((listOLists.get(j)).get(k)).contains(b))
				{
					mytemp2=true;
				}
			}
                        if(mytemp1==true && mytemp2==true)
				{
					++count;
				}mytemp1=false;mytemp2=false;
			}
                return count;
                }
        public void create_list(int traa){
        listOLists = new ArrayList<ArrayList<String>>(traa);
        }
        //~ C:/Users/hp/Desktop/transaction.txt
                  public void create_sub(String l,int a){
					  //System.out.println("Creating lists");System.out.println(l);
						StringTokenizer tokenizer2;String line2,token2;
                        tokenizer2 = new StringTokenizer(l, ",");
                        ArrayList<String> list = new ArrayList<String>(a);
                            while(tokenizer2.hasMoreTokens()) {		
                        list.add(tokenizer2.nextToken());
                        }
                        listOLists.add(list);
                        if(a>max){
                        max=a;
                        }
                        //System.out.println("Current execution finished");
                  }
	
	public void execute_main_function(){
                int count;StringTokenizer tokenizer;String line,token;
		BufferedReader input = null;
		//~ System.out.println("Enter the file\n");
		//System.out.println("Enter the file directory\n");
		//Scanner sc=new Scanner(System.in);
		//String filename=sc.nextLine();
		
		try {
			input = new BufferedReader(new FileReader(filename));
			line = input.readLine(); //when printed gives first line in file
			transaction_number=Integer.parseInt(line);
                        create_list(transaction_number);
                        result1it+="Number of transactions are\t"+transaction_number+"\n";
			System.out.println("Number of transactions are\t"+transaction_number+"\n");
			line = input.readLine();
			//outer while (process lines)
			while(line != null){ //doesn't seem to start from first line
			tokenizer = new StringTokenizer(line, ",");
                        count=tokenizer.countTokens();
                        create_sub(line,count);
			line = input.readLine(); //next line
			}//close outer while
                        //System.out.println("Coming here");
                        using_apriori(transaction_number);
}catch (FileNotFoundException e) {
    System.out.println("Unable to open file " + filename);
} catch (IOException e) {
    System.out.println("Unable to read from file " + filename);
}finally {
  
    // Close the file
    try {
 if (input != null)
     input.close();
    } catch (IOException e) {
     System.out.println("Unable to close file " + filename);
    }
  
}
}
}
