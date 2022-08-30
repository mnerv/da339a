package Task01;

public class LoginHandler {
    private Login[] loginList;
    private int listCount;

    public LoginHandler(int maxElements) {
        loginList = new Login[maxElements];
        this.listCount = 0;
    }

    public boolean addNew(Login login) {
        if (listCount > loginList.length - 1)
            return false;
        loginList[listCount] = login;

        listCount++;
        return true;
    }

    public boolean deleteAt(int index) {
        if (index > -1 && index < loginList.length) {
            loginList[index] = null;

            int nullCount = 0;
            for (int i = 0; i < loginList.length; i++) {
                nullCount += loginList[i] == null ? 1 : 0;
            }

            listCount = loginList.length - nullCount;

            for (int i = 0; i < loginList.length - 1; i++) {
                if (loginList[i] == null) {
                    Login tmp = loginList[i];
                    loginList[i] = loginList[i + 1];
                    loginList[i + 1] = tmp;
                }

                if (i == loginList.length - 2 && nullCount > 0) {
                    nullCount--;
                    i = 0;
                }
            }

            return true;
        }

        return false;
    }

    public int getCount() {
        return listCount;
    }

    public void printList() {
        for (int i = 0; i < loginList.length; i++) {
            System.out.println(loginList[i]);
        }
    }

}
