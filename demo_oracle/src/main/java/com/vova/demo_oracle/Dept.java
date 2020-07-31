package com.vova.demo_oracle;

public class Dept {
    private Short eptno;

    private String dname;

    private String loc;

    public Short getEptno() {
        return eptno;
    }

    public void setEptno(Short eptno) {
        this.eptno = eptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }
}