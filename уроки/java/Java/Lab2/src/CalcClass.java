
public class CalcClass {
	
	public static String ObjArToString(Object[] array){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<array.length; i++){
			sb.append(array[i]);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void sort(Comparable[] mb){
		int last = mb.length;
		boolean exit = false;
		while (!exit){
			exit = true;
			last--;
			for (int i = 0; i< last; i++){
				if (mb[i].compareTo(mb[i+1])> 0 ){
					Comparable tmp = mb[i];
					mb[i]=mb[i+1];
					mb[i+1]=tmp;
					exit = false;
					}
			}
		}
	}
private static double nextU(double u, double x, int i) throws Exception{
		 if (x<=1) throw new Exception("x must be >1");
		return u*x*x/(2*i-2)/(2*i-1);
};
		public static double calcSinh(double x, double e) throws Exception{
			double u = x;
			double sum = u;
			int i = 1;
			while (Math.abs(u) > e){
				i++;
				u = nextU(u,x,i);
				sum += u;
			}
			return sum;
		}

}
