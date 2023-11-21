package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "item")
public class Item {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private int id;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Item() {
        this.value = 0;
    }

    @Getter
    @Setter
    @Column(name = "value", nullable = false)
    private int value;
    @Getter
    @Version
    private long version;


    @Override
    public String toString(){
        return String.format("%d", this.value);
    }


}
