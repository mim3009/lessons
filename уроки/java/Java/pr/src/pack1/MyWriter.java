package pack1;

public class MyWriter implements Runnable {
Info in;
Thread go;
MyWriter (Info in){
this.in = in;
go = new Thread(this);
go.start();
}

public void run() {
// TODO Auto-generated method stub
int n = 0;
Thread t = Thread.currentThread();
while(go == t){
in.setInfo(n);
System.out.print("write " + n);
n++;
}
}

public void stop(){
go = null;
}
}