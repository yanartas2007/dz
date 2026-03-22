package _1_5_Homework.Task1;

public class Visitor {
    private String name;
    private String passId;

    public Visitor(String name, String passId) {
        this.name = name;
        this.passId = passId;
    }

    public boolean equals(Visitor other) {
        return getName().equals(other.getName()) && getPassId().equals(other.getPassId());
    }

    public int hashCode() {
        return passId.hashCode();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }
}
