package day06;
/**
*author:Mr.W
*/
import java.util.Scanner;
//���ַ�С��Ϸ
public class Guessing {
	//������
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate(); //��ȡ����ַ�����
		System.out.println(chs); //����
		int count = 0; //�´�Ĵ���
		while(true){ //������ѭ��
			System.out.println("�°�!");
			String str = scan.next().toUpperCase(); //��ȡ�û�������ַ�������ת��Ϊ��д��ĸ
			if(str.equals("EXIT")){
				System.out.println("�´�������!");
				break;
			}
			char[] input = str.toCharArray(); //���ַ���ת��Ϊ�ַ�����
			int[] result = check(chs,input); //�Ա�:����ַ��������û�������ַ�����
			if(result[0]==chs.length){ //��
				int score = 100*chs.length-10*count; //1���ַ�100�֣��´�һ�ο�10�� 
				System.out.println("��ϲ�㣬�¶��ˣ��÷�Ϊ:"+score);
				break;
			}else{ //��
				count++; //�´������1
				System.out.println("�ַ��Ը���Ϊ:"+result[1]+"��λ�öԸ���Ϊ:"+result[0]);
			}
		}
		
	}
	
	//��������ַ�����
	public static char[] generate(){
		char[] chs = new char[5]; //����ַ�����
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' }; //����ַ���Χ����
		boolean[] flags = new boolean[letters.length]; //��������(��letters���������Ӧ��)
		for(int i=0;i<chs.length;i++){ //��������ַ�����
			int index;
			do{
				index = (int)(Math.random()*letters.length); //����±�(0��25֮��)
			}while(flags[index]==true); //���±�index��Ӧ�Ŀ���Ϊtrueʱ����ʾ�ַ��Ѵ��������������index�±�
			                            //���±�index��Ӧ�Ŀ���Ϊfalseʱ����ʾ�ַ�δ�������ѭ���������洢��Ӧ���ַ�
			chs[i] = letters[index]; //�����±�index��letters�л�ȡ�ַ�������ֵ��chs�е�ÿһ��Ԫ��
			flags[index] = true; //���±�index��Ӧ�Ŀ����޸�Ϊtrue����ʾ�Ѵ��
		}
		return chs;
	}
	
	//�Ա�:����ַ��������û�������ַ�����
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2]; //�ԱȽ��(����result[0]Ϊλ�öԣ�result[1]Ϊ�ַ��ԣ�Ĭ�϶���0)
		for(int i=0;i<chs.length;i++){ //��������ַ�����
			for(int j=0;j<input.length;j++){ //�����û�������ַ�����
				if(chs[i]==input[j]){ //�ַ���
					result[1]++; //�ַ��Ը�����1
					if(i==j){ //λ�ö�
						result[0]++; //λ�öԸ�����1
					}
					break; //ʣ��inputԪ�ز��ٲ���Ƚ���
				}
			}
		}
		return result;
	}
	
}





















