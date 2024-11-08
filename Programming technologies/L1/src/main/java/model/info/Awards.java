package model.info;

public class Awards {
    private String award;

//    public Awards(String textContent) {
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("award");
//        sb.append((this.award == null) ? "null" : this.award);
//        return sb.toString();
//    }

    public Awards(String award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return award;
    }

    public String getAward() {
        return award;
    }
}
