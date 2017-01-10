package com.example.androidsp.appgplx.BtnDethi;

/**
 * Created by Androidsp on 23/12/2016.
 */

public class ObjItemBox {
    public boolean answer;
    public int indexAns;

    /**
     * @param answer xac dinh da chon dap an chua?
     * @param indexAns xac dinh dap an chon khi hien thi ket qua
     *                 1 -  tra loi dung
     *                 2 -  tra loi sai
     *                 3 -  chua chon
     *                 4 -  chon nhung chua xem xet qua
     */

    public ObjItemBox() {
    }

    public ObjItemBox(boolean answer, int indexAns) {
        this.answer = answer;
        this.indexAns = indexAns;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public int getIndexAns() {
        return indexAns;
    }

    public void setIndexAns(int indexAns) {
        this.indexAns = indexAns;
    }
}
