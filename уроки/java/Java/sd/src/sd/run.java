package sd;

public class run {
	public static void main(String[] args){
		 int[] a = {800, 1500, 2200, 2700, 3200};
	        String[] b = {"������", "������", "������", "���������", "�����"};
	        System.out.println("���� ����� �����.");
	         System.out.println(" ");
	        for(int i = 0; i < 5 ; i++){
	            if(i==1){
	            System.out.println("� �������� �� �������� $" + a[i] + "/����� �� " + b[i] + " ���.");
	            }else{
	            System.out.println("� �������� �� �������� $" + a[i] + "/����� � " + b[i] + " ���.");}
	        }
	        System.out.println(" ");
	        System.out.println("������� ��� ��������� ������������ ���!");
	    }
}
