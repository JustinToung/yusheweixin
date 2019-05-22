package cn.java.entity;

public class PersonEntity {
    private String name;
    private String sex;
    private int age;
    public PersonEntity(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    @Override
	public String toString() {
		return "PersonEntity [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
   
}
