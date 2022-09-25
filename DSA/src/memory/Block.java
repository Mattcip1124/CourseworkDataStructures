package memory;

public class Block {

	int start, size;
	
	public Block(int start, int size) {
		this.start = start;
		this.size = size;
	}
	
	public String toString() {
		return "start:" + start + " size:" + size;
	}
}
