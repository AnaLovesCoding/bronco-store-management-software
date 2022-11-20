package domain;

public class Friend {

    private final Integer id;
    private final String name;
    private final int phone;

    public Friend(Integer id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return name + " with ID: " + id + " got phone number: " + phone;
    }
}
