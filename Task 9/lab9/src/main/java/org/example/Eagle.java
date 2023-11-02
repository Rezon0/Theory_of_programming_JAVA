package org.example;
@Table(title = "Eagle")
public class Eagle {
    public enum Types{
        КРУТОЙ, БОЛЬШОЙ, КРАСИВЫЙ, ВЕЛИКОЛЕПНЫЙ;
        public String getColor () {return this.toString();}
    }
    @Column
    private String name;

  //  @Column
    private int age;

    @Column
    private Types type;

    public Eagle(String name, int age, Types types) {
        this.name = name;
        this.age = age;
        this.type = Types.valueOf(types.getColor());
    }
}
