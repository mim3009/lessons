package pack1;

public class Info {// ����� �� � ������ ������
// ��������� ��� ���������� ����������
	int info = 0;
	boolean ready;

	synchronized public int getInfo() {
		try {
			if (!ready) {
				wait();
			} else {
				ready = false;
				return info;
			}

		} catch (InterruptedException e) {
		} finally {
			notify();
		}
		return -1;
	}

	synchronized public void setInfo(int n) {
		info = n;
		ready = true;
		notify();
	}
}