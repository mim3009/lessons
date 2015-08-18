package sd;

public class run {
	public static void main(String[] args){
		 int[] a = {800, 1500, 2200, 2700, 3200};
	        String[] b = {"первый", "второй", "третий", "четвертый", "п€тый"};
	        System.out.println("ћен€ зовут јмиго.");
	         System.out.println(" ");
	        for(int i = 0; i < 5 ; i++){
	            if(i==1){
	            System.out.println("я согласен на зарплату $" + a[i] + "/мес€ц во " + b[i] + " год.");
	            }else{
	            System.out.println("я согласен на зарплату $" + a[i] + "/мес€ц в " + b[i] + " год.");}
	        }
	        System.out.println(" ");
	        System.out.println("ѕоцелуй мой блест€щий металический зад!");
	    }
}
