package dimens.constants;


public enum DimenWidths {

    //生成宽度,填入自己计算的DP,填入的顺序要对应
    DP_sw__291(291),
    DP_sw__320(320),
    DP_sw__331(331),
    DP_sw__369(369);

    // 想生成多少自己以此类推


    /**
     * 屏幕最小宽度
     */
    private int swWidthDp;


    DimenWidths(int swWidthDp) {
        this.swWidthDp = swWidthDp;
    }


    public int getSwWidthDp() {
        return swWidthDp;
    }

    public void setSwWidthDp(int swWidthDp) {
        this.swWidthDp = swWidthDp;
    }

}
