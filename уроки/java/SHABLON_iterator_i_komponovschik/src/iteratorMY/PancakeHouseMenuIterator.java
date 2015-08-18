package iteratorMY;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator{

	ArrayList items;
	int i = 0;
	
	public PancakeHouseMenuIterator(ArrayList items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		if(i >= items.size() || items.get(i) == null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Object next() {
		MenuItem menuItem = (MenuItem) items.get(i);
		i++;
		return menuItem;
	}

}
