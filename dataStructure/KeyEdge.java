package dataStructure;

public class KeyEdge {

	private int src;
	private  int dest;
	
	public KeyEdge(int k1,int k2) {
		this.src=k1;
		this.dest=k2;
		
	}
	
	
	
	
	
	
	
	
	
		
	
	/**
	 * @return the src
	 */
	public int getSrc() {
		return src;
	}











	/**
	 * @return the dest
	 */
	public int getDest() {
		return dest;
	}











	/**
	 * @param src the src to set
	 */
	public void setSrc(int src) {
		this.src = src;
	}











	/**
	 * @param dest the dest to set
	 */
	public void setDest(int dest) {
		this.dest = dest;
	}











	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + src;
		result = prime * result + dest;
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
		if (src != other.src)
			return false;
		if (dest != other.dest)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "KeyEdge [src=" + src + ", dest=" + dest + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
