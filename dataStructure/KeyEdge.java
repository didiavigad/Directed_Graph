package dataStructure;

public class KeyEdge {

	private int key1;
	private  int key2;
	
	public KeyEdge(int k1,int k2) {
		this.key1=k1;
		this.key2=k2;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key1;
		result = prime * result + key2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof KeyEdge))
			return false;
		KeyEdge other = (KeyEdge) obj;
		if (key1 != other.key1)
			return false;
		if (key2 != other.key2)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
