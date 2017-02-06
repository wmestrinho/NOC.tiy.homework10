package data;

/**
 * Created by WagnerMestrinho on 2/6/17.
 */
public class Agents {
    private String coverName;
    private String realName;
    private int accessLevel;

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String toString(){
        return String.format("(coverName: %s, accessLevel: %d, realName: %s))", getCoverName(), getAccessLevel(), getRealName());
    }
}
