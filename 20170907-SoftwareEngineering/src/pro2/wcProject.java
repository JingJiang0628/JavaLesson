package pro2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实现能计算一个文本的字符数，单词数和行数的功能
 * @author PC
 *
 */

public class wcProject {

	private static int charcalculate=0; 
	private static int wordcalculate=0; 
	private static int linecalculate=0;
	 
	//解析字符数，单词数，行数，空格数
	public static void calculate2() {
		String str="";
		int words = 0;//单词数
		int chars = 0;//字母数
		int lines = 0;//行数
		int spaces=0;//空格数
		int marks=0;//标点数
		int c=0;//字符数
		int t=0;//\t
		int count=0;

		FileInputStream fis=null;
		BufferedReader br=null;
		try {
			File file = new File("aaa.txt");
				if (file.exists()){//判断文件是否存在
					//打开文件输入流
					fis=new FileInputStream(file);
					//字符流写入了缓冲区
					br=new BufferedReader(new InputStreamReader(fis));
					while((str=br.readLine())!=null){//readLine()每次读取一行，转化为字符串，br.readLine()为null时，不执行
						char[] b=str.toCharArray();//将字符串对象中的字符转换为一个字符数组
						for (int i = 0; i < str.length(); i++) {
//							System.out.println("b[i]--"+b[i]);
							if(b[i]!=' '&&b[i]!='\n'&&b[i]!='\t'&&b[i]!=','&&b[i]!='.'&&b[i]!='!'&&b[i]!=';'&&b[i]!='='){
								chars++;
					            if(count>=1){
					            	count=0;
					            }
					        }
					        if(b[i]==' '||b[i]=='\n'||b[i]=='\t'||b[i]==','||b[i]=='.'||b[i]=='!'||b[i]=='='||b[i]==';'){
					        	if(b[i]==' '){
					        		spaces++;
					        	}
					        	if(b[i]=='\t'){
					        		t++;
					        	}
					        	if (b[i]==','||b[i]=='.'||b[i]=='?'||b[i]=='!'||b[i]==';'){
									marks++;
								}
					        	
					        	words++;System.out.println("b[i]--"+b[i]+"--words--"+words);
					            count++;
					            if(count>1){
					            	words--;
					            }
					        }
						}
						lines++;//行数（由于每次读取一行，行数自加即可）
						c=chars+spaces+marks+t;
					}
					//关闭文件
					br.close();
					System.out.println("字符数："+c+"单词数："+(words+lines)+",字母数："+chars+",行数："+lines+",标点数："+marks+",空格数："+spaces);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void calculate1() throws IOException
	{
		FileInputStream fis=new FileInputStream("aaa.txt");
		FileOutputStream fos=new FileOutputStream("bbb.txt");
			
		byte[] b=new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1){
			String str=new String(b,0,len); 
//			System.out.println(str);
			String a=str.replace(" ",",");
			fos.write(a.getBytes());
		}	
			
		FileInputStream fis1=new FileInputStream("bbb.txt");
		int a;
		int count=0;
		while((a=fis1.read())!=-1){
			if(a!=' '&&a!='\n'&&a!='\t'&&a!=','&&a!='.'&&a!='!'&&a!=';'&&a!='='){
//		        System.out.println("c--"+(char)a);
				charcalculate++;
				if(count>=1){
//		            System.out.println("count--");
		            count=0;
		        }
		    }
		    if(a==' '||a=='\n'||a=='\t'||a==','||a=='.'||a=='!'||a=='='||a==';'){
//		       	System.out.println("w--"+(char)a);
		        wordcalculate++;
		        count++;
		        if(count>1){
//		            System.out.println("wordcalculate--");
		            wordcalculate--;
		        }
		    }
		    if(a=='\n'){
//		        System.out.println("l--"+(char)a);
		        linecalculate++;
//		        count--;
		    }
		}
		charcalculate=charcalculate-linecalculate;	
		linecalculate++;
		   
		fis.close();
		fos.close();
		    
	}		
	
	//解析字符数，单词数，行数，空格数
    public static void analysis() {
        String str="";

        int words = 0;//单词数
        int chars = 0;//字符数
        int lines = 0;//行数
        int spaces=0;//空格数
        int marks=0;//标点符号数
        int character=0;//字母数

        FileInputStream fis=null;
        BufferedReader br=null;
        try {
            File file = new File("aaa.txt");
            if (file.exists()){//判断文件是否存在
                //打开文件输入流
                fis=new FileInputStream(file);
                //字符流写入了缓冲区
                br=new BufferedReader(new InputStreamReader(fis));

                while((str=br.readLine())!=null){//readLine()每次读取一行，转化为字符串，br.readLine()为null时，不执行

                    char[] b=str.toCharArray();//将字符串对象中的字符转换为一个字符数组
                    for (int i = 0; i < str.length(); i++) {
                        if (b[i]==' ' ){//如果字符数组中包含空格，spaces自加1
                            spaces++;//空格数
                        }else if (b[i]==','||b[i]=='.'||b[i]=='?'||b[i]=='!'){
                            marks++;
                        }
                    }
                    //

                    //单词数，split()方法,返回是一个数组，根据(空格,标点符号）分割成字符串数组，数组长度就是单词长度。
                    //words+=str.split("[ \\.,]").length;//使用正则表达式实现多个分隔符进行分隔的效果。
                   int flag=0;
                    for (int i=0;i<str.length();i++){
                        if ((b[i]>=65&&b[i]<=90)||(b[i]>=97&&b[i]<=125)){
                            flag = 1;
                            //说明是单词，就不处理
                        }else{
                            //说明遇到了不是字符的东西了，表明单词结束了
                            //但是只能进来一次，应为“aaaa....vvv这样才不会以标点符号的数目来确定单词数”
                            if(flag==1){
                                words += words;
                            }
                        }
                    }
                    chars+=str.length();//字符串的长度，即字符数，包括英文字母数+空格数+标点数
                    lines++;//行数（由于每次读取一行，行数自加即可）
                }
                character=chars-(spaces+marks);//字母数=字符数-空格数-标点数
                //关闭文件
                br.close();

                System.out.println("单词数："+words+",字符数："+chars+",行数："+lines+",字母数："+character+",空格数："+spaces+"，标点符号数："+marks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) throws IOException{
//		calculate2();
		
//		calculate1();
//		System.out.println("CharNum:"+charcalculate);
//		System.out.println("WordNum:"+wordcalculate);
//		System.out.println("LineNum:"+linecalculate);
		
//		analysis();
	}


}
