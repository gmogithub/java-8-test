import java.util.UUID;

public class TestEqualsAndHasCode {

    private final int id;
    private final String code;
    private String name;


    public TestEqualsAndHasCode(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public TestEqualsAndHasCode(int id, String name) {
        this(id, name, UUID.randomUUID().toString());
    }

    public String getCode() {
        return code;
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
