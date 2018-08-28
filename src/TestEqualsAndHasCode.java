public class TestEqualsAndHasCode {
    private int id = 0;
    private String name;


    public TestEqualsAndHasCode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (obj == null) return false;

        if (!(obj instanceof TestEqualsAndHasCode)) return false;

        TestEqualsAndHasCode test = (TestEqualsAndHasCode) obj;

        if (getName() == null) {
            if (test.getName() != null) return false;
        } else {
            if (!getName().equals(test.getName())) return false;
        }

        if (getId() != test.getId()) return false;

        return true;
    }
}
