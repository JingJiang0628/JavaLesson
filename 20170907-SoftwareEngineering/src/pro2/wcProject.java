package pro2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ʵ���ܼ���һ���ı����ַ������������������Ĺ���
 * @author PC
 *
 */

public class wcProject {

	private static int charcalculate=0; 
	private static int wordcalculate=0; 
	private static int linecalculate=0;
	 
	//�����ַ��������������������ո���
	public static void calculate2() {
		String str="";
		int words = 0;//������
		int chars = 0;//��ĸ��
		int lines = 0;//����
		int spaces=0;//�ո���
		int marks=0;//�����
		int c=0;//�ַ���
		int t=0;//\t
		int count=0;

		FileInputStream fis=null;
		BufferedReader br=null;
		try {
			File file = new File("aaa.txt");
				if (file.exists()){//�ж��ļ��Ƿ����
					//���ļ�������
					fis=new FileInputStream(file);
					//�ַ���д���˻�����
					br=new BufferedReader(new InputStreamReader(fis));
					while((str=br.readLine())!=null){//readLine()ÿ�ζ�ȡһ�У�ת��Ϊ�ַ�����br.readLine()Ϊnullʱ����ִ��
						char[] b=str.toCharArray();//���ַ��������е��ַ�ת��Ϊһ���ַ�����
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
						lines++;//����������ÿ�ζ�ȡһ�У������ԼӼ��ɣ�
						c=chars+spaces+marks+t;
					}
					//�ر��ļ�
					br.close();
					System.out.println("�ַ�����"+c+"��������"+(words+lines)+",��ĸ����"+chars+",������"+lines+",�������"+marks+",�ո�����"+spaces);
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
	
	//�����ַ��������������������ո���
    public static void analysis() {
        String str="";

        int words = 0;//������
        int chars = 0;//�ַ���
        int lines = 0;//����
        int spaces=0;//�ո���
        int marks=0;//��������
        int character=0;//��ĸ��

        FileInputStream fis=null;
        BufferedReader br=null;
        try {
            File file = new File("aaa.txt");
            if (file.exists()){//�ж��ļ��Ƿ����
                //���ļ�������
                fis=new FileInputStream(file);
                //�ַ���д���˻�����
                br=new BufferedReader(new InputStreamReader(fis));

                while((str=br.readLine())!=null){//readLine()ÿ�ζ�ȡһ�У�ת��Ϊ�ַ�����br.readLine()Ϊnullʱ����ִ��

                    char[] b=str.toCharArray();//���ַ��������е��ַ�ת��Ϊһ���ַ�����
                    for (int i = 0; i < str.length(); i++) {
                        if (b[i]==' ' ){//����ַ������а����ո�spaces�Լ�1
                            spaces++;//�ո���
                        }else if (b[i]==','||b[i]=='.'||b[i]=='?'||b[i]=='!'){
                            marks++;
                        }
                    }
                    //

                    //��������split()����,������һ�����飬����(�ո�,�����ţ��ָ���ַ������飬���鳤�Ⱦ��ǵ��ʳ��ȡ�
                    //words+=str.split("[ \\.,]").length;//ʹ��������ʽʵ�ֶ���ָ������зָ���Ч����
                   int flag=0;
                    for (int i=0;i<str.length();i++){
                        if ((b[i]>=65&&b[i]<=90)||(b[i]>=97&&b[i]<=125)){
                            flag = 1;
                            //˵���ǵ��ʣ��Ͳ�����
                        }else{
                            //˵�������˲����ַ��Ķ����ˣ��������ʽ�����
                            //����ֻ�ܽ���һ�Σ�ӦΪ��aaaa....vvv�����Ų����Ա����ŵ���Ŀ��ȷ����������
                            if(flag==1){
                                words += words;
                            }
                        }
                    }
                    chars+=str.length();//�ַ����ĳ��ȣ����ַ���������Ӣ����ĸ��+�ո���+�����
                    lines++;//����������ÿ�ζ�ȡһ�У������ԼӼ��ɣ�
                }
                character=chars-(spaces+marks);//��ĸ��=�ַ���-�ո���-�����
                //�ر��ļ�
                br.close();

                System.out.println("��������"+words+",�ַ�����"+chars+",������"+lines+",��ĸ����"+character+",�ո�����"+spaces+"������������"+marks);
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
