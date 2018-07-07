package dimens.constants;

public enum DimenHeight {

    //生成高度,填入自己计算的DP,填入的顺序要对应
    DP_sh__436(436),
    DP_sh__466(466),
    DP_sh__552(552),
    DP_sh__656(656);

    /**
     * 屏幕最小高度
     */
    private int shHeightDp;

    DimenHeight(int swWidthDp) {
        this.shHeightDp = swWidthDp;
    }

    public int getShHeightDp() {
        return shHeightDp;
    }

    public void setShHeightDp(int shHeightDp) {
        this.shHeightDp = shHeightDp;
    }
}
