package BankSystem.Model.Accounts;

/**
 * Corporate Account
 */
public class CorporateAccount extends Account {
    private String orgNum; // Organisation number

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }

    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        return null;
    }
}
