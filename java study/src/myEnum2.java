
public enum myEnum2 {
	A("a",1,"aa"), B("b",2,"bb"), C("c",3,"cc");
    private int index;
	private String name;
	private String name2;
	// 构造方法
    private myEnum2(String name, int index, String name2) {
        this.name = name;
        this.index = index;
        this.name2 = name2;
    }
    // 普通方法
    public static String getName(int index) {
        for (myEnum2 c : myEnum2.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }
    public String getName2() {
        return name2;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }
	int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}
}
